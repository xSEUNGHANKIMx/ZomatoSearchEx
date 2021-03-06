package com.seankim.zomatosearchex.View;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.seankim.zomatosearchex.Model.RspRestaurantBeanModel;
import com.seankim.zomatosearchex.R;
import com.seankim.zomatosearchex.Utils.SeparatorDeco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestDetailTextActivity extends AppCompatActivity {

    MyRecyclerViewAdapter mAdapter;
    List<String> mDetails = new ArrayList<>();
    RspRestaurantBeanModel mRestDetailData = null;

    @BindView(R.id.rvRecyclerView)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail_text);
        ButterKnife.bind(this);

        // data to populate the RecyclerView with
        Gson gson = new Gson();
        String jsonData = getIntent().getStringExtra("DETAIL_TEXT_DATA");
        Map<String, Object> map = new HashMap<>();
        map = (HashMap<String,Object>) gson.fromJson(jsonData, map.getClass());

        for(String key : map.keySet()) {
            String item;
            Object value = map.get(key);
                item = key + " : " + value.toString();

            mDetails.add(item);
        }

        // set up the RecyclerView
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        SeparatorDeco decoration = new SeparatorDeco(this, Color.GRAY, 1.0f);
        mRecyclerView.addItemDecoration(decoration);

        mAdapter = new MyRecyclerViewAdapter(this, mDetails);
        mRecyclerView.setAdapter(mAdapter);
    }

    private class MyRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

        private List<String> mData;
        private LayoutInflater mInflater;

        // data is passed into the constructor
        MyRecyclerViewAdapter(Context context, List<String> data) {
            this.mInflater = LayoutInflater.from(context);
            this.mData = data;
        }

        // inflates the row layout from xml when needed
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.list_item_restaurant_detail_text, parent, false);
            return new ViewHolder(view);
        }

        // binds the data to the TextView in each row
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            String animal = mData.get(position);
            holder.myTextView.setText(animal);
        }

        // total number of rows
        @Override
        public int getItemCount() {
            return mData.size();
        }

        // convenience method for getting data at click position
        String getItem(int id) {
            return mData.get(id);
        }
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tv_restaurant_detail_text);
        }
    }
}
