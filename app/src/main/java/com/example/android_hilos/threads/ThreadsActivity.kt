package com.example.android_hilos.threads

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.android_hilos.R

class ThreadsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_threads_menu)

        findViewById<Button>(R.id.btnEx1).setOnClickListener {
            startActivity(Intent(this, Exercise1Activity::class.java))
        }
        findViewById<Button>(R.id.btnEx2).setOnClickListener {
            startActivity(Intent(this, Exercise2Activity::class.java))
        }
        findViewById<Button>(R.id.btnEx3).setOnClickListener {
            startActivity(Intent(this, Exercise3Activity::class.java))
        }
        findViewById<Button>(R.id.btnEx4).setOnClickListener {
            startActivity(Intent(this, Exercise4Activity::class.java))
        }
        findViewById<Button>(R.id.btnEx5).setOnClickListener {
            startActivity(Intent(this, Exercise5Activity::class.java))
        }
        findViewById<Button>(R.id.btnEx6).setOnClickListener {
            startActivity(Intent(this, Exercise6Activity::class.java))
        }
    }
}
