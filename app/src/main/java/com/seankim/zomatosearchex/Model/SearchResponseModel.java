package com.seankim.zomatosearchex.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchResponseModel {

    @SerializedName("location")
    @Expose
    private RspCurrLocationModel location;

    @SerializedName("popularity")
    @Expose
    private RspPopularityModel popularity;

    @SerializedName("link")
    @Expose
    private String link;

    @SerializedName("nearby_restaurants")
    @Expose
    private RspRestaurantModel[] nearby_restaurants;

    public RspCurrLocationModel getLocation() {
        return location;
    }

    public void setLocation(RspCurrLocationModel location) {
        this.location = location;
    }

    public RspPopularityModel getPopularity() {
        return popularity;
    }

    public void setPopularity(RspPopularityModel popularity) {
        this.popularity = popularity;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public RspRestaurantModel[] getNearby_restaurants() {
        return nearby_restaurants;
    }

    public void setNearby_restaurants(RspRestaurantModel[] nearby_restaurants) {
        this.nearby_restaurants = nearby_restaurants;
    }
}
