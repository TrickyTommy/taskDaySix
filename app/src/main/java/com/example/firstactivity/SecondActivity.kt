package com.example.firstactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

private val SECOND_ACTIVITY_REQUEST_CODE = 0

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)



    }

    fun Result(view: View) {
        var intent = Intent(this, ResultActivity::class.java)
        startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Check that it is the SecondActivity with an OK result
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {

                // Get String data from Intent
                val returnString = data!!.getStringExtra("keyName")

                // Set text view with string

//                val textView = findViewById<TextView>(R.id.textView)
//                textView.text = returnString
                Toast.makeText( this.applicationContext,returnString, Toast.LENGTH_SHORT).show()
            }
        }
    }


}