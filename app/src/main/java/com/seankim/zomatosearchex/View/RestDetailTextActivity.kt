package com.seankim.zomatosearchex.View

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.google.gson.Gson
import com.seankim.zomatosearchex.Model.RspRestaurantBeanModel
import com.seankim.zomatosearchex.R
import com.seankim.zomatosearchex.Utils.SeparatorDeco

import java.util.ArrayList
import java.util.HashMap

import butterknife.BindView
import butterknife.ButterKnife

class RestDetailTextActivity : AppCompatActivity() {

    internal lateinit var mAdapter: MyRecyclerViewAdapter
    internal var mDetails: MutableList<String> = ArrayList()
    internal var mRestDetailData: RspRestaurantBeanModel? = null

    @BindView(R.id.rvRecyclerView)
    internal var mRecyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_detail_text)
        ButterKnife.bind(this)

        // data to populate the RecyclerView with
        val gson = Gson()
        val jsonData = intent.getStringExtra("DETAIL_TEXT_DATA")
        var map: Map<String, Any> = HashMap()
        map = gson.fromJson(jsonData, map.javaClass)

        for (key in map.keys) {
            val item: String
            val value = map[key]
            item = key + " : " + value.toString()

            mDetails.add(item)
        }

        // set up the RecyclerView
        mRecyclerView!!.layoutManager = LinearLayoutManager(this)
        val decoration = SeparatorDeco(this, Color.GRAY, 1.0f)
        mRecyclerView!!.addItemDecoration(decoration)

        mAdapter = MyRecyclerViewAdapter(this, mDetails)
        mRecyclerView!!.adapter = mAdapter
    }

    inner class MyRecyclerViewAdapter// data is passed into the constructor
    internal constructor(context: Context, private val mData: List<String>) : RecyclerView.Adapter<ViewHolder>() {
        private val mInflater: LayoutInflater

        init {
            this.mInflater = LayoutInflater.from(context)
        }

        // inflates the row layout from xml when needed
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = mInflater.inflate(R.layout.list_item_restaurant_detail_text, parent, false)
            return ViewHolder(view)
        }

        // binds the data to the TextView in each row
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val animal = mData[position]
            holder.myTextView.text = animal
        }

        // total number of rows
        override fun getItemCount(): Int {
            return mData.size
        }

        // convenience method for getting data at click position
        internal fun getItem(id: Int): String {
            return mData[id]
        }
    }

    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var myTextView: TextView

        init {
            myTextView = itemView.findViewById(R.id.tv_restaurant_detail_text)
        }
    }
}
