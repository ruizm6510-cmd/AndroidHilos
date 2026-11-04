package com.example.android_hilos.threads

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_hilos.R
import kotlinx.coroutines.*
import kotlin.random.Random

class Exercise6Activity : AppCompatActivity() {
    private lateinit var tvSensorData: TextView
    private lateinit var btnToggle: Button
    private var job: Job? = null
    private val scope = CoroutineScope(Dispatchers.Main + Job())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise6)

        tvSensorData = findViewById(R.id.tvSensorData)
        btnToggle = findViewById(R.id.btnToggle)

        btnToggle.setOnClickListener {
            if (job == null || job?.isActive == false) {
                // Start simulation
                btnToggle.text = "Detener Simulación"
                job = scope.launch {
                    while (isActive) {
                        val randomValue = Random.nextDouble(20.0, 40.0)
                        tvSensorData.text = String.format("Sensor Simulado: %.2f ºC", randomValue)
                        delay(500)
                    }
                }
            } else {
                // Stop simulation
                job?.cancel()
                job = null
                btnToggle.text = "Iniciar Simulación Sensor"
                tvSensorData.text = "Simulación detenida"
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}
