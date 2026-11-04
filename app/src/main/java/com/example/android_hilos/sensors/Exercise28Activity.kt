package com.example.android_hilos.sensors

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_hilos.R
import kotlin.math.sqrt

class Exercise28Activity : AppCompatActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private var accelSensor: Sensor? = null
    private var gyroSensor: Sensor? = null
    private var stepSensor: Sensor? = null

    private lateinit var tvDashboard: TextView

    private var steps = 0
    private var movementLevel = 0f
    private var gyroX = 0f
    private var gyroY = 0f
    private var gyroZ = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise28)

        tvDashboard = findViewById(R.id.tvDashboard)
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        accelSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        gyroSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
        stepSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
            ?: sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)
    }

    override fun onResume() {
        super.onResume()
        accelSensor?.let { sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL) }
        gyroSensor?.let { sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL) }
        stepSensor?.let { sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL) }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event == null) return
        when (event.sensor.type) {
            Sensor.TYPE_ACCELEROMETER -> {
                val x = event.values[0]
                val y = event.values[1]
                val z = event.values[2]
                movementLevel = sqrt((x * x + y * y + z * z).toDouble()).toFloat()
            }
            Sensor.TYPE_GYROSCOPE -> {
                gyroX = event.values[0]
                gyroY = event.values[1]
                gyroZ = event.values[2]
            }
            Sensor.TYPE_STEP_COUNTER -> {
                steps = event.values[0].toInt()
            }
            Sensor.TYPE_STEP_DETECTOR -> {
                steps++
            }
        }

        tvDashboard.text = "--- PANEL MULTISENSORES ---\n\n" +
                "Pasos totales: $steps\n" +
                "Nivel de Movimiento (Acel): %.2f m/s²\n" +
                "Giroscopio (X, Y, Z): %.2f, %.2f, %.2f rad/s".format(movementLevel, gyroX, gyroY, gyroZ)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
}
