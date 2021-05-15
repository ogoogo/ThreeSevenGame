package com.example.threesevengame

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_while_game.*
import kotlin.random.Random

class whileGame : AppCompatActivity() {

    var playerNumber :Int= 0
    var answercount :Int= 0
    var titlenumber:Int=20+ Random.nextInt(4980)
    var second:Long=31


    var timer = object :CountDownTimer(31000,1000){
        override fun onFinish() {
            val afterIntent:Intent = Intent(this@whileGame, afterGame::class.java)
            afterIntent.putExtra("result",answercount)
            startActivity(afterIntent)
        }

        override fun onTick(millisUntilFinished: Long) {
            second --
            timeDisplay.text=second.toString()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_while_game)

        timer.start()


        overText.isVisible=false
        againButton.isVisible=false
        titleDisplay.text = titlenumber.toString()



        threeButton.setOnClickListener {
            count(3)
        }
        sevenButton.setOnClickListener {
            count(7)
        }
        thirtyButton.setOnClickListener {
            count(30)
        }
        seventyButton.setOnClickListener {
            count(70)
        }
        threehunButton.setOnClickListener {
            count(300)
        }
        sevenhunButton.setOnClickListener {
            count(700)
        }

    }
    fun count (number:Int ){
        val startIntent:Intent= Intent(this, MainActivity::class.java)

        playerNumber += number
        playerDisplay.text = playerNumber.toString()

        if(playerNumber>titlenumber){
            timer.cancel()
            threeButton.isEnabled=false
            sevenButton.isEnabled=false
            thirtyButton.isEnabled=false
            seventyButton.isEnabled=false
            threehunButton.isEnabled=false
            sevenhunButton.isEnabled=false
            timeDisplay.isVisible=false
            timeLabel.isVisible=false
            overText.isVisible=true
            againButton.isVisible=true
            againButton.setOnClickListener {
                startActivity(startIntent)
            }
            playerDisplay.setTextColor(Color.parseColor("#E91E63"))

        }else if (playerNumber == titlenumber){
            second += 5
            timeDisplay.text=second.toString()
            timer.cancel()
            timer= object :CountDownTimer(second*1000,1000){
                override fun onFinish() {
                    val afterIntent:Intent = Intent(this@whileGame, afterGame::class.java)
                    afterIntent.putExtra("result",answercount)
                    startActivity(afterIntent)
                }

                override fun onTick(millisUntilFinished: Long) {
                    second --
                    timeDisplay.text=second.toString()
                }
            }
            timer.start()
            answercount ++
            titlenumber=20+Random.nextInt(4980)
            titleDisplay.text=titlenumber.toString()
            playerNumber=0
            playerDisplay.text=playerNumber.toString()

        }

    }


}