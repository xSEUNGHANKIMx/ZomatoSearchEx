package com.seankim.zomatosearchex.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SearchResponseModel {

    @SerializedName("location")
    @Expose
    var location: RspCurrLocationModel? = null

    @SerializedName("popularity")
    @Expose
    var popularity: RspPopularityModel? = null

    @SerializedName("link")
    @Expose
    var link: String? = null

    @SerializedName("nearby_restaurants")
    @Expose
    var nearby_restaurants: Array<RspRestaurantModel>? = null
}
