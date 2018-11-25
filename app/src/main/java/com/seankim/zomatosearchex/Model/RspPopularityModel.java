package com.seankim.zomatosearchex.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RspPopularityModel {

    @SerializedName("popularity")
    @Expose
    Double popularity;

    @SerializedName("nightlife_index")
    @Expose
    Double nightlife_index;

    @SerializedName("nearby_res")
    @Expose
    String[] nearby_res;

    @SerializedName("top_cuisines")
    @Expose
    String[] top_cuisines;

    @SerializedName("popularity_res")
    @Expose
    Double popularity_res;

    @SerializedName("nightlife_res")
    @Expose
    Double nightlife_res;

    @SerializedName("subzone")
    @Expose
    String subzone;

    @SerializedName("subzone_id")
    @Expose
    Integer subzone_id;

    @SerializedName("city")
    @Expose
    String city;
}
