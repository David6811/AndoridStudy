package com.example.androidstudy

import android.view.View

// Define an interface for item click events
interface OnItemClickListener {
    fun onItemClick(view: View, position: Int)
}
