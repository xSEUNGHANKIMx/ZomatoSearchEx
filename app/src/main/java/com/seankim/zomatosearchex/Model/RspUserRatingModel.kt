package com.seankim.zomatosearchex.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RspUserRatingModel {

    @SerializedName("aggregate_rating")
    @Expose
    var aggregate_rating: Double? = null

    @SerializedName("rating_text")
    @Expose
    lateinit var rating_text: String

    @SerializedName("rating_color")
    @Expose
    lateinit var rating_color: String

    @SerializedName("votes")
    @Expose
    var votes: Double? = null
}
