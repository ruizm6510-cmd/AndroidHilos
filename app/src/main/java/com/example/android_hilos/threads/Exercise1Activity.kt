package com.example.android_hilos.threads

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_hilos.R

class Exercise1Activity : AppCompatActivity() {
    private lateinit var tvResult: TextView
    private lateinit var btnStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_thread)

        tvResult = findViewById(R.id.tvResult)
        btnStart = findViewById(R.id.btnStart)

        btnStart.setOnClickListener {
            btnStart.isEnabled = false
            tvResult.text = "Iniciando hilo..."
            Thread {
                for (i in 1..10) {
                    try {
                        Thread.sleep(1000)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                    runOnUiThread {
                        tvResult.text = "Número: $i"
                    }
                }
                runOnUiThread {
                    btnStart.isEnabled = true
                    tvResult.text = "¡Hilo finalizado!"
                }
            }.start()
        }
    }
}
