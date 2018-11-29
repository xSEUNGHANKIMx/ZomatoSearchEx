package com.seankim.zomatosearchex.View

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Location
import android.location.LocationManager
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.seankim.zomatosearchex.Model.SearchResponseModel
import com.seankim.zomatosearchex.Adapter.RestaurantAdapter
import com.seankim.zomatosearchex.API.ZomatoAPI
import com.seankim.zomatosearchex.R
import com.seankim.zomatosearchex.Utils.SeparatorDeco

import java.util.Arrays

import butterknife.BindView
import butterknife.ButterKnife
import com.seankim.zomatosearchex.Model.RspRestaurantModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.AccessController.getContext
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private var mRestaurantAdapter: RestaurantAdapter? = null
    private var mCurrLocation: Location? = null
    private val REQUEST_PERMISSIONS = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)
    private val REQUEST_CODE_PERMISSION = 1
    internal var mRestaurantList: MutableList<RspRestaurantModel> = ArrayList()

    @BindView(R.id.rv_list)
    internal var mRecyclerView: RecyclerView? = null

    private val currLocation: Location?
        get() {
            val lm = getSystemService(Context.LOCATION_SERVICE) as LocationManager
            var fineLocation: Location? = null
            var coarseLocation: Location? = null
            var currLocation: Location? = null
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                if (lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    fineLocation = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                } else if (lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                    fineLocation = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                }

            }

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                coarseLocation = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
            }

            if (fineLocation != null && coarseLocation != null) {
                if (fineLocation.accuracy < coarseLocation.accuracy) {
                    currLocation = fineLocation
                } else {
                    currLocation = coarseLocation
                }
            } else if (fineLocation != null && coarseLocation == null) {
                currLocation = fineLocation
            } else if (fineLocation == null && coarseLocation != null) {
                currLocation = coarseLocation
            }

            return currLocation
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, REQUEST_PERMISSIONS, REQUEST_CODE_PERMISSION)
        } else {
            mCurrLocation = currLocation
        }

        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        val retrofit = Retrofit.Builder()
                .baseUrl("https://developers.zomato.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val zomatoAPI = retrofit.create<ZomatoAPI>(ZomatoAPI::class.java!!)
        mRecyclerView = RecyclerView(this);
        mRestaurantAdapter = RestaurantAdapter(mRestaurantList, this)
        mRecyclerView!!.adapter = mRestaurantAdapter
        val decoration = SeparatorDeco(this, Color.GRAY, 1.0f)
        mRecyclerView!!.addItemDecoration(decoration)

        queryToServer(zomatoAPI)
    }

    private fun queryToServer(api: ZomatoAPI) {
        if (mCurrLocation != null) {
            val lat = mCurrLocation!!.latitude.toString()
            val lon = mCurrLocation!!.longitude.toString()

            api.query(lat, lon).enqueue(object : Callback<SearchResponseModel> {
                override fun onResponse(call: Call<SearchResponseModel>, response: Response<SearchResponseModel>) {
                    if (response.isSuccessful) {
                        val responseModel = response.body()

                        if (responseModel != null) {
                            mRestaurantList = Arrays.asList<RspRestaurantModel>(*responseModel.nearby_restaurants!!)
                            mRestaurantAdapter?.updateData(mRestaurantList)
                        }
                    }
                }

                override fun onFailure(call: Call<SearchResponseModel>, t: Throwable) {
                }
            })
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (requestCode == REQUEST_CODE_PERMISSION) {
            if (grantResults.size == REQUEST_PERMISSIONS.size && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                mCurrLocation = currLocation
            } else {
                this.finish()
            }
        }
    }


}
