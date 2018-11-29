package com.seankim.zomatosearchex.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RspRestaurantModel {
    @SerializedName("restaurant")
    @Expose
    lateinit var rspRestaurantBeanModel: RspRestaurantBeanModel
}
