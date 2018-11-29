package com.seankim.zomatosearchex.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RspReviewModel {

    @SerializedName("rating")
    @Expose
    var rating: Double? = null

    @SerializedName("review_text")
    @Expose
    lateinit var review_text: String

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("rating_color")
    @Expose
    lateinit var rating_color: String

    @SerializedName("review_time_friendly")
    @Expose
    lateinit var review_time_friendly: String

    @SerializedName("rating_text")
    @Expose
    lateinit var rating_text: String

    @SerializedName("timestamp")
    @Expose
    var timestamp: Double? = null

    @SerializedName("likes")
    @Expose
    var likes: Int? = null

    @SerializedName("user")
    @Expose
    lateinit var user: RspUserModel

    @SerializedName("comments_count")
    @Expose
    var comments_count: Int? = null
}
