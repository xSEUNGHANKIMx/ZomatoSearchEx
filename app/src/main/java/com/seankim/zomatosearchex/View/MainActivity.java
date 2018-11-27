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
    private final String[] REQUEST_PERMISSIONS = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };
    private final int REQUEST_CODE_PERMISSION = 1;

    @BindView(R.id.rv_list)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ((ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED)
                || (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED)) {
            ActivityCompat.requestPermissions(this, REQUEST_PERMISSIONS, REQUEST_CODE_PERMISSION);
        } else {
            mCurrLocation = getCurrLocation();
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

    private Location getCurrLocation() {
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location fineLocation = null;
        Location coarseLocation = null;
        Location currLocation = null;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if(lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                fineLocation = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            } else if(lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                fineLocation = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            }

        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            coarseLocation =  lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        }

        if((fineLocation != null) && (coarseLocation != null)) {
            if(fineLocation.getAccuracy() < coarseLocation.getAccuracy()) {
                currLocation = fineLocation;
            } else {
                currLocation = coarseLocation;
            }
        } else if ((fineLocation != null) && (coarseLocation == null)) {
            currLocation = fineLocation;
        } else if ((fineLocation == null) && (coarseLocation != null)) {
            currLocation = coarseLocation;
        }

        return currLocation;
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
                    int i = 0;
                    i += 1;
                }
            });
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == REQUEST_CODE_PERMISSION) {
            if((grantResults.length == REQUEST_PERMISSIONS.length)
                && ((grantResults[0] == PackageManager.PERMISSION_GRANTED)
                && (grantResults[1] == PackageManager.PERMISSION_GRANTED))) {
                mCurrLocation = getCurrLocation();
            } else {
                this.finish();
            }
        }
    }
}
