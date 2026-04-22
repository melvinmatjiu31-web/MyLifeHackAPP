package com.example.mylifehackapp

object QuestionBank {

    data class Question(
        val text: String,
        val isTrue: Boolean
    )

    val questions = listOf(
        Question("Eating carrots improves eyesight.", false),
        Question("Drinking water improves focus.", true),
        Question("Cracking knuckles causes arthritis.", false),
        Question("Cold showers increase alertness.", true)
    )
}