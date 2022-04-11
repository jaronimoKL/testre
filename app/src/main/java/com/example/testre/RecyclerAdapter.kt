package com.example.testre

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerAdapter(val context: Context,val list: feelings):
RecyclerView.Adapter<RecyclerAdapter.MyWH>(){
class MyWH(itemView: View): RecyclerView.ViewHolder(itemView) {
    val imageView:ImageView = itemView.findViewById(R.id.imageView2)
    val textView:TextView = itemView.findViewById(R.id.textView)
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyWH {
        val root = LayoutInflater.from(context).inflate(R.layout.tewtde,parent,false)
        return MyWH(root)
    }

    override fun onBindViewHolder(holder: MyWH, position: Int) {
       holder.textView.text = list.data[position].title
        Glide.with(context).load(list.data[position].image).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return list.data.size
    }
}