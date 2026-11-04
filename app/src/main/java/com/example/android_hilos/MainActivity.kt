package com.example.android_hilos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_hilos.threads.ThreadsActivity
import com.example.android_hilos.touch.TouchActivity
import com.example.android_hilos.sensors.SensorsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.btnThreads).setOnClickListener {
            startActivity(Intent(this, ThreadsActivity::class.java))
        }

        findViewById<Button>(R.id.btnTouch).setOnClickListener {
            startActivity(Intent(this, TouchActivity::class.java))
        }

        findViewById<Button>(R.id.btnSensors).setOnClickListener {
            startActivity(Intent(this, SensorsActivity::class.java))
        }
    }
}
