package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmarks")
data class BookmarkEntity(
    @PrimaryKey val questionId: Int,
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "answer_history")
data class AnswerHistoryEntity(
    @PrimaryKey val questionId: Int,
    val selectedOption: String, // "A", "B", "C", "D"
    val isCorrect: Boolean,
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "mock_attempts")
data class MockAttemptEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val score: Int,
    val totalQuestions: Int,
    val durationSeconds: Int,
    val timestamp: Long = System.currentTimeMillis()
)
