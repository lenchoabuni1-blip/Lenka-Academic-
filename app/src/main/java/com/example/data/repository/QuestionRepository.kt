package com.example.data.repository

import com.example.data.model.Question

object QuestionRepository {
    private val questionsList: List<Question> by lazy {
        Chapter1Questions.getQuestions() +
        Chapter2Questions.getQuestions() +
        Chapter3Questions.getQuestions() +
        Chapter4Questions.getQuestions()
    }

    fun getAllQuestions(): List<Question> = questionsList

    fun getQuestionsForChapter(chapter: Int): List<Question> {
        return questionsList.filter { it.chapter == chapter }
    }

    fun getQuestionById(id: Int): Question? {
        return questionsList.find { it.id == id }
    }

    fun getRandomMockExam(count: Int = 20): List<Question> {
        return questionsList.shuffled().take(count)
    }
}
