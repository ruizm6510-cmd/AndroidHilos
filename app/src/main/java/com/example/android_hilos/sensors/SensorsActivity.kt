package com.example.android_hilos.sensors

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.android_hilos.R

class SensorsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensors_menu)

        val btnIds = listOf(
            R.id.btnEx19 to Exercise19Activity::class.java,
            R.id.btnEx20 to Exercise20Activity::class.java,
            R.id.btnEx21 to Exercise21Activity::class.java,
            R.id.btnEx22 to Exercise22Activity::class.java,
            R.id.btnEx23 to Exercise23Activity::class.java,
            R.id.btnEx24 to Exercise24Activity::class.java,
            R.id.btnEx25 to Exercise25Activity::class.java,
            R.id.btnEx26 to Exercise26Activity::class.java,
            R.id.btnEx27 to Exercise27Activity::class.java,
            R.id.btnEx28 to Exercise28Activity::class.java
        )

        for ((id, clazz) in btnIds) {
            findViewById<Button>(id).setOnClickListener {
                startActivity(Intent(this, clazz))
            }
        }
    }
}
