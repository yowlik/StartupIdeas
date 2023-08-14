package com.fastrecipes.whiteskaway

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fastrecipes.whiteskaway.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    lateinit var binding:ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.result.text=intent.getStringExtra("key")
        clickResultButton()
    }

    private fun clickResultButton() {
        binding.apply {
            menu.setOnClickListener {
                startActivity(Intent(this@ResultActivity,MainActivity::class.java))
                finish()
            }
            restart.setOnClickListener {
                startActivity(Intent(this@ResultActivity,ActivityGame::class.java))
                finish()
            }
        }
    }
}