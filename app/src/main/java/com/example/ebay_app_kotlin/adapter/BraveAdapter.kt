package com.example.ebay_app_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ebay_app_kotlin.R
import com.example.ebay_app_kotlin.model.Brave
import com.example.ebay_app_kotlin.model.Favorite
import com.google.android.material.imageview.ShapeableImageView

class BraveAdapter(var context: Context, var items: ArrayList<Brave>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_brave_layout,parent,false)
        return BraveViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       val item = items[position]

        if (holder is BraveViewHolder){
            var tv_title = holder.tv_title
            var iv_image = holder.iv_image

            iv_image.setImageResource(item.image)
            tv_title.text = item.title
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class BraveViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var tv_title: TextView
    var iv_image: ShapeableImageView
    init {
        tv_title = view.findViewById(R.id.tv_details_brave)
        iv_image = view.findViewById(R.id.iv_image_brave)
    }

}
