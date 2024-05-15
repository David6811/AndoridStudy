package com.example.androidstudy

import android.content.Intent
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidstudy.databinding.ActivityMainBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var info: String = ""
    private var selected = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val username = intent.getStringExtra("user_name")
        binding.etName.setText(username)
        Toast.makeText(this@MainActivity, "$username, How are you", Toast.LENGTH_SHORT).show()


        val checkBoxListener = CheckBoxListener()
        binding.cbJava.setOnCheckedChangeListener(checkBoxListener)
        binding.cbAndroid.setOnCheckedChangeListener(checkBoxListener)
        binding.cbEnglish.setOnCheckedChangeListener(checkBoxListener)


        binding.btConfirmation.setOnClickListener {
            val etName = binding.etName.text.toString()
            val etPhone = binding.etPhone.text.toString()
            val rgid = binding.rgGender.checkedRadioButtonId
            val gender = if (rgid == R.id.rb_male) "Male" else "Female"
            val info = "Name: $etName, mobile: $etPhone, gender: $gender, favorite: $selected"

            val sb = Snackbar.make(binding.conLayout, info, BaseTransientBottomBar.LENGTH_LONG)
            sb.setAction("Confirm") {
                Toast.makeText(this@MainActivity, "Confirmed", Toast.LENGTH_SHORT).show()

                val intent_re = intent
                val bundle = Bundle()
                val user = User(
                    etName,
                    etPhone,
                    gender
                )
                bundle.putSerializable("user_info", user)
                intent_re.putExtras(bundle)
                setResult(RESULT_OK, intent_re)
                finish()
            }
            sb.show()


        }
    }

    inner class CheckBoxListener : CompoundButton.OnCheckedChangeListener {
        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            if (isChecked) {
                selected += buttonView?.text.toString() + ","
            } else {
                selected = selected.replace(buttonView?.text.toString() + ",", "")
                selected.trim()
            }
        }
    }


}