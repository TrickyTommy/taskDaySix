package com.example.firstactivity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Matcher


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

//
            if (edtEmail.text.toString().isEmpty()) {
                edtEmail.error = "Username harus terisi"
                return@setOnClickListener
            }
            if (edtPassword.text.toString().isEmpty()) {
                edtPassword.error = "Password harus terisi"
                return@setOnClickListener
            }
            if (msgEmail.isEmailValid() && msgPassword.isPasswordValid()){
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }


    }

    private fun String.isPasswordValid(): Boolean {
        return !TextUtils.isEmpty(this) && this.matches(Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~\$^+=<>]).{8,20}\$"))
    }

    private fun String.isEmailValid(): Boolean {
        return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this)
            .matches()
    }
//    fun isEmailValid(email: String?): Boolean {
//        val pattern = Patterns.EMAIL_ADDRESS
//        val matcher: Matcher = pattern.matcher(email)
//        return matcher.matches()
//    }
}