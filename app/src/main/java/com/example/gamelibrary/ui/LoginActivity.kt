package com.example.gamelibrary.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gamelibrary.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText = findViewById<EditText>(R.id.et_username)
        val passwordEditText = findViewById<EditText>(R.id.et_password)
        val loginButton = findViewById<Button>(R.id.btn_login)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                autenticarUsuario(username, password)
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun autenticarUsuario(username: String, password: String) {
        if (username == "admin" && password == "123") {
            Toast.makeText(this, "Login bem-sucedido", Toast.LENGTH_SHORT).show()
            NavegarHome()
        } else {
            Toast.makeText(this, "Nome de usuário ou senha incorretos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun NavegarHome(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}