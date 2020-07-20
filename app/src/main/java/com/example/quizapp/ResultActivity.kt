package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val userName = intent.getStringExtra(Constants.userName)
        txtUserName.text = userName
        val totalQuestions = intent.getIntExtra(Constants.totalQuestions,0)
        val totalCorrectAnswers = intent.getIntExtra(Constants.correctAnswers,0)
        txtScore.text = "Your score is $totalCorrectAnswers out of $totalQuestions"

        btnFinish.setOnClickListener{
            startActivity(Intent(this,ChooseCategory::class.java))
        }
    }
}