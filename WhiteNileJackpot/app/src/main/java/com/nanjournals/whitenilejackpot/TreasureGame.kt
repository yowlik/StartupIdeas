package com.nanjournals.whitenilejackpot

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

interface GameInterface {
    fun closeGame(mScore: Int)
}

@SuppressLint("ViewConstructor")
class TreasureGame(var c: Context, var gameInt: GameInterface) : View(c) {
    private var myPencel: Paint? = null
    private var skorost = 1
    private var vremya = 0
    private var scoreschet = 0
    private val treasure = ArrayList<HashMap<String, Any>>()
    private var whereChara = 0

    var chaW = 0
    var chaH = 0

    init {
        myPencel = Paint()
    }

    @SuppressLint("UseCompatLoadingForDrawables", "DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        chaW = this.measuredWidth
        chaH = this.measuredHeight
        if (vremya % 700 < 10 + skorost) {
            val map = HashMap<String, Any>()
            map["lane"] = (0..2).random()
            map["startTime"] = vremya
            treasure.add(map)
        }
        vremya = vremya + 10 + skorost
        val meteorWidth = chaW / 5
        val meteorHeight = meteorWidth + 10
        myPencel!!.style = Paint.Style.FILL
        val d = resources.getDrawable(R.drawable.charackter, null)
        d.setBounds(
            whereChara * chaW / 3 + chaW / 15,
            chaH - 2 - 2 * meteorHeight,
            whereChara * chaW / 3 + chaW / 15 + meteorWidth,
            chaH - 2
        )
        d.draw(canvas!!)
        myPencel!!.color = Color.GREEN
        var highScore = 0
        for (i in treasure.indices) {
            try {
                val meteorX = treasure[i]["lane"] as Int * chaW / 3 + chaW / 15
                val meteorY = vremya - treasure[i]["startTime"] as Int
                val d2 = resources.getDrawable(R.drawable.trea1, null)

                d2.setBounds(
                    meteorX + 25, meteorY - meteorHeight, meteorX + meteorWidth - 25, meteorY
                )
                d2.draw(canvas)
                if (treasure[i]["lane"] as Int == whereChara) {
                    if (meteorY > chaH - 2 - meteorHeight &&
                        meteorY < chaH - 2
                    ) {
                        treasure.removeAt(i)
                        scoreschet++
                        skorost = 1 + Math.abs(scoreschet / 8)
                        if (scoreschet > highScore) {
                            highScore = scoreschet
                        }

                    }
                }
                if (meteorY > chaH + meteorHeight) {
                    gameInt.closeGame(scoreschet)
                    scoreschet = 0
                    skorost = 0
                    treasure.clear()

                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        myPencel!!.color = Color.WHITE
        myPencel!!.textSize = 50f
        canvas.drawText("Treasure : $scoreschet", 280f, 80f, myPencel!!)
        invalidate()


    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                val x1 = event.x
                if (x1 < chaW / 2) {
                    if (whereChara > 0) {
                        whereChara--
                    }
                }
                if (x1 > chaW / 2) {
                    if (whereChara < 2) {
                        whereChara++
                    }
                }
                invalidate()
            }

            MotionEvent.ACTION_UP -> {}
        }
        return true

    }


}