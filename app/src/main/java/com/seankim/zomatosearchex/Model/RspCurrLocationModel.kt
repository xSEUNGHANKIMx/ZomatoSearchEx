package com.seankim.zomatosearchex.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RspCurrLocationModel {

    @SerializedName("entity_type")
    @Expose
    lateinit var entity_type: String

    @SerializedName("entity_id")
    @Expose
    var entity_id: Int? = null

    @SerializedName("title")
    @Expose
    lateinit var title: String

    @SerializedName("latitude")
    @Expose
    var latitude: Double? = null

    @SerializedName("longitude")
    @Expose
    var longitude: Double? = null

    @SerializedName("city_id")
    @Expose
    var city_id: Int? = null

    @SerializedName("city_name")
    @Expose
    lateinit var city_name: String

    @SerializedName("country_id")
    @Expose
    var country_id: Int? = null

    @SerializedName("country_name")
    @Expose
    lateinit var country_name: String
}
