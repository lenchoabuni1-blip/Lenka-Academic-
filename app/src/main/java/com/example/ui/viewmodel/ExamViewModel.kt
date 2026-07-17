package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.AnswerHistoryEntity
import com.example.data.local.ExamDatabase
import com.example.data.local.MockAttemptEntity
import com.example.data.model.Question
import com.example.data.repository.ExamRepository
import com.example.data.repository.QuestionRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

sealed interface Screen {
    object Dashboard : Screen
    object BookmarksList : Screen
    object HistoryList : Screen
    data class Quiz(
        val title: String,
        val isMock: Boolean,
        val chapterId: Int? = null // null means mixed / mock / bookmarks
    ) : Screen
}

data class QuizSessionState(
    val questions: List<Question> = emptyList(),
    val currentIndex: Int = 0,
    val selectedOptionMap: Map<Int, String> = emptyMap(), // questionId -> "A", "B", "C", "D"
    val isSubmittedMap: Map<Int, Boolean> = emptyMap(), // questionId -> True (locked & showing answers)
    val isMockFinished: Boolean = false,
    val mockTimeRemainingSeconds: Int = 1800, // 30 minutes for mock exam
    val score: Int = 0
)

class ExamViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ExamRepository
    init {
        val database = ExamDatabase.getDatabase(application)
        repository = ExamRepository(database.examDao())
    }

    // Navigation and screen management
    private val _currentScreen = MutableStateFlow<Screen>(Screen.Dashboard)
    val currentScreen: StateFlow<Screen> = _currentScreen.asStateFlow()

    // Active Quiz Session State
    private val _quizSession = MutableStateFlow(QuizSessionState())
    val quizSession: StateFlow<QuizSessionState> = _quizSession.asStateFlow()

    // Timer Job for Mock Exam
    private var timerJob: Job? = null

    // Room Persistent States
    val bookmarkedIds: StateFlow<List<Int>> = repository.bookmarkedQuestionIds
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val answerHistory: StateFlow<List<AnswerHistoryEntity>> = repository.answerHistory
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val mockAttempts: StateFlow<List<MockAttemptEntity>> = repository.mockAttempts
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // UI Progress State combining static questions with answer history
    val chapterProgress: StateFlow<Map<Int, Int>> = answerHistory.map { history ->
        val map = mutableMapOf<Int, Int>()
        for (chapter in 1..4) {
            val totalChQuestions = QuestionRepository.getQuestionsForChapter(chapter).size
            val solvedChQuestions = history.filter { h ->
                val q = QuestionRepository.getQuestionById(h.questionId)
                q?.chapter == chapter
            }.size
            val percent = if (totalChQuestions > 0) (solvedChQuestions * 100) / totalChQuestions else 0
            map[chapter] = percent
        }
        map
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), mapOf(1 to 0, 2 to 0, 3 to 0, 4 to 0))

    fun navigateTo(screen: Screen) {
        // Stop timer if moving away from mock quiz
        if (screen !is Screen.Quiz || !screen.isMock) {
            stopTimer()
        }
        _currentScreen.value = screen
    }

    // Starts a new study/quiz session
    fun startChapterStudy(chapterId: Int) {
        val chapterTitle = when (chapterId) {
            1 -> "Chapter 1: Software Engineering"
            2 -> "Chapter 2: Database Systems"
            3 -> "Chapter 3: Computer Networks"
            4 -> "Chapter 4: Operating Systems"
            else -> "Chapter $chapterId"
        }
        val questions = QuestionRepository.getQuestionsForChapter(chapterId)
        _quizSession.value = QuizSessionState(
            questions = questions,
            currentIndex = 0,
            selectedOptionMap = emptyMap(),
            isSubmittedMap = emptyMap(),
            isMockFinished = false
        )
        navigateTo(Screen.Quiz(title = chapterTitle, isMock = false, chapterId = chapterId))
    }

    // Starts a mixed mock exam
    fun startMockExam() {
        val questions = QuestionRepository.getRandomMockExam(25) // 25 random questions from all chapters
        _quizSession.value = QuizSessionState(
            questions = questions,
            currentIndex = 0,
            selectedOptionMap = emptyMap(),
            isSubmittedMap = emptyMap(),
            isMockFinished = false,
            mockTimeRemainingSeconds = 1200 // 20 minutes for 25 questions
        )
        startTimer()
        navigateTo(Screen.Quiz(title = "Mock Exam Simulator", isMock = true))
    }

    // Starts study for bookmarked questions
    fun startBookmarksStudy() {
        val ids = bookmarkedIds.value
        val questions = QuestionRepository.getAllQuestions().filter { it.id in ids }
        if (questions.isEmpty()) return // Do nothing if no bookmarks

        _quizSession.value = QuizSessionState(
            questions = questions,
            currentIndex = 0,
            selectedOptionMap = emptyMap(),
            isSubmittedMap = emptyMap(),
            isMockFinished = false
        )
        navigateTo(Screen.Quiz(title = "Review Bookmarks", isMock = false))
    }

    // Quiz Session Actions
    fun selectOption(questionId: Int, option: String) {
        val state = _quizSession.value
        // If chapter study, only allow selection before submitting
        val isSubmitted = state.isSubmittedMap[questionId] ?: false
        if (!state.isMockFinished && !isSubmitted) {
            _quizSession.value = state.copy(
                selectedOptionMap = state.selectedOptionMap + (questionId to option)
            )

            // In Chapter Study Mode, submit immediately so they see explanations
            val activeScreen = _currentScreen.value
            if (activeScreen is Screen.Quiz && !activeScreen.isMock) {
                submitAnswer(questionId, option)
            }
        }
    }

    private fun submitAnswer(questionId: Int, option: String) {
        val state = _quizSession.value
        val question = state.questions.find { it.id == questionId } ?: return
        val isCorrect = question.correctOption == option

        _quizSession.value = state.copy(
            isSubmittedMap = state.isSubmittedMap + (questionId to true)
        )

        // Save progress to database
        viewModelScope.launch {
            repository.saveAnswer(questionId, option, isCorrect)
        }
    }

    fun submitMockExam() {
        stopTimer()
        val state = _quizSession.value
        var correctCount = 0
        state.questions.forEach { q ->
            val selected = state.selectedOptionMap[q.id]
            if (selected == q.correctOption) {
                correctCount++
            }
        }

        val updatedIsSubmitted = state.questions.associate { it.id to true }

        _quizSession.value = state.copy(
            isMockFinished = true,
            isSubmittedMap = updatedIsSubmitted,
            score = correctCount
        )

        // Save attempt to database
        val durationTaken = 1200 - state.mockTimeRemainingSeconds
        viewModelScope.launch {
            repository.saveMockAttempt(correctCount, state.questions.size, durationTaken)
        }
    }

    fun nextQuestion() {
        val state = _quizSession.value
        if (state.currentIndex < state.questions.size - 1) {
            _quizSession.value = state.copy(currentIndex = state.currentIndex + 1)
        }
    }

    fun previousQuestion() {
        val state = _quizSession.value
        if (state.currentIndex > 0) {
            _quizSession.value = state.copy(currentIndex = state.currentIndex - 1)
        }
    }

    fun jumpToQuestion(index: Int) {
        val state = _quizSession.value
        if (index in state.questions.indices) {
            _quizSession.value = state.copy(currentIndex = index)
        }
    }

    fun toggleBookmark(questionId: Int) {
        val isBookmarked = bookmarkedIds.value.contains(questionId)
        viewModelScope.launch {
            repository.toggleBookmark(questionId, isBookmarked)
        }
    }

    fun resetAllProgress() {
        viewModelScope.launch {
            repository.clearHistory()
            repository.clearMockAttempts()
        }
    }

    // Timer management
    private fun startTimer() {
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            while (_quizSession.value.mockTimeRemainingSeconds > 0 && !_quizSession.value.isMockFinished) {
                delay(1000)
                val state = _quizSession.value
                _quizSession.value = state.copy(
                    mockTimeRemainingSeconds = state.mockTimeRemainingSeconds - 1
                )
            }
            if (_quizSession.value.mockTimeRemainingSeconds <= 0 && !_quizSession.value.isMockFinished) {
                submitMockExam()
            }
        }
    }

    private fun stopTimer() {
        timerJob?.cancel()
        timerJob = null
    }

    override fun onCleared() {
        super.onCleared()
        stopTimer()
    }
}

