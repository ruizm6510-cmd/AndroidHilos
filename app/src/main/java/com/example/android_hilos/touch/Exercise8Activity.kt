package com.example.android_hilos.touch

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_hilos.R

class Exercise8Activity : AppCompatActivity() {
    private lateinit var tvCoords: TextView

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise8)

        tvCoords = findViewById(R.id.tvCoords)

        tvCoords.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN || event.action == MotionEvent.ACTION_MOVE) {
                val x = event.x
                val y = event.y
                tvCoords.text = "Coordenadas X: %.1f, Y: %.1f".format(x, y)
            }
            true
        }
    }
}
