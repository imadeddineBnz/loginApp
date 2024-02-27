package com.example.firstapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
    }

    fun onLoginClick(view: android.view.View) {
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()

        // Add your login logic here
        if (isValidLogin(username, password)) {
            showToast("Login successful!")
        } else {
            showToast("Invalid username or password")
        }
    }

    private fun isValidLogin(username: String, password: String): Boolean {
        // Add your authentication logic here
        // For simplicity, let's assume a valid login if both fields are non-empty
        return username.isNotEmpty() && password.isNotEmpty()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}