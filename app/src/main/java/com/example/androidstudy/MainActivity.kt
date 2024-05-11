package com.example.androidstudy

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var imageView: ImageView
    private var flag = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView1)

        button = findViewById(R.id.button1)
        button.setOnClickListener {
            // Implement your onClick logic here
            button.text = getString(R.string.i_am_changed)
            if (flag == 1) {
                imageView.setImageResource(R.drawable.icon_home_grey)
                flag = 0
            } else {
                imageView.setImageResource(R.drawable.icon_home_selected)
                flag = 1
            }
        }

    }
}