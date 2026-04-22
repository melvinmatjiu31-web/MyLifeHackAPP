package com.example.mylifehackapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    private var index = 0
    private var score = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val questionText = findViewById<TextView>(R.id.tvQuestion)
        val feedback = findViewById<TextView>(R.id.tvFeedback)
        val btnTrue = findViewById<Button>(R.id.btnTrue)
        val btnFalse = findViewById<Button>(R.id.btnFalse)
        val btnNext = findViewById<Button>(R.id.btnNext)

        fun loadQuestion() {
            questionText.text = QuestionBank.questions[index].text
        }

        loadQuestion()

        btnTrue.setOnClickListener {
            val correct = QuestionBank.questions[index].isTrue
            if (correct) {
                feedback.text = "Correct!"
                score++
            } else {
                feedback.text = "Wrong!"
            }
        }

        btnFalse.setOnClickListener {
            val correct = QuestionBank.questions[index].isTrue
            if (!correct) {
                feedback.text = "Correct!"
                score++
            } else {
                feedback.text = "Wrong!"
            }
        }

        btnNext.setOnClickListener {
            index++
            if (index < QuestionBank.questions.size) {
                loadQuestion()
                feedback.text = ""
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("total", QuestionBank.questions.size)
                startActivity(intent)
            }
        }
    }
}
