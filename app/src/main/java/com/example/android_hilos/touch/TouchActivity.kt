package com.example.android_hilos.touch

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.android_hilos.R

class TouchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_touch_menu)

        val btnIds = listOf(
            R.id.btnEx7 to Exercise7Activity::class.java,
            R.id.btnEx8 to Exercise8Activity::class.java,
            R.id.btnEx9 to Exercise9Activity::class.java,
            R.id.btnEx10 to Exercise10Activity::class.java,
            R.id.btnEx11 to Exercise11Activity::class.java,
            R.id.btnEx12 to Exercise12Activity::class.java,
            R.id.btnEx13 to Exercise13Activity::class.java,
            R.id.btnEx14 to Exercise14Activity::class.java,
            R.id.btnEx15 to Exercise15Activity::class.java,
            R.id.btnEx16 to Exercise16Activity::class.java,
            R.id.btnEx17 to Exercise17Activity::class.java,
            R.id.btnEx18 to Exercise18Activity::class.java
        )

        for ((id, clazz) in btnIds) {
            findViewById<Button>(id).setOnClickListener {
                startActivity(Intent(this, clazz))
            }
        }
    }
}
