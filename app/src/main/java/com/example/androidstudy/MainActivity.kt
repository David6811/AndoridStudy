package com.example.androidstudy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidstudy.databinding.ActivityMainBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var info: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btConfirmation.setOnClickListener{
            info = binding.etName.text.toString()
            Snackbar.make(binding.conLayout, info, BaseTransientBottomBar.LENGTH_LONG).show()
        }
    }
}