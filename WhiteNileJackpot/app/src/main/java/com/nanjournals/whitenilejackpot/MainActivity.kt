package com.nanjournals.whitenilejackpot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val start = findViewById<TextView>(R.id.start)
        val record = findViewById<TextView>(R.id.records)
        val exit = findViewById<TextView>(R.id.exit)
        start.setOnClickListener {
            startActivity(Intent(this@MainActivity, GameActivity::class.java))
            finish()
        }
        record.setOnClickListener {
            startActivity(Intent(this@MainActivity, BestresultActivity::class.java))
            finish()
        }
        exit.setOnClickListener {
            finishAffinity()
        }
    }
}