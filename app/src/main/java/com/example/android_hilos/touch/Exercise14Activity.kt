package com.example.android_hilos.touch

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MultiTouchDrawingView(context: Context) : View(context) {
    private val activePaths = mutableMapOf<Int, Path>()
    private val activePaints = mutableMapOf<Int, Paint>()
    private val colors = listOf(Color.RED, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.CYAN, Color.YELLOW)

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val pointerIndex = event.actionIndex
        val pointerId = event.getPointerId(pointerIndex)
        val x = event.getX(pointerIndex)
        val y = event.getY(pointerIndex)

        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_POINTER_DOWN -> {
                val path = Path().apply { moveTo(x, y) }
                val paint = Paint().apply {
                    color = colors[pointerId % colors.size]
                    isAntiAlias = true
                    strokeWidth = 15f
                    style = Paint.Style.STROKE
                    strokeJoin = Paint.Join.ROUND
                }
                activePaths[pointerId] = path
                activePaints[pointerId] = paint
            }
            MotionEvent.ACTION_MOVE -> {
                for (i in 0 until event.pointerCount) {
                    val id = event.getPointerId(i)
                    activePaths[id]?.lineTo(event.getX(i), event.getY(i))
                }
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_POINTER_UP, MotionEvent.ACTION_CANCEL -> {
                activePaths.remove(pointerId)
                activePaints.remove(pointerId)
            }
        }
        invalidate()
        return true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        for ((id, path) in activePaths) {
            canvas.drawPath(path, activePaints[id]!!)
        }
    }
}

class Exercise14Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MultiTouchDrawingView(this))
    }
}
