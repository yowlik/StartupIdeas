package com.fastrecipes.whiteskaway

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import com.fastrecipes.whiteskaway.databinding.ActivityGameBinding

class ActivityGame : AppCompatActivity() {
    lateinit var bindingActivity: ActivityGameBinding
    private var timer: CountDownTimer? = null
    lateinit var buts: Array<Button>
    var numOfStep = 0
    var numOfBullet = 25
    var scoreText = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingActivity = ActivityGameBinding.inflate(layoutInflater)
        setContentView(bindingActivity.root)
        buts = arrayOf(
            bindingActivity.plane1,
            bindingActivity.plane2,
            bindingActivity.plane3,
            bindingActivity.plane4,
            bindingActivity.plane5
        )
        for (i in 0..4) {
            buts[i].setVisibility(View.GONE)
            buts[i].setOnClickListener {
                if (numOfBullet != 0) {
                    buts[i].setVisibility(View.GONE)
                    numOfBullet--
                    scoreText++
                    if (scoreText == 25) {
                        timer?.cancel()
                        val intent = Intent(this@ActivityGame, ResultActivity::class.java)
                        intent.putExtra("key", "Congratulations, you won")
                        startActivity(intent)
                        finish()
                    } else if (numOfBullet == 0) {
                        timer?.cancel()
                        val intent = Intent(this@ActivityGame, ResultActivity::class.java)
                        intent.putExtra("key", "Result : $scoreText")
                        startActivity(intent)
                        finish()
                    }
                    bindingActivity.score.text = "Score : $scoreText"
                    bindingActivity.bulet.text = "Bullet : $numOfBullet"
                }
            }
        }
        bindingActivity.missLayout.setOnClickListener {
            numOfBullet--
            bindingActivity.bulet.text = "Bullet : $numOfBullet"
            if (numOfBullet == 0) {
                timer?.cancel()
                val intent = Intent(this@ActivityGame, ResultActivity::class.java)
                intent.putExtra("key", "Result : $scoreText")
                startActivity(intent)
                finish()

            }
        }
        startTimer(3750)

    }

    private fun startTimer(timeMillis: Long) {

        timer = object : CountDownTimer(timeMillis, 750) {

            override fun onTick(TimeEl: Long) {
                numOfStep++
                when (numOfStep) {
                    1 -> animationStart(buts[4])
                    2 -> animationStart(buts[3])
                    3 -> animationStart(buts[2])
                    4 -> animationStart(buts[1])
                    5 -> animationStart(buts[0])
                }
            }

            override fun onFinish() {
            }

        }.start()

    }


    private fun animationStart(im: Button) {
        val displayMetrics = resources.displayMetrics
        val screenWidthFloat = displayMetrics.widthPixels.toFloat()
        im.visibility = View.VISIBLE
        im.animate().apply {
            translationX(-screenWidthFloat)
            duration = 2250
        }.withEndAction {
            im.visibility = View.VISIBLE
            im.animate().apply {
                translationX(100f)
                duration = 2250
            }.withEndAction {
                im.visibility = View.VISIBLE
                if(numOfStep==5){
                    numOfStep=0
                    startTimer(3750)
                }
            }
        }
    }
}