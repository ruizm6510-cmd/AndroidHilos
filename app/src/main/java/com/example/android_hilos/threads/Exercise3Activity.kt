package com.example.android_hilos.threads

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_hilos.R

class Exercise3Activity : AppCompatActivity() {
    private lateinit var tvEvens: TextView
    private lateinit var tvOdds: TextView
    private lateinit var tvLetters: TextView
    private lateinit var btnStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise3)

        tvEvens = findViewById(R.id.tvEvens)
        tvOdds = findViewById(R.id.tvOdds)
        tvLetters = findViewById(R.id.tvLetters)
        btnStart = findViewById(R.id.btnStartEx3)

        btnStart.setOnClickListener {
            btnStart.isEnabled = false
            tvEvens.text = "Pares: "
            tvOdds.text = "Impares: "
            tvLetters.text = "Letras: "

            // Thread 1: Even numbers
            Thread {
                for (i in 0..20 step 2) {
                    try { Thread.sleep(500) } catch (e: Exception) {}
                    runOnUiThread { tvEvens.text = "Pares: $i" }
                }
            }.start()

            // Thread 2: Odd numbers
            Thread {
                for (i in 1..19 step 2) {
                    try { Thread.sleep(500) } catch (e: Exception) {}
                    runOnUiThread { tvOdds.text = "Impares: $i" }
                }
            }.start()

            // Thread 3: Alphabet letters
            Thread {
                for (ch in 'A'..'J') {
                    try { Thread.sleep(600) } catch (e: Exception) {}
                    runOnUiThread { tvLetters.text = "Letras: $ch" }
                }
                runOnUiThread { btnStart.isEnabled = true }
            }.start()
        }
    }
}
