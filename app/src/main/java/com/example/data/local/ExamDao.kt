package com.example.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ExamDao {
    // Bookmarks
    @Query("SELECT * FROM bookmarks ORDER BY timestamp DESC")
    fun getAllBookmarks(): Flow<List<BookmarkEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookmark(bookmark: BookmarkEntity)

    @Query("DELETE FROM bookmarks WHERE questionId = :questionId")
    suspend fun deleteBookmark(questionId: Int)

    // Answer History (Tracks progress)
    @Query("SELECT * FROM answer_history")
    fun getAllAnswerHistory(): Flow<List<AnswerHistoryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnswerHistory(history: AnswerHistoryEntity)

    @Query("DELETE FROM answer_history")
    suspend fun clearAnswerHistory()

    // Mock Attempts
    @Query("SELECT * FROM mock_attempts ORDER BY timestamp DESC")
    fun getAllMockAttempts(): Flow<List<MockAttemptEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMockAttempt(attempt: MockAttemptEntity)

    @Query("DELETE FROM mock_attempts")
    suspend fun clearMockAttempts()
}
