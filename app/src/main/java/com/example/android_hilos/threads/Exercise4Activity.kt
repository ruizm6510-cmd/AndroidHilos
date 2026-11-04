package com.example.android_hilos.threads

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_hilos.R

class MiTarea(private val n: Int, private val callback: (Long) -> Unit) : Runnable {
    override fun run() {
        var sum = 0L
        for (i in 1..n) {
            sum += i
        }
        callback(sum)
    }
}

class Exercise4Activity : AppCompatActivity() {
    private lateinit var etNumber: EditText
    private lateinit var tvResult: TextView
    private lateinit var btnCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise4)

        etNumber = findViewById(R.id.etNumber)
        tvResult = findViewById(R.id.tvResultEx4)
        btnCalculate = findViewById(R.id.btnCalculate)

        btnCalculate.setOnClickListener {
            val nStr = etNumber.text.toString()
            val n = nStr.toIntOrNull() ?: 100
            tvResult.text = "Calculando..."

            val tarea = MiTarea(n) { result ->
                runOnUiThread {
                    tvResult.text = "Suma de los primeros $n números = $result"
                }
            }
            Thread(tarea).start()
        }
    }
}
