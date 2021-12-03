package com.example.guessgame_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var clickCount = 0
        val guessNumberView = findViewById<TextInputLayout>(R.id.guessInputView)
        val answerView = findViewById<TextView>(R.id.answerView)
        var secretNmber = Random.nextInt(0, 1000)
        findViewById<TextView>(R.id.checkBtn).setOnClickListener{
            val guessNumber = guessNumberView.editText?.text?.toString()?.toIntOrNull() ?:0
            clickCount++
            if (secretNmber>guessNumber)
                answerView.text = "No, my number is bigger"
            else if (secretNmber<guessNumber)
                answerView.text = "No, my number is smaller"
            else{
                startEndGameActivity(secretNmber, true)
            }
            if (clickCount == 12)
                startEndGameActivity(secretNmber, false)

        }

    }
    fun startEndGameActivity(number:Int, isWon:Boolean){
        val newScreenIntent = Intent(this, EndGameActivity::class.java)
        newScreenIntent.putExtra("secretNumber", number)
        newScreenIntent.putExtra("isWon", isWon)
        startActivity(newScreenIntent)
    }
}
