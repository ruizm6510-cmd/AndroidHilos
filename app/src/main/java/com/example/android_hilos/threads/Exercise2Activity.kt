package com.example.android_hilos.threads

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_hilos.R

class Exercise2Activity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var tvProgress: TextView
    private lateinit var btnStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise2)

        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgress)
        btnStart = findViewById(R.id.btnStartEx2)

        progressBar.max = 100

        btnStart.setOnClickListener {
            btnStart.isEnabled = false
            progressBar.progress = 0
            Thread {
                for (i in 0..100) {
                    try {
                        Thread.sleep(100)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                    runOnUiThread {
                        progressBar.progress = i
                        tvProgress.text = "Progreso: $i%"
                    }
                }
                runOnUiThread {
                    btnStart.isEnabled = true
                }
            }.start()
        }
    }
}
