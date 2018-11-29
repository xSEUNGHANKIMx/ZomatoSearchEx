package com.seankim.zomatosearchex.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RspUserModel {

    @SerializedName("name")
    @Expose
    lateinit var name: String

    @SerializedName("zomato_handle")
    @Expose
    lateinit var zomato_handle: String

    @SerializedName("foodie_level")
    @Expose
    lateinit var foodie_level: String

    @SerializedName("foodie_level_num")
    @Expose
    var foodie_level_num: Int? = null

    @SerializedName("foodie_color")
    @Expose
    lateinit var foodie_color: String

    @SerializedName("profile_url")
    @Expose
    lateinit var profile_url: String

    @SerializedName("profile_deeplink")
    @Expose
    lateinit var profile_deeplink: String

    @SerializedName("profile_image")
    @Expose
    lateinit var profile_image: String


}
