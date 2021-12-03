package com.example.guessgame_v2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class EndGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_game)

        val answerTextView = findViewById<TextView>(R.id.answerText)
        val answerNumberiew = findViewById<TextView>(R.id.answerNumber)
        val flag = intent.getBooleanExtra("isWon",false)
        val number = intent.getIntExtra("secretNumber",0).toString()
        if (flag){
            answerTextView.setText("You won! The number is")
            answerNumberiew.setText(number)
            answerNumberiew.setTextColor(Color.GREEN)
        }else{
            answerTextView.setText("You lost after 12 attempts. The number is")
            answerNumberiew.setText(number)
            answerNumberiew.setTextColor(Color.RED)

        }

    }
}