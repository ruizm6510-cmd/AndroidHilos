package com.example.android_hilos.sensors

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_hilos.R

class Exercise27Activity : AppCompatActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private var accelSensor: Sensor? = null
    private lateinit var tvPosition: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise27)

        tvPosition = findViewById(R.id.tvPosition)
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        accelSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    }

    override fun onResume() {
        super.onResume()
        accelSensor?.let { sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL) }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
            val z = event.values[2]
            val x = event.values[0]
            val y = event.values[1]

            val positionStr = when {
                z > 8.0f -> "Boca arriba (Face Up)"
                z < -8.0f -> "Boca abajo (Face Down)"
                kotlin.math.abs(x) > 7.0f || kotlin.math.abs(y) > 7.0f -> "Posición vertical / Horizontal"
                else -> "Inclinado / Transición"
            }
            tvPosition.text = "Posición: $positionStr\n(Z: %.1f, X: %.1f, Y: %.1f)".format(z, x, y)
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
}
