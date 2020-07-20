package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_film_question.*

class FilmQuestion : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int = 1
    private var mQuestionsList: ArrayList<Questions>? = null
    private var mSelectedOptionPosition : Int = 0
    var mUserName : String? = null
    private var mCorrectAnswers:Int = 0
    private var alreadySelected : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_question)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        mUserName = intent.getStringExtra(Constants.userName)
        mQuestionsList = FilmConstants.getQuestions()

        setQuestion()
        optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        optionThree.setOnClickListener(this)
        optionFour.setOnClickListener(this)

        btnSubmit.setOnClickListener(this)
    }

    private fun setQuestion(){

        val question = mQuestionsList!![mCurrentPosition-1]

        defaultOptionsView()

        if(mCurrentPosition == mQuestionsList!!.size)
            btnSubmit.text = "FINISH"
        else
            btnSubmit.text = "SUBMIT"

        progressBar.progress = mCurrentPosition
        progressCount.text = "$mCurrentPosition" + "/" + mQuestionsList!!.size
        questionID.text = question!!.question
        optionOne.text = question.optionOne
        optionTwo.text = question.optionTwo
        optionThree.text = question.optionThree
        optionFour.text = question.optionFour
        imageID.setImageResource(question.image)
        alreadySelected = false
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0,optionOne)
        options.add(1,optionTwo)
        options.add(2,optionThree)
        options.add(3,optionFour)

        for(option in options)
        {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.defaultoptionbg
            )
        }

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.optionOne -> {
                if(alreadySelected)
                    Toast.makeText(this,"You have already selected an option",Toast.LENGTH_SHORT).show()
                else
                    selectedOptionView(optionOne,1)
            }
            R.id.optionTwo -> {
                if(alreadySelected)
                    Toast.makeText(this,"You have already selected an option",Toast.LENGTH_SHORT).show()
                else
                    selectedOptionView(optionTwo,2)
            }
            R.id.optionThree -> {
                if(alreadySelected)
                    Toast.makeText(this,"You have already selected an option",Toast.LENGTH_SHORT).show()
                else
                    selectedOptionView(optionThree,3)
            }
            R.id.optionFour -> {
                if(alreadySelected)
                    Toast.makeText(this,"You have already selected an option",Toast.LENGTH_SHORT).show()
                else
                    selectedOptionView(optionFour,4)
            }
            R.id.btnSubmit -> {
                if(mSelectedOptionPosition==0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        }else ->{
                        val intent = Intent(this,ResultActivity::class.java)
                        intent.putExtra(Constants.userName,mUserName)
                        intent.putExtra(Constants.correctAnswers,mCorrectAnswers)
                        intent.putExtra(Constants.totalQuestions,mQuestionsList!!.size)
                        startActivity(intent)
                    }
                    }
                }
                else{
                    val question = mQuestionsList?.get(mCurrentPosition-1)
                    if(question!!.correctOption!=mSelectedOptionPosition)
                        checkAnswer(mSelectedOptionPosition,R.drawable.wrongoptionbg)
                    else
                        mCorrectAnswers++
                    checkAnswer(question.correctOption,R.drawable.correctoptionbg)

                    if(mCurrentPosition == mQuestionsList!!.size)
                        btnSubmit.text = "FINISH"
                    else
                        btnSubmit.text = "GO TO THE NEXT QUESTION"
                }
                mSelectedOptionPosition = 0
            }
        }
    }

    private fun checkAnswer(answer:Int,drawable:Int){
        alreadySelected = true
        when(answer){
            1 -> {
                optionOne.background = ContextCompat.getDrawable(this,drawable)
            }
            2 -> {
                optionTwo.background = ContextCompat.getDrawable(this,drawable)
            }
            3 -> {
                optionThree.background = ContextCompat.getDrawable(this,drawable)
            }
            4 -> {
                optionFour.background = ContextCompat.getDrawable(this,drawable)
            }
        }
    }
    private fun selectedOptionView(optionSelected : TextView, optionSelectedNum : Int){

        defaultOptionsView()
        mSelectedOptionPosition = optionSelectedNum
        optionSelected.setTextColor(Color.parseColor("#363A43"))
        optionSelected.setTypeface(optionSelected.typeface,Typeface.BOLD)
        optionSelected.background = ContextCompat.getDrawable(
            this,
            R.drawable.selectedoptionbg
        )
    }
}