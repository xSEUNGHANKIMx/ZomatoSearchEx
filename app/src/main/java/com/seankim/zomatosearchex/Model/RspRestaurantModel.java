package com.seankim.zomatosearchex.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RspRestaurantModel {
    @SerializedName("restaurant")
    @Expose
    RspRestaurantBeanModel RspRestaurantBeanModel;

    public RspRestaurantBeanModel getRspRestaurantBeanModel() {
        return RspRestaurantBeanModel;
    }

    public void setRspRestaurantBeanModel(RspRestaurantBeanModel rspRestaurantBeanModel) {
        RspRestaurantBeanModel = rspRestaurantBeanModel;
    }
}
