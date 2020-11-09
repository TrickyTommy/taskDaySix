package com.example.firstactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nama = findViewById<EditText>(R.id.input)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            var name =  nama.text.toString()
            val intent =  Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra("name", name)
            startActivity(intent)
        }





    }

    fun soal_dua(view: View) {
        val intent =  Intent(this@MainActivity, SecondActivity::class.java)
        startActivity(intent)
    }

    fun soal_tiga(view: View) {
        val intent =  Intent(this@MainActivity, LoginActivity::class.java)
        startActivity(intent)
    }


}