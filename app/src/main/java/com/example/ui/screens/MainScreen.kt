package com.example.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.local.AnswerHistoryEntity
import com.example.data.local.MockAttemptEntity
import com.example.data.model.Question
import com.example.data.repository.QuestionRepository
import com.example.ui.viewmodel.ExamViewModel
import com.example.ui.viewmodel.QuizSessionState
import com.example.ui.viewmodel.Screen
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: ExamViewModel) {
    val currentScreen by viewModel.currentScreen.collectAsState()
    val quizSession by viewModel.quizSession.collectAsState()
    val bookmarkedIds by viewModel.bookmarkedIds.collectAsState()
    val answerHistory by viewModel.answerHistory.collectAsState()
    val mockAttempts by viewModel.mockAttempts.collectAsState()
    val chapterProgress by viewModel.chapterProgress.collectAsState()

    var showResetDialog by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets.safeDrawing
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF0D1117), // Rich dark slate
                            Color(0xFF161B22)  // Dark carbon
                        )
                    )
                )
        ) {
            AnimatedContent(
                targetState = currentScreen,
                transitionSpec = {
                    fadeIn(animationSpec = tween(220)) togetherWith fadeOut(animationSpec = tween(220))
                },
                label = "ScreenTransition"
            ) { screen ->
                when (screen) {
                    is Screen.Dashboard -> DashboardContent(
                        chapterProgress = chapterProgress,
                        bookmarkedCount = bookmarkedIds.size,
                        mockAttempts = mockAttempts,
                        onChapterClick = { viewModel.startChapterStudy(it) },
                        onMockClick = { viewModel.startMockExam() },
                        onBookmarksClick = { viewModel.startBookmarksStudy() },
                        onResetProgress = { showResetDialog = true }
                    )
                    is Screen.Quiz -> QuizContent(
                        title = screen.title,
                        isMock = screen.isMock,
                        sessionState = quizSession,
                        bookmarkedIds = bookmarkedIds,
                        onSelectOption = { qId, opt -> viewModel.selectOption(qId, opt) },
                        onNext = { viewModel.nextQuestion() },
                        onPrevious = { viewModel.previousQuestion() },
                        onJumpTo = { viewModel.jumpToQuestion(it) },
                        onToggleBookmark = { viewModel.toggleBookmark(it) },
                        onSubmitMock = { viewModel.submitMockExam() },
                        onBack = { viewModel.navigateTo(Screen.Dashboard) }
                    )
                    is Screen.BookmarksList -> Box(modifier = Modifier.fillMaxSize()) // Fallback
                    is Screen.HistoryList -> Box(modifier = Modifier.fillMaxSize()) // Fallback
                }
            }

            if (showResetDialog) {
                AlertDialog(
                    onDismissRequest = { showResetDialog = false },
                    title = { Text("Reset All Progress?") },
                    text = { Text("This will permanently delete all your quiz history, custom bookmarks, and mock exam scorecards. Are you sure you want to start fresh?") },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                viewModel.resetAllProgress()
                                showResetDialog = false
                            },
                            colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.error)
                        ) {
                            Text("Reset", fontWeight = FontWeight.Bold)
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = { showResetDialog = false }) {
                            Text("Cancel")
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun DashboardContent(
    chapterProgress: Map<Int, Int>,
    bookmarkedCount: Int,
    mockAttempts: List<MockAttemptEntity>,
    onChapterClick: (Int) -> Unit,
    onMockClick: () -> Unit,
    onBookmarksClick: () -> Unit,
    onResetProgress: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        contentPadding = PaddingValues(vertical = 20.dp)
    ) {
        // App Title Section
        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "ExitExamPro",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif,
                    letterSpacing = 0.5.sp
                )
                Text(
                    text = "University exit exam preparation portal",
                    fontSize = 14.sp,
                    color = Color(0xFF8B949E),
                    fontFamily = FontFamily.SansSerif
                )
            }
        }

        // Hero Image & Stats Banner
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(16.dp))
            ) {
                // Background generated image banner
                Image(
                    painter = painterResource(id = R.drawable.img_hero_banner_1784327357580),
                    contentDescription = "Academic background visual art",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                // Dark ambient gradient overlay for text readability
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color(0xCC000000)
                                )
                            )
                        )
                )

                // Superimposed info overlay
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        text = "Computer Science Exit Exam Core Chapters",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Chapters 1 to 4 fully loaded. 120+ terminology & scenario questions complete with thorough options analysis.",
                        fontSize = 11.sp,
                        color = Color(0xFFC9D1D9)
                    )
                }
            }
        }

        // Action Quick Deck (Mock Exam + Bookmarks)
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Mock Exam Card
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .height(100.dp)
                        .clickable { onMockClick() }
                        .testTag("start_mock_exam_card"),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF1F6FEB))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Icon(
                            imageVector = Icons.Default.Timer,
                            contentDescription = "Timer icon",
                            tint = Color.White
                        )
                        Column {
                            Text(
                                text = "Mock Exam",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = "25 Mixed Questions",
                                fontSize = 11.sp,
                                color = Color(0xCCFFFFFF)
                            )
                        }
                    }
                }

                // Bookmarks Card
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .height(100.dp)
                        .clickable { if (bookmarkedCount > 0) onBookmarksClick() },
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (bookmarkedCount > 0) Color(0xFF238636) else Color(0xFF21262D)
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Icon(
                            imageVector = Icons.Default.Bookmark,
                            contentDescription = "Bookmark icon",
                            tint = if (bookmarkedCount > 0) Color.White else Color(0xFF8B949E)
                        )
                        Column {
                            Text(
                                text = "Revision Deck",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (bookmarkedCount > 0) Color.White else Color(0xFF8B949E)
                            )
                            Text(
                                text = "$bookmarkedCount bookmarked items",
                                fontSize = 11.sp,
                                color = if (bookmarkedCount > 0) Color(0xCCFFFFFF) else Color(0xFF8B949E)
                            )
                        }
                    }
                }
            }
        }

        // Chapters List Label
        item {
            Text(
                text = "STUDY BY CHAPTERS",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF58A6FF),
                letterSpacing = 1.sp
            )
        }

        // Chapter grid cards
        val chapters = listOf(
            Triple(1, "Chapter 1: Software Engineering", "Agile, OOAD, Design Patterns, QA & Testing"),
            Triple(2, "Chapter 2: Database Systems", "SQL, Normalization, ACID Transactions, Indexing, NoSQL"),
            Triple(3, "Chapter 3: Computer Networks", "OSI, TCP/UDP, IP Subnetting, Security Ciphers"),
            Triple(4, "Chapter 4: Operating Systems", "CPU Schedulers, Virtual Memory, Deadlocks, Mutex")
        )

        items(chapters) { (id, title, desc) ->
            val progress = chapterProgress[id] ?: 0
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onChapterClick(id) }
                    .testTag("chapter_card_$id"),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF161B22)),
                border = CardDefaults.outlinedCardBorder().copy(
                    brush = Brush.horizontalGradient(listOf(Color(0xFF30363D), Color(0xFF30363D)))
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Chapter icon
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(Color(0xFF21262D), shape = RoundedCornerShape(12.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Ch $id",
                            color = Color(0xFF58A6FF),
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 14.sp
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    // Title & Progress info
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = title,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = desc,
                            fontSize = 11.sp,
                            color = Color(0xFF8B949E),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            LinearProgressIndicator(
                                progress = { progress / 100f },
                                modifier = Modifier
                                    .weight(1f)
                                    .height(6.dp)
                                    .clip(CircleShape),
                                color = Color(0xFF58A6FF),
                                trackColor = Color(0xFF21262D)
                            )
                            Text(
                                text = "$progress%",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF58A6FF)
                            )
                        }
                    }
                }
            }
        }

        // Recent Mock History Label
        if (mockAttempts.isNotEmpty()) {
            item {
                Text(
                    text = "MOCK EXAM HISTORY",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF58A6FF),
                    letterSpacing = 1.sp
                )
            }

            items(mockAttempts.take(3)) { attempt ->
                val dateStr = remember(attempt.timestamp) {
                    val sdf = SimpleDateFormat("MMM d, yyyy - hh:mm a", Locale.getDefault())
                    sdf.format(Date(attempt.timestamp))
                }
                val durationMin = attempt.durationSeconds / 60
                val durationSec = attempt.durationSeconds % 60
                val percent = (attempt.score * 100) / attempt.totalQuestions

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF0D1117)),
                    border = CardDefaults.outlinedCardBorder().copy(
                        brush = Brush.horizontalGradient(listOf(Color(0xFF21262D), Color(0xFF21262D)))
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(
                                text = "Score: ${attempt.score} / ${attempt.totalQuestions} ($percent%)",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (percent >= 70) Color(0xFF3FB950) else Color(0xFFF85149)
                            )
                            Text(
                                text = "Time taken: ${durationMin}m ${durationSec}s",
                                fontSize = 11.sp,
                                color = Color(0xFF8B949E)
                            )
                            Text(
                                text = dateStr,
                                fontSize = 10.sp,
                                color = Color(0xFF8B949E)
                            )
                        }

                        Icon(
                            imageVector = if (percent >= 70) Icons.Default.CheckCircle else Icons.Default.Error,
                            contentDescription = "Status icon",
                            tint = if (percent >= 70) Color(0xFF3FB950) else Color(0xFFF85149)
                        )
                    }
                }
            }
        }

        // Danger/Reset panel
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Clear All Progress History",
                    fontSize = 12.sp,
                    color = Color(0xFFF85149),
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .clickable { onResetProgress() }
                        .padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun QuizContent(
    title: String,
    isMock: Boolean,
    sessionState: QuizSessionState,
    bookmarkedIds: List<Int>,
    onSelectOption: (Int, String) -> Unit,
    onNext: () -> Unit,
    onPrevious: () -> Unit,
    onJumpTo: (Int) -> Unit,
    onToggleBookmark: (Int) -> Unit,
    onSubmitMock: () -> Unit,
    onBack: () -> Unit
) {
    if (sessionState.questions.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                CircularProgressIndicator(color = Color(0xFF58A6FF))
                Spacer(modifier = Modifier.height(16.dp))
                Text("Loading quiz deck...", color = Color.White)
            }
        }
        return
    }

    val currentQuestion = sessionState.questions[sessionState.currentIndex]
    val isBookmarked = bookmarkedIds.contains(currentQuestion.id)
    val selectedOption = sessionState.selectedOptionMap[currentQuestion.id]
    val isSubmitted = sessionState.isSubmittedMap[currentQuestion.id] ?: false

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        // Safe spacing top
        Spacer(modifier = Modifier.height(8.dp))

        // Quiz Header Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back arrow icon",
                    tint = Color.White
                )
            }

            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            IconButton(onClick = { onToggleBookmark(currentQuestion.id) }) {
                Icon(
                    imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                    contentDescription = "Bookmark button",
                    tint = if (isBookmarked) Color(0xFF58A6FF) else Color.White
                )
            }
        }

        // Dynamic Progress Bar
        val totalQuestions = sessionState.questions.size
        val answeredQuestions = sessionState.questions.count { sessionState.selectedOptionMap.containsKey(it.id) }
        val progressPercent = if (totalQuestions > 0) (answeredQuestions * 100) / totalQuestions else 0
        val progressFraction = if (totalQuestions > 0) answeredQuestions.toFloat() / totalQuestions else 0f

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
                .testTag("quiz_progress_container")
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Completion Progress",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF8B949E)
                )
                Text(
                    text = "$progressPercent% ($answeredQuestions/$totalQuestions)",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF58A6FF)
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            LinearProgressIndicator(
                progress = { progressFraction },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .testTag("quiz_progress_bar"),
                color = Color(0xFF3FB950),
                trackColor = Color(0xFF21262D)
            )
        }

        // Mock Exam Timer & Finish Banner
        if (isMock) {
            val timerMin = sessionState.mockTimeRemainingSeconds / 60
            val timerSec = sessionState.mockTimeRemainingSeconds % 60
            val timerStr = String.format("%02d:%02d", timerMin, timerSec)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF161B22), shape = RoundedCornerShape(8.dp))
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Timer,
                        contentDescription = "Timer icon",
                        tint = if (sessionState.mockTimeRemainingSeconds < 120) Color(0xFFF85149) else Color(0xFF58A6FF),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (sessionState.isMockFinished) "Exam Completed" else "Time Remaining: $timerStr",
                        fontSize = 13.sp,
                        color = if (sessionState.mockTimeRemainingSeconds < 120 && !sessionState.isMockFinished) Color(0xFFF85149) else Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }

                if (!sessionState.isMockFinished) {
                    Button(
                        onClick = onSubmitMock,
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1F6FEB)),
                        contentPadding = PaddingValues(horizontal = 14.dp, vertical = 4.dp),
                        modifier = Modifier.height(30.dp)
                    ) {
                        Text("Finish", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }

        // Score display if mock is finished
        if (isMock && sessionState.isMockFinished) {
            val total = sessionState.questions.size
            val pct = (sessionState.score * 100) / total
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = if (pct >= 70) Color(0xFF1B4332) else Color(0xFF4C1E1E))
            ) {
                Column(
                    modifier = Modifier.padding(14.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "EXAM SUMMARY",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xCCFFFFFF),
                        letterSpacing = 1.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Score: ${sessionState.score} / $total ($pct%)",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                    Text(
                        text = if (pct >= 70) "PASS: Ready for university exit exam!" else "RETRY: Study explanations below to bridge concepts",
                        fontSize = 12.sp,
                        color = Color(0xFFE6EDF2),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        // Horizontal Question Selector
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(sessionState.questions.size) { idx ->
                val isCurrent = idx == sessionState.currentIndex
                val qId = sessionState.questions[idx].id
                val hasAnswered = sessionState.selectedOptionMap[qId] != null

                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(
                            color = when {
                                isCurrent -> Color(0xFF58A6FF)
                                hasAnswered -> Color(0xFF21262D)
                                else -> Color(0xFF161B22)
                            },
                            shape = CircleShape
                        )
                        .clickable { onJumpTo(idx) }
                        .testTag("question_selector_bubble_$idx"),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "${idx + 1}",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = when {
                            isCurrent -> Color.Black
                            hasAnswered -> Color.White
                            else -> Color(0xFF8B949E)
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Question details lazy column
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 24.dp)
        ) {
            // Question Scenario / Body Card
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF161B22)),
                    border = CardDefaults.outlinedCardBorder().copy(
                        brush = Brush.horizontalGradient(listOf(Color(0xFF30363D), Color(0xFF30363D)))
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "QUESTION ${sessionState.currentIndex + 1} OF ${sessionState.questions.size}",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF58A6FF),
                                letterSpacing = 1.sp
                            )

                            // Type badge
                            Box(
                                modifier = Modifier
                                    .background(
                                        color = if (currentQuestion.isScenario) Color(0xFF4C1E1E) else Color(0xFF0F2537),
                                        shape = RoundedCornerShape(6.dp)
                                    )
                                    .padding(horizontal = 8.dp, vertical = 2.dp)
                            ) {
                                Text(
                                    text = if (currentQuestion.isScenario) "SCENARIO-BASED" else "TERMINOLOGY",
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (currentQuestion.isScenario) Color(0xFFFF7B72) else Color(0xFF58A6FF)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = currentQuestion.text,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                            lineHeight = 22.sp
                        )
                    }
                }
            }

            // Options list
            val options = listOf(
                "A" to currentQuestion.optionA,
                "B" to currentQuestion.optionB,
                "C" to currentQuestion.optionC,
                "D" to currentQuestion.optionD
            )

            items(options) { (key, text) ->
                val isSelected = selectedOption == key
                val isCorrectAnswer = currentQuestion.correctOption == key

                // Visual feedback state definition
                val (cardColor, borderBrush, textColor) = when {
                    // Scenario 1: Submitted state (shows correct/incorrect options in vivid colors)
                    isSubmitted -> {
                        when {
                            isCorrectAnswer -> Triple(
                                Color(0xFF1F3D2A), // Soft dark emerald
                                Brush.horizontalGradient(listOf(Color(0xFF3FB950), Color(0xFF3FB950))), // Vivid green border
                                Color.White
                            )
                            isSelected -> Triple(
                                Color(0xFF4C2020), // Soft dark ruby
                                Brush.horizontalGradient(listOf(Color(0xFFF85149), Color(0xFFF85149))), // Vivid red border
                                Color.White
                            )
                            else -> Triple(
                                Color(0xFF161B22),
                                Brush.horizontalGradient(listOf(Color(0xFF30363D), Color(0xFF30363D))),
                                Color(0xFF8B949E)
                            )
                        }
                    }
                    // Scenario 2: Selected but not yet submitted (standard mock exam behavior)
                    isSelected -> Triple(
                        Color(0xFF0D213F), // Dark slate blue
                        Brush.horizontalGradient(listOf(Color(0xFF1F6FEB), Color(0xFF1F6FEB))), // Cyan/blue border
                        Color.White
                    )
                    // Scenario 3: Neutral unselected option
                    else -> Triple(
                        Color(0xFF161B22),
                        Brush.horizontalGradient(listOf(Color(0xFF30363D), Color(0xFF30363D))),
                        Color.White
                    )
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onSelectOption(currentQuestion.id, key) }
                        .testTag("option_card_$key"),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = cardColor),
                    border = CardDefaults.outlinedCardBorder().copy(brush = borderBrush)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Letter Badge
                        Box(
                            modifier = Modifier
                                .size(28.dp)
                                .background(
                                    color = when {
                                        isSubmitted && isCorrectAnswer -> Color(0xFF3FB950)
                                        isSubmitted && isSelected -> Color(0xFFF85149)
                                        isSelected -> Color(0xFF1F6FEB)
                                        else -> Color(0xFF21262D)
                                    },
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = key,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isSelected || (isSubmitted && isCorrectAnswer)) Color.Black else Color.White
                            )
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Text(
                            text = text,
                            fontSize = 14.sp,
                            color = textColor,
                            modifier = Modifier.weight(1f)
                        )

                        // Suffix icon for validation
                        if (isSubmitted) {
                            if (isCorrectAnswer) {
                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = "Correct answer check icon",
                                    tint = Color(0xFF3FB950)
                                )
                            } else if (isSelected) {
                                Icon(
                                    imageVector = Icons.Default.Cancel,
                                    contentDescription = "Incorrect answer cross icon",
                                    tint = Color(0xFFF85149)
                                )
                            }
                        }
                    }
                }
            }

            // Detailed Explanations Panel
            if (isSubmitted) {
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF0D1117)),
                        border = CardDefaults.outlinedCardBorder().copy(
                            brush = Brush.horizontalGradient(listOf(Color(0xFF30363D), Color(0xFF30363D)))
                        )
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.Lightbulb,
                                    contentDescription = "Explanation lightbulb icon",
                                    tint = Color(0xFFE3B341)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "CONCEPTUAL EXPLANATIONS",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            // Overall Explanation
                            Text(
                                text = "Core Concept",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF58A6FF)
                            )
                            Text(
                                text = currentQuestion.explanationCorrect,
                                fontSize = 13.sp,
                                color = Color(0xFFC9D1D9),
                                modifier = Modifier.padding(bottom = 12.dp)
                            )

                            // Correct answer explanation
                            Text(
                                text = "Why Option ${currentQuestion.correctOption} is Correct",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF3FB950)
                            )
                            val correctExplanation = when (currentQuestion.correctOption) {
                                "A" -> currentQuestion.explanationA
                                "B" -> currentQuestion.explanationB
                                "C" -> currentQuestion.explanationC
                                else -> currentQuestion.explanationD
                            }
                            Text(
                                text = correctExplanation,
                                fontSize = 13.sp,
                                color = Color(0xFFC9D1D9),
                                modifier = Modifier.padding(bottom = 12.dp)
                            )

                            // Incorrect options analysis
                            Text(
                                text = "Why Other Alternatives are Incorrect",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFFF7B72)
                            )

                            val wrongOptions = listOf("A", "B", "C", "D").filter { it != currentQuestion.correctOption }
                            wrongOptions.forEach { wrongKey ->
                                val wrongExplanation = when (wrongKey) {
                                    "A" -> currentQuestion.explanationA
                                    "B" -> currentQuestion.explanationB
                                    "C" -> currentQuestion.explanationC
                                    else -> currentQuestion.explanationD
                                }
                                Row(
                                    modifier = Modifier.padding(vertical = 4.dp),
                                    verticalAlignment = Alignment.Top
                                ) {
                                    Text(
                                        text = "$wrongKey: ",
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFFF7B72)
                                    )
                                    Text(
                                        text = wrongExplanation.replace("Incorrect:", "").replace("Incorrect :", "").trim(),
                                        fontSize = 13.sp,
                                        color = Color(0xFF8B949E)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        // Prev / Next Nav Buttons Footer
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val isFirst = sessionState.currentIndex == 0
            val isLast = sessionState.currentIndex == sessionState.questions.size - 1

            TextButton(
                onClick = onPrevious,
                enabled = !isFirst,
                colors = ButtonDefaults.textButtonColors(contentColor = Color(0xFF58A6FF))
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Previous arrow icon",
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text("PREVIOUS")
            }

            TextButton(
                onClick = onNext,
                enabled = !isLast,
                colors = ButtonDefaults.textButtonColors(contentColor = Color(0xFF58A6FF))
            ) {
                Text("NEXT")
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Next arrow icon",
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}
