package com.openaidandroidfeatures

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button = findViewById<Button>(R.id.warehouseButton)
        button.setOnClickListener {
            val i = Intent(this, WareHouses::class.java)
            startActivity(i)
        }
    }
}