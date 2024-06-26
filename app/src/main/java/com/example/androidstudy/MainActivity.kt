package com.example.androidstudy

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.CompoundButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.androidstudy.databinding.ActivityMainBinding


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

        binding.spFruits.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View, i: Int, l: Long) {
                // Your code for when an item is selected
                val fruits = view as TextView
                val selectedFruit = fruits.text.toString()
                binding.etPhone.setText(selectedFruit)
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {
                // Your code for when nothing is selected (optional)
            }
        }



        binding.btConfirmation.setOnClickListener {
            val etName = binding.etName.text.toString()
            val etPhone = binding.etPhone.text.toString()
            val rgid = binding.rgGender.checkedRadioButtonId
            val gender = if (rgid == R.id.rb_male) "Male" else "Female"
            val info = "Name: $etName, mobile: $etPhone, gender: $gender, favorite: $selected"

            val builder = AlertDialog.Builder(this@MainActivity)
                .setTitle("Information")
                .setIcon(R.drawable.icon_search)
                .setMessage(info)
                .setPositiveButton(
                    "Positive"
                ) { dialogInterface, i ->
                    // Your code for positive button click
                }
                .setNegativeButton(
                    "Negative"
                ) { dialogInterface, i ->
                    // Your code for negative button click
                }

            builder.create().show()


//            val sb = Snackbar.make(binding.conLayout, info, BaseTransientBottomBar.LENGTH_LONG)
//            sb.setAction("Confirm") {
//                Toast.makeText(this@MainActivity, "Confirmed", Toast.LENGTH_SHORT).show()
//
//                val intent_re = intent
//                val bundle = Bundle()
//                val user = User(
//                    etName,
//                    etPhone,
//                    gender
//                )
//                bundle.putSerializable("user_info", user)
//                intent_re.putExtras(bundle)
//                setResult(RESULT_OK, intent_re)
//                finish()
//            }
//            sb.show()


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