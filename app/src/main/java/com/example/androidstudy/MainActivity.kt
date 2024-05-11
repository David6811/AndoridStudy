package com.example.androidstudy

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    private lateinit var editText: EditText
    private var flag = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView1)

        textView = findViewById(R.id.textView2)
        editText = findViewById(R.id.editText1)

        button = findViewById(R.id.button1)
        button.setOnClickListener {
            button.text = getString(R.string.i_am_changed)
            textView.text = editText.getText().toString()
            flag = if (flag == 1) {
                imageView.setImageResource(R.drawable.icon_home_grey)
                0
            } else {
                imageView.setImageResource(R.drawable.icon_home_selected)
                1
            }
        }

    }
}