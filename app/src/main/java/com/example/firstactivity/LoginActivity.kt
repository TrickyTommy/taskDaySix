package com.example.firstactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtpassword)
        val btnLogin = findViewById<Button>(R.id.Login)

        btnLogin.setOnClickListener {
            val password = "sekolah123"
            val email = "sekolah@id"
            val msgEmail: String = edtEmail.text.toString()
            val msgPassword: String = edtPassword.text.toString()

            ///check
            if (msgEmail.trim()==email && msgPassword.trim() == password){
                val intent =  Intent(this@LoginActivity, HomeActivity::class.java)
                startActivity(intent)
            }else if(msgEmail.trim().length>0 && msgPassword.trim().length>0){
            Toast.makeText(applicationContext, "Login....$msgEmail", Toast.LENGTH_SHORT).show()
        }else if ( msgPassword.trim().length>8){
            Toast.makeText(applicationContext, "Password yang anda masukkan kurang", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(applicationContext, "Masukkan Email dan Password", Toast.LENGTH_SHORT).show()
        }
        }

    }
}