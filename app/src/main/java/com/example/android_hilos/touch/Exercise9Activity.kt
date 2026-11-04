package com.example.android_hilos.touch

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.android_hilos.R
import kotlin.random.Random

class ColorTouchView(context: android.content.Context) : View(context) {
    init {
        setBackgroundColor(Color.BLUE)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val color = Color.rgb(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
            setBackgroundColor(color)
            return true
        }
        return super.onTouchEvent(event)
    }
}

class Exercise9Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val customView = ColorTouchView(this)
        setContentView(customView)
    }
}
