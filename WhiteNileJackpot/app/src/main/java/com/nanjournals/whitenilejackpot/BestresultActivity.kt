package com.nanjournals.whitenilejackpot

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class BestresultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bestresult)
        val firstS = findViewById<TextView>(R.id.first)
        val secondS = findViewById<TextView>(R.id.second)
        val thirdS = findViewById<TextView>(R.id.third)
        val back=findViewById<View>(R.id.back)
        val sharedPreferences = this.getSharedPreferences(SHAR_NAME, Context.MODE_PRIVATE)
        val score1 = sharedPreferences.getInt(S1, 0)
        val score2 = sharedPreferences.getInt(S2, 0)
        val score3 = sharedPreferences.getInt(S3, 0)
        firstS.text = "1.  $score1"
        secondS.text = "2.  $score2"
        thirdS.text = "3.  $score3"
        back.setOnClickListener {
            startActivity(Intent(this@BestresultActivity,MainActivity::class.java))
            finish()
        }
    }
}