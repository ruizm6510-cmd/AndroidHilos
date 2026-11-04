package com.example.android_hilos.touch

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_hilos.R

class Exercise13Activity : AppCompatActivity() {
    private lateinit var tvMultiTouch: TextView

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise13)

        tvMultiTouch = findViewById(R.id.tvMultiTouch)

        tvMultiTouch.setOnTouchListener { _, event ->
            val pointerCount = event.pointerCount
            val sb = StringBuilder("Dedos en pantalla: $pointerCount\n")
            for (i in 0 until pointerCount) {
                sb.append("Dedo $i -> X: ${event.getX(i)}, Y: ${event.getY(i)}\n")
            }
            tvMultiTouch.text = sb.toString()
            true
        }
    }
}
