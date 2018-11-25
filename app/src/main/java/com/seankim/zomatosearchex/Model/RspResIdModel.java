package com.seankim.zomatosearchex.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RspResIdModel {
    @SerializedName("res_id")
    @Expose
    Integer res_id;

    public Integer getRes_id() {
        return res_id;
    }

    public void setRes_id(Integer res_id) {
        this.res_id = res_id;
    }
}
