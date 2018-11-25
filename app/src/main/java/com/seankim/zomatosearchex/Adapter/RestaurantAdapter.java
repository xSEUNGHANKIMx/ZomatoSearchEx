package com.seankim.zomatosearchex.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.gson.Gson;
import com.seankim.zomatosearchex.Model.RspRestaurantModel;
import com.seankim.zomatosearchex.R;
import com.seankim.zomatosearchex.View.RestDetailTextActivity;
import com.seankim.zomatosearchex.View.RestDetailWebViewActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {
    List<RspRestaurantModel> mRestaurantList = new ArrayList<>();
    Context mContext;

    @Override
    public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        mContext = parent.getContext();
        return new RestaurantViewHolder(inflater.inflate(R.layout.list_item_restaurant, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, final int position) {
        holder.bind(mRestaurantList.get(position), position);
        // add click listener
        holder.holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext.getApplicationContext(), RestDetailWebViewActivity.class);
                intent.putExtra("RESTAURANT_URL", mRestaurantList.get(position).getRspRestaurantBeanModel().getUrl());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRestaurantList.size();
    }

    public void displayResults(List<RspRestaurantModel> results) {
        this.mRestaurantList = results;
        notifyDataSetChanged();
    }

    class RestaurantViewHolder extends RecyclerView.ViewHolder {
        public View holder;
        public TextView tvName, tvLocation, tvAddress, tvCuisine, tvRating;
        public ImageView resturentThumnb, optionBtn;

        public RestaurantViewHolder(View itemView) {
            super(itemView);
            holder = itemView.findViewById(R.id.item_restaurant_holder);
            resturentThumnb = itemView.findViewById(R.id.iv_thumbnail);
            tvName = itemView.findViewById(R.id.tv_name);
            tvLocation = itemView.findViewById(R.id.tv_location);
            tvAddress = itemView.findViewById(R.id.tv_address);
            tvCuisine = itemView.findViewById(R.id.tv_cuisine);
            tvRating = itemView.findViewById(R.id.tv_rating);
            optionBtn = itemView.findViewById(R.id.iv_more);
        }

        public void bind(RspRestaurantModel result, final int position) {
            if(result != null ) {
                setImage(resturentThumnb, result.getRspRestaurantBeanModel().getThumb());
                tvName.setText(result.getRspRestaurantBeanModel().getName());
                tvLocation.setText(result.getRspRestaurantBeanModel().getLocation().getLocality());
                tvAddress.setText(result.getRspRestaurantBeanModel().getLocation().getAddress());
                tvCuisine.setText(result.getRspRestaurantBeanModel().getCuisines());
                tvRating.setText("\u2605 " + "\n" + result.getRspRestaurantBeanModel().getUser_rating().getVotes().toString());
                optionBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(mContext.getApplicationContext(), RestDetailTextActivity.class);
                        Gson gson = new Gson();
                        String jsonData = gson.toJson(mRestaurantList.get(position).getRspRestaurantBeanModel());
                        intent.putExtra("DETAIL_TEXT_DATA", jsonData);
                        mContext.startActivity(intent);
                    }
                });
            }
        }

        public void setImage(ImageView view, String url) {
            if (!url.equalsIgnoreCase(""))
                Picasso.with(mContext).load(url).placeholder(R.drawable.restaurant_icon).into(view);
        }
    }
}




