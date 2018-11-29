package com.seankim.zomatosearchex.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RspResLocationModel {

    @SerializedName("address")
    @Expose
    lateinit var address: String

    @SerializedName("locality")
    @Expose
    lateinit var locality: String

    @SerializedName("city")
    @Expose
    lateinit var city: String

    @SerializedName("city_id")
    @Expose
    var city_id: Int? = null

    @SerializedName("latitude")
    @Expose
    var latitude: Double? = null

    @SerializedName("longitude")
    @Expose
    var longitude: Double? = null

    @SerializedName("zipcode")
    @Expose
    lateinit var zipcode: String

    @SerializedName("country_id")
    @Expose
    var country_id: Int? = null

    @SerializedName("locality_verbose")
    @Expose
    lateinit var locality_verbose: String
}
