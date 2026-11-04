package com.example.android_hilos.touch

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_hilos.R

class Exercise7Activity : AppCompatActivity() {
    private lateinit var tvTouchStatus: TextView

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise7)

        tvTouchStatus = findViewById(R.id.tvTouchStatus)

        tvTouchStatus.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> tvTouchStatus.text = "Pulsación iniciada (ACTION_DOWN)"
                MotionEvent.ACTION_MOVE -> tvTouchStatus.text = "Desplazando el dedo (ACTION_MOVE)"
                MotionEvent.ACTION_UP -> tvTouchStatus.text = "Pulsación finalizada (ACTION_UP)"
            }
            true
        }
    }
}
