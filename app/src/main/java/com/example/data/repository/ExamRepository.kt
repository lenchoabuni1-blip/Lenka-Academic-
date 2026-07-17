package com.example.data.repository

import com.example.data.local.AnswerHistoryEntity
import com.example.data.local.BookmarkEntity
import com.example.data.local.ExamDao
import com.example.data.local.MockAttemptEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ExamRepository(private val examDao: ExamDao) {

    val bookmarkedQuestionIds: Flow<List<Int>> = examDao.getAllBookmarks()
        .map { bookmarks -> bookmarks.map { it.questionId } }

    val answerHistory: Flow<List<AnswerHistoryEntity>> = examDao.getAllAnswerHistory()

    val mockAttempts: Flow<List<MockAttemptEntity>> = examDao.getAllMockAttempts()

    suspend fun toggleBookmark(questionId: Int, isCurrentlyBookmarked: Boolean) {
        if (isCurrentlyBookmarked) {
            examDao.deleteBookmark(questionId)
        } else {
            examDao.insertBookmark(BookmarkEntity(questionId))
        }
    }

    suspend fun saveAnswer(questionId: Int, selectedOption: String, isCorrect: Boolean) {
        examDao.insertAnswerHistory(
            AnswerHistoryEntity(
                questionId = questionId,
                selectedOption = selectedOption,
                isCorrect = isCorrect
            )
        )
    }

    suspend fun clearHistory() {
        examDao.clearAnswerHistory()
    }

    suspend fun saveMockAttempt(score: Int, total: Int, durationSeconds: Int) {
        examDao.insertMockAttempt(
            MockAttemptEntity(
                score = score,
                totalQuestions = total,
                durationSeconds = durationSeconds
            )
        )
    }

    suspend fun clearMockAttempts() {
        examDao.clearMockAttempts()
    }
}
