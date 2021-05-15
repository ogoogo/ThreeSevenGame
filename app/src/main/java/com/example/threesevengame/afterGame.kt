package com.example.threesevengame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_after_game.*

class afterGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_game)
        val startIntent:Intent= Intent(this,MainActivity::class.java)

        val result :Int=intent.getIntExtra("result",0)
        textView3.text=result.toString()

        button7.setOnClickListener {
            startActivity(startIntent)
        }
    }
}