package com.seankim.zomatosearchex.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RspUserModel {

    @SerializedName("name")
    @Expose
    String name;

    @SerializedName("zomato_handle")
    @Expose
    String zomato_handle;

    @SerializedName("foodie_level")
    @Expose
    String foodie_level;

    @SerializedName("foodie_level_num")
    @Expose
    Integer foodie_level_num;

    @SerializedName("foodie_color")
    @Expose
    String foodie_color;

    @SerializedName("profile_url")
    @Expose
    String profile_url;

    @SerializedName("profile_deeplink")
    @Expose
    String profile_deeplink;

    @SerializedName("profile_image")
    @Expose
    String profile_image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZomato_handle() {
        return zomato_handle;
    }

    public void setZomato_handle(String zomato_handle) {
        this.zomato_handle = zomato_handle;
    }

    public String getFoodie_level() {
        return foodie_level;
    }

    public void setFoodie_level(String foodie_level) {
        this.foodie_level = foodie_level;
    }

    public Integer getFoodie_level_num() {
        return foodie_level_num;
    }

    public void setFoodie_level_num(Integer foodie_level_num) {
        this.foodie_level_num = foodie_level_num;
    }

    public String getFoodie_color() {
        return foodie_color;
    }

    public void setFoodie_color(String foodie_color) {
        this.foodie_color = foodie_color;
    }

    public String getProfile_url() {
        return profile_url;
    }

    public void setProfile_url(String profile_url) {
        this.profile_url = profile_url;
    }

    public String getProfile_deeplink() {
        return profile_deeplink;
    }

    public void setProfile_deeplink(String profile_deeplink) {
        this.profile_deeplink = profile_deeplink;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }
}
