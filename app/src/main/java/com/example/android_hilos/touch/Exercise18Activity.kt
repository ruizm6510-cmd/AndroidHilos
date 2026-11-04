package com.example.android_hilos.touch

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_hilos.R
import kotlin.math.atan2

class Exercise18Activity : AppCompatActivity() {
    private lateinit var ivTransform: ImageView
    private var dX = 0f
    private var dY = 0f
    private var baseAngle = 0f
    private var lastScaleFactor = 1f

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise18)

        ivTransform = findViewById(R.id.ivTransform)

        ivTransform.setOnTouchListener { v, event ->
            when (event.actionMasked) {
                MotionEvent.ACTION_DOWN -> {
                    dX = v.x - event.rawX
                    dY = v.y - event.rawY
                    true
                }
                MotionEvent.ACTION_POINTER_DOWN -> {
                    if (event.pointerCount == 2) {
                        val x1 = event.getX(0)
                        val y1 = event.getY(0)
                        val x2 = event.getX(1)
                        val y2 = event.getY(1)
                        baseAngle = Math.toDegrees(atan2((y2 - y1).toDouble(), (x2 - x1).toDouble())).toFloat() - v.rotation
                    }
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    if (event.pointerCount == 1) {
                        v.animate()
                            .x(event.rawX + dX)
                            .y(event.rawY + dY)
                            .duration = 0
                    } else if (event.pointerCount == 2) {
                        val x1 = event.getX(0)
                        val y1 = event.getY(0)
                        val x2 = event.getX(1)
                        val y2 = event.getY(1)
                        val angle = Math.toDegrees(atan2((y2 - y1).toDouble(), (x2 - x1).toDouble())).toFloat()
                        v.rotation = angle - baseAngle
                    }
                    true
                }
                else -> false
            }
        }
    }
}
