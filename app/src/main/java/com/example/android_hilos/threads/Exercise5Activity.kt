package com.example.android_hilos.threads

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_hilos.R
import kotlinx.coroutines.*

class Exercise5Activity : AppCompatActivity() {
    private lateinit var tvLog: TextView
    private lateinit var btnCoroutine: Button
    private val scope = CoroutineScope(Dispatchers.Main + Job())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise5)

        tvLog = findViewById(R.id.tvLog)
        btnCoroutine = findViewById(R.id.btnCoroutine)

        btnCoroutine.setOnClickListener {
            btnCoroutine.isEnabled = false
            tvLog.text = "Iniciando corrutina...\n"

            scope.launch {
                for (i in 1..5) {
                    delay(1000)
                    val msg = "Mensaje corrutina $i/5\n"
                    tvLog.append(msg)
                }
                tvLog.append("¡Corrutina finalizada!")
                btnCoroutine.isEnabled = true
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}
