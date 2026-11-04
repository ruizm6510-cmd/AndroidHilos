package com.example.android_hilos.touch

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_hilos.R

class Exercise12Activity : AppCompatActivity() {
    private lateinit var tvGesture: TextView
    private lateinit var gestureDetector: GestureDetector

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise12)

        tvGesture = findViewById(R.id.tvGesture)

        val gestureListener = object : GestureDetector.SimpleOnGestureListener() {
            override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
                tvGesture.text = "Gesto: Tap simple (Single Tap)"
                return true
            }

            override fun onLongPress(e: MotionEvent) {
                tvGesture.text = "Gesto: Toque prolongado (Long Press)"
            }

            override fun onFling(
                e1: MotionEvent?,
                e2: MotionEvent,
                velocityX: Float,
                velocityY: Float
            ): Boolean {
                tvGesture.text = "Gesto: Deslizamiento rápido (Fling)"
                return true
            }
        }

        gestureDetector = GestureDetector(this, gestureListener)

        tvGesture.setOnTouchListener { _, event ->
            gestureDetector.onTouchEvent(event)
            true
        }
    }
}
