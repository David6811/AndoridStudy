package com.example.androidstudy

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidstudy.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root) // Ensure to set content view
        binding.btLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(
                    this@LoginActivity,
                    "Username and password cannot be null",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                // Move to MainActivity only if both username and password are provided
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
