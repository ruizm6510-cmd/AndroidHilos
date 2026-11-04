package com.example.android_hilos.sensors

import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_hilos.R

class Exercise25Activity : AppCompatActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private var proximitySensor: Sensor? = null
    private var lightSensor: Sensor? = null
    private lateinit var layout: LinearLayout
    private lateinit var tvCombined: TextView

    private var isNear = false
    private var isDark = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise25)

        layout = findViewById(R.id.layoutEx25)
        tvCombined = findViewById(R.id.tvCombined)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
    }

    override fun onResume() {
        super.onResume()
        proximitySensor?.let { sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL) }
        lightSensor?.let { sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL) }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event == null) return
        if (event.sensor.type == Sensor.TYPE_PROXIMITY) {
            isNear = event.values[0] < (proximitySensor?.maximumRange ?: 5.0f)
        } else if (event.sensor.type == Sensor.TYPE_LIGHT) {
            isDark = event.values[0] < 10.0f
        }

        if (isNear && isDark) {
            layout.setBackgroundColor(Color.BLACK)
            tvCombined.setTextColor(Color.WHITE)
            tvCombined.text = "Oscuro y Cerca -> Pantalla NEGRO"
        } else {
            layout.setBackgroundColor(Color.WHITE)
            tvCombined.setTextColor(Color.BLACK)
            tvCombined.text = "Claro o Lejos -> Pantalla BLANCO"
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
}
