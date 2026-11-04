package com.example.android_hilos.touch

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_hilos.R
import kotlin.math.atan2

class Exercise16Activity : AppCompatActivity() {
    private lateinit var ivRotate: ImageView
    private var baseAngle = 0f

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise16)

        ivRotate = findViewById(R.id.ivRotate)

        ivRotate.setOnTouchListener { v, event ->
            if (event.pointerCount == 2) {
                val x1 = event.getX(0)
                val y1 = event.getY(0)
                val x2 = event.getX(1)
                val y2 = event.getY(1)

                val angle = Math.toDegrees(atan2((y2 - y1).toDouble(), (x2 - x1).toDouble())).toFloat()

                when (event.actionMasked) {
                    MotionEvent.ACTION_POINTER_DOWN -> {
                        baseAngle = angle - v.rotation
                    }
                    MotionEvent.ACTION_MOVE -> {
                        v.rotation = angle - baseAngle
                    }
                }
                true
            } else {
                false
            }
        }
    }
}
