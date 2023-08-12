package com.nanjournals.whitenilejackpot

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout


class GameActivity : AppCompatActivity(), GameInterface {
    lateinit var rootLayout: ConstraintLayout
    lateinit var mGameView: TreasureGame

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        rootLayout = findViewById(R.id.rootLayout)
        mGameView = TreasureGame(this, this)
        rootLayout.addView(mGameView)
    }

    override fun closeGame(mScore: Int) {
        val sharedPreferences = this.getSharedPreferences(SHAR_NAME, Context.MODE_PRIVATE)
        val score1 = sharedPreferences.getInt(S1, 0)
        val score2 = sharedPreferences.getInt(S2, 0)
        val score3 = sharedPreferences.getInt(S3, 0)
        val editor = sharedPreferences.edit()
        if (mScore > score1) {
            editor.putInt(S1, mScore)
            editor.putInt(S2, score1)
            editor.putInt(S3, score2)
        } else if (mScore > score2) {
            editor.putInt(S2, mScore)
            editor.putInt(S3, score2)
        } else if (mScore > score3) {
            editor.putInt(S3, mScore)
        }
        editor.apply()
        val intent = Intent(this@GameActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }


}