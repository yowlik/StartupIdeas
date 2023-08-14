package com.fastrecipes.whiteskaway

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fastrecipes.whiteskaway.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickMenuButton()
    }

    private fun clickMenuButton() {
        binding.apply {
            start.setOnClickListener {
                startActivity(Intent(this@MainActivity,ActivityGame::class.java))
                finish()
            }
            closegame.setOnClickListener {
                finishAffinity()
            }
        }
    }
}