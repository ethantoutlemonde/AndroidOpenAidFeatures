package com.openaidandroidfeatures

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var b1 = findViewById<Button>(R.id.btnPlay)

        b1.setOnClickListener {
            val i = Intent(this, MainActivity2::class.java)
            startActivity(i)
        }

    }
}