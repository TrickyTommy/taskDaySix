package com.example.firstactivity

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Matcher
import java.util.regex.Pattern


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtpassword)
        val btnLogin = findViewById<Button>(R.id.Login)

        btnLogin.setOnClickListener {
//            val password = "sekolah123"
//            val email = "sekolah@id"
            val msgEmail: String = edtEmail.text.toString()
            val msgPassword: String = edtPassword.text.toString()

            ///check

//
            if (edtEmail.text.toString().isEmpty()) {
                edtEmail.error = "Username harus terisi"
                return@setOnClickListener
            }
            if (edtPassword.text.toString().isEmpty()) {
                edtPassword.error = "Password harus terisi"
                return@setOnClickListener
            }
            if(msgPassword.length<8){
                Toast.makeText( this.applicationContext,"password Kurang dari 8 ", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (edtEmail.text.toString().isEmailValid() ){
                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                startActivity(intent)
            }else{
                edtEmail.error = "Tidak Sesuai ketentuan email"
                Toast.makeText( this.applicationContext,"Tidak Sesuai ketentuan email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (isValidPassword(edtPassword.getText().toString().trim())) {
                Toast.makeText( this.applicationContext,"valid...", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                startActivity(intent)
            }
        }


    }

    fun isValidPassword(password: String?): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"
        pattern = Pattern.compile(PASSWORD_PATTERN)
        matcher = pattern.matcher(password)
        return matcher.matches()
    }

    private fun String.isEmailValid(): Boolean {
        val pattern = Patterns.EMAIL_ADDRESS.matcher(this).matches()
        return pattern
    }

}