package com.seankim.zomatosearchex.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RspPopularityModel {

    @SerializedName("popularity")
    @Expose
    internal var popularity: Double? = null

    @SerializedName("nightlife_index")
    @Expose
    internal var nightlife_index: Double? = null

    @SerializedName("nearby_res")
    @Expose
    internal var nearby_res: Array<String>? = null

    @SerializedName("top_cuisines")
    @Expose
    internal var top_cuisines: Array<String>? = null

    @SerializedName("popularity_res")
    @Expose
    internal var popularity_res: Double? = null

    @SerializedName("nightlife_res")
    @Expose
    internal var nightlife_res: Double? = null

    @SerializedName("subzone")
    @Expose
    internal var subzone: String? = null

    @SerializedName("subzone_id")
    @Expose
    internal var subzone_id: Int? = null

    @SerializedName("city")
    @Expose
    internal var city: String? = null
}
