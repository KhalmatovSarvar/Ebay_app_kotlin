package com.example.ebay_app_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ebay_app_kotlin.R
import com.example.ebay_app_kotlin.model.Deal
import com.example.ebay_app_kotlin.model.Favorite

class DealsAdapter(var context: Context, var items: ArrayList<Deal>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_deals_layout,parent,false)
        return DealViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       val item = items[position]

        if (holder is DealViewHolder){
            var tv_title = holder.tv_title
            var tv_price = holder.tv_price
            var iv_image = holder.iv_image

            iv_image.setImageResource(item.image)
            tv_title.text = item.title
            tv_price.text = "$ "+item.price
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class DealViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var tv_title: TextView
    var tv_price: TextView
    var iv_image: ImageView
    init {
        tv_title = view.findViewById(R.id.tv_details_deals)
        tv_price = view.findViewById(R.id.tv_details_price)
        iv_image = view.findViewById(R.id.iv_image_deals)
    }

}
