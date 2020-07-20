package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_choose_category.*
import kotlinx.android.synthetic.main.activity_main.*

class ChooseCategory : AppCompatActivity() {

    var mUserName : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_category)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        mUserName = intent.getStringExtra(Constants.userName)

        btnFlags.setOnClickListener {
                        val intentQ = Intent(this,QuizQuestions::class.java)
                        intentQ.putExtra(Constants.userName, mUserName)
                        startActivity(intentQ)
                        finish()
        }

        btnMovies.setOnClickListener {
                        val intentF = Intent(this,FilmQuestion::class.java)
                        intentF.putExtra(Constants.userName, mUserName)
                        startActivity(intentF)
                        finish()
        }

        btnFinishAll.setOnClickListener {
            finishAffinity()
        }

    }
}