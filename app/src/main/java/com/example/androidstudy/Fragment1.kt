package com.example.androidstudy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.androidstudy.databinding.Fragment1Binding

class Fragment1 : Fragment() {
    private lateinit var binding: Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        // Inflate the layout for this fragment
        binding = Fragment1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Receive data from Fragment2
        // Receive data from Fragment2
        parentFragmentManager.setFragmentResultListener("key", viewLifecycleOwner) { _, bundle ->
            val title = bundle.getString("title")
            // Display title in a toast
            Toast.makeText(requireContext(), title, Toast.LENGTH_SHORT).show()
        }

        // Retrieve the bundle
        val bundle = arguments
        if (bundle != null) {
            val content = bundle.getString("content")
            // Do something with the content
            println(content)
            binding.tvTitle.text = content
        }
    }
}