package com.example.ebay_app_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ebay_app_kotlin.adapter.BraveAdapter
import com.example.ebay_app_kotlin.adapter.DealsAdapter
import com.example.ebay_app_kotlin.adapter.favoriteAdapter
import com.example.ebay_app_kotlin.model.Brave
import com.example.ebay_app_kotlin.model.Deal
import com.example.ebay_app_kotlin.model.Favorite

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerViewDeal: RecyclerView
    lateinit var recyclerViewBrave: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recycler_view)
        recyclerViewDeal = findViewById(R.id.rv_deals)
        recyclerViewBrave = findViewById(R.id.rv_brave)

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerViewDeal.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerViewBrave.layoutManager = GridLayoutManager(this,2,GridLayoutManager.HORIZONTAL,false)
        refreshAdapter(getItems())
        refreshAdapterDeal(getDeals())
        refreshAdapterBrave(getBraves())
    }

    private fun refreshAdapter(items: ArrayList<Favorite>) {
        val adapter = favoriteAdapter(this,items)
        recyclerView.adapter = adapter
    }
    private fun refreshAdapterDeal(items: ArrayList<Deal>) {
        val adapter = DealsAdapter(this,items)
        recyclerViewDeal.adapter = adapter
    }
    private fun refreshAdapterBrave(items: ArrayList<Brave>) {
        val adapter = BraveAdapter(this,items)
        recyclerViewBrave.adapter = adapter
    }

    private fun getDeals(): ArrayList<Deal> {
        val items:ArrayList<Deal> = ArrayList()

        items.add(Deal("Trainer Russian",R.drawable.trainer_1,"123"))
        items.add(Deal("Trainer Chinese",R.drawable.trainer_2,"12"))
        items.add(Deal("Trainer Nike",R.drawable.trainer_3,"78"))
        items.add(Deal("Trainer Adidas",R.drawable.trainer_4,"42"))
        return items
    }

    private fun getItems(): ArrayList<Favorite> {
        val items:ArrayList<Favorite> = ArrayList()

        items.add(Favorite("Camera pro",R.drawable.camera_1))
        items.add(Favorite("Camera Max",R.drawable.camera_2))
        items.add(Favorite("Camera Ultra",R.drawable.camera_3))
        items.add(Favorite("Camera HD",R.drawable.camera_4))

        return items
    }

    private fun getBraves(): ArrayList<Brave> {
        val items:ArrayList<Brave> = ArrayList()

        items.add(Brave("Trainer Adidas",R.drawable.trainer_4))
        items.add(Brave("Trainer Nike",R.drawable.trainer_3))
        items.add(Brave("Camera pro",R.drawable.camera_1))
        items.add(Brave("Camera Max",R.drawable.camera_2))
        items.add(Brave("Trainer Chinese",R.drawable.trainer_2))
        items.add(Brave("Camera HD",R.drawable.camera_4))
        items.add(Brave("Trainer Russian",R.drawable.trainer_1))
        items.add(Brave("Camera Ultra",R.drawable.camera_3))
        return items
    }
}