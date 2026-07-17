package com.example.data.model

data class Question(
    val id: Int,
    val chapter: Int,
    val chapterTitle: String,
    val isScenario: Boolean,
    val text: String,
    val optionA: String,
    val optionB: String,
    val optionC: String,
    val optionD: String,
    val correctOption: String, // "A", "B", "C", "D"
    val explanationA: String,
    val explanationB: String,
    val explanationC: String,
    val explanationD: String,
    val explanationCorrect: String
)
