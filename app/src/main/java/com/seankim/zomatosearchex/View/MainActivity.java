package com.seankim.zomatosearchex.View;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.seankim.zomatosearchex.Model.SearchResponseModel;
import com.seankim.zomatosearchex.Adapter.RestaurantAdapter;
import com.seankim.zomatosearchex.API.ZomatoAPI;
import com.seankim.zomatosearchex.R;
import com.seankim.zomatosearchex.Utils.SeparatorDeco;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RestaurantAdapter mRestaurantAdapter;
    private Location mCurrLocation = null;
    private static final int REQUEST_CODE_PERMISSION = 1;

    @BindView(R.id.rv_list)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_PERMISSION);
        } else {
            mCurrLocation = getLastLocation();
        }

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://developers.zomato.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final ZomatoAPI zomatoAPI = retrofit.create(ZomatoAPI.class);
        mRestaurantAdapter = new RestaurantAdapter();
        mRecyclerView.setAdapter(mRestaurantAdapter);
        SeparatorDeco decoration = new SeparatorDeco(this, Color.GRAY, 1.0f);
        mRecyclerView.addItemDecoration(decoration);

        queryToServer(zomatoAPI);
    }

    private Location getLastLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            return lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        }

        return null;
    }

    private void queryToServer(ZomatoAPI api) {
        if(mCurrLocation != null) {
            String lat = String.valueOf(mCurrLocation.getLatitude());
            String lon = String.valueOf(mCurrLocation.getLongitude());

            api.query(String.valueOf(lat), String.valueOf(lon)).enqueue(new Callback<SearchResponseModel>() {
                @Override
                public void onResponse(Call<SearchResponseModel> call, Response<SearchResponseModel> response) {
                    if (response.isSuccessful()) {
                        SearchResponseModel responseModel = response.body();

                        if (responseModel != null) {
                            mRestaurantAdapter.displayResults(Arrays.asList(responseModel.getNearby_restaurants()));
                        }
                    }
                }

                @Override
                public void onFailure(Call<SearchResponseModel> call, Throwable t) {
                }
            });
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == REQUEST_CODE_PERMISSION) {
            if((grantResults.length == 1) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                mCurrLocation = getLastLocation();
            } else {
                this.finish();
            }
        }
    }
}
