package com.seankim.zomatosearchex.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RspPhotoModel {

    @SerializedName("id")
    @Expose
    lateinit var id: String

    @SerializedName("url")
    @Expose
    lateinit var url: String

    @SerializedName("thumb_url")
    @Expose
    lateinit var thumb_url: String

    @SerializedName("user")
    @Expose
    lateinit var user: RspUserModel

    @SerializedName("res_id")
    @Expose
    var res_id: Int? = null

    @SerializedName("caption")
    @Expose
    lateinit var caption: String

    @SerializedName("timestamp")
    @Expose
    var timestamp: Int? = null

    @SerializedName("friendly_time")
    @Expose
    lateinit var friendly_time: String

    @SerializedName("width")
    @Expose
    var width: Int? = null

    @SerializedName("height")
    @Expose
    var height: Int? = null

    @SerializedName("comments_count")
    @Expose
    var comments_count: Int? = null

    @SerializedName("likes_count")
    @Expose
    var likes_count: Int? = null
}
