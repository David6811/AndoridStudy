package com.example.androidstudy

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    private lateinit var editText: EditText
    private var flag = 1;

    @SuppressLint("InflateParams")
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

            //Toast.makeText(this@MainActivity, "Hello", Toast.LENGTH_LONG).show()
//            Toast.makeText(this@MainActivity, "Hello", Toast.LENGTH_LONG)
//                .apply { setGravity(Gravity.CENTER, 0, 0) }
//                .show()

            // Inflate the custom layout for the toast message
            val inflater = LayoutInflater.from(this@MainActivity)
            val layout = inflater.inflate(R.layout.toast_layout, null)

            val toast = Toast(this@MainActivity)
            toast.duration = Toast.LENGTH_LONG
            toast.view = layout
            toast.show()

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