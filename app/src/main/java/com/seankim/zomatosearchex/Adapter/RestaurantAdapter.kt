package com.seankim.zomatosearchex.Adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


import com.google.gson.Gson
import com.seankim.zomatosearchex.Model.RspRestaurantModel
import com.seankim.zomatosearchex.R
import com.seankim.zomatosearchex.View.RestDetailTextActivity
import com.seankim.zomatosearchex.View.RestDetailWebViewActivity
import com.squareup.picasso.Picasso

class RestaurantAdapter(var restaurantList: MutableList<RspRestaurantModel>, val context: Context) : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView?) {
        super.onAttachedToRecyclerView(recyclerView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return RestaurantViewHolder(inflater.inflate(R.layout.list_item_restaurant, parent, false))
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.bind(restaurantList[position], position)
        // add click listener
        holder.holder.setOnClickListener {
            val intent = Intent(context.applicationContext, RestDetailWebViewActivity::class.java)
            intent.putExtra("RESTAURANT_URL", restaurantList[position].rspRestaurantBeanModel.url)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    fun updateData(data: List<RspRestaurantModel>) {
        restaurantList.clear()
        restaurantList.addAll(data)
        notifyDataSetChanged()
    }


    inner class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var holder: View
        var tvName: TextView
        var tvLocation: TextView
        var tvAddress: TextView
        var tvCuisine: TextView
        var tvRating: TextView
        var resturentThumnb: ImageView
        var optionBtn: ImageView

        init {
            holder = itemView.findViewById(R.id.item_restaurant_holder)
            resturentThumnb = itemView.findViewById(R.id.iv_thumbnail)
            tvName = itemView.findViewById(R.id.tv_name)
            tvLocation = itemView.findViewById(R.id.tv_location)
            tvAddress = itemView.findViewById(R.id.tv_address)
            tvCuisine = itemView.findViewById(R.id.tv_cuisine)
            tvRating = itemView.findViewById(R.id.tv_rating)
            optionBtn = itemView.findViewById(R.id.iv_more)
        }

        fun bind(result: RspRestaurantModel?, position: Int) {
            if (result != null) {
                setImage(resturentThumnb, result.rspRestaurantBeanModel.thumb)
                tvName.text = result.rspRestaurantBeanModel.name
                tvLocation.text = result.rspRestaurantBeanModel.location.locality
                tvAddress.text = result.rspRestaurantBeanModel.location.address
                tvCuisine.text = result.rspRestaurantBeanModel.cuisines
                tvRating.text = "\u2605 " + "\n" + result.rspRestaurantBeanModel.user_rating.votes!!.toString()
                optionBtn.setOnClickListener {
                    val intent = Intent(context.applicationContext, RestDetailTextActivity::class.java)
                    val gson = Gson()
                    val jsonData = gson.toJson(restaurantList[position].rspRestaurantBeanModel)
                    intent.putExtra("DETAIL_TEXT_DATA", jsonData)
                    context.startActivity(intent)
                }
            }
        }

        fun setImage(view: ImageView, url: String) {
            if (!url.equals("", ignoreCase = true))
                Picasso.with(context).load(url).placeholder(R.drawable.restaurant_icon).into(view)
        }
    }
}




