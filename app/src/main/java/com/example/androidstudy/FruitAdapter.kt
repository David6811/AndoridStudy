package com.example.androidstudy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FruitAdapter(private val fruitList: List<Fruit>) : RecyclerView.Adapter<FruitAdapter.ViewHolder>() {
    private lateinit var onItemClickListener: OnItemClickListener

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.bind(fruit)

        holder.itemView.setOnClickListener {
            // Your onClick listener logic here
            onItemClickListener.onItemClick(holder.itemView, position)
        }
    }


    override fun getItemCount(): Int {
        return fruitList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val fruitNameTextView: TextView = itemView.findViewById(R.id.textView)
        private val fruitImageView: ImageView = itemView.findViewById(R.id.imageView2)

        fun bind(fruit: Fruit) {
            fruitNameTextView.text = fruit.name
            fruitImageView.setImageResource(fruit.imgId)
        }
    }

}
