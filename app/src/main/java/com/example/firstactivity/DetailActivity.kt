package com.example.firstactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var intent = intent
        val name = intent.getStringExtra("name")
        // text view
        val detail = findViewById<TextView>(R.id.outNama)
        //set name
        detail.text = "name:  $name"

    }
}