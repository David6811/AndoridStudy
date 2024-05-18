package com.example.androidstudy

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.androidstudy.databinding.Fragment2Binding

class Fragment2 : Fragment(R.layout.fragment2) {
    private lateinit var fsl: FragmentSendMessageListener
    private lateinit var binding: Fragment2Binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = Fragment2Binding.bind(view)

        binding.btSentMsg.setOnClickListener {
            if (context is FragmentSendMessageListener) {
                fsl = context as FragmentSendMessageListener
                fsl.getMsgFromFragment("I am from fragment2's button")

                //Implement communication between fragments
                //Create Bundle
                // Create a Bundle
                val fragment2Bundle = Bundle().apply {
                    putString("title", "I am from fragment2 want to fragment1")
                }
                // Set the result from Fragment2
                parentFragmentManager.setFragmentResult("key", fragment2Bundle)

            } else {
                throw RuntimeException("$context must implement FragmentSendMessageListener")
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentSendMessageListener) {
            fsl = context
            fsl.getMsgFromFragment("I am from fragment2")
        } else {
            throw RuntimeException("$context must implement FragmentSendMessageListener")
        }
    }
}