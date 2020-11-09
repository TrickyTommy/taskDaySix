package com.example.firstactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
    }

    fun buttonclick(view: View) {
        //get text
        val editText = findViewById(R.id.editKata) as EditText
        val stringTopassBack = editText.text.toString()
        //put
        val intent = Intent()
        intent.putExtra("keyName", stringTopassBack)
        setResult(Activity.RESULT_OK, intent)
        finish()


    }
}