package com.example.androidstudy

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    private val fruits: MutableList<Fruit> = mutableListOf(
        Fruit("Apple", R.drawable.ic_launcher_background),
        Fruit("Orange", R.drawable.ic_launcher_foreground)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.VERTICAL
        recyclerView.layoutManager = layoutManager

        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        val adapter = FruitAdapter(fruits)
        adapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                // Handle item click here
                Toast.makeText(this@MainActivity, "aaas $position", Toast.LENGTH_SHORT).show()
                // Perform your action with the clicked fruit
            }
        })

        recyclerView.adapter = adapter
    }
}
