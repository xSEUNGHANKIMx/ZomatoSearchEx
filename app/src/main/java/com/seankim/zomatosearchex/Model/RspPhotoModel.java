package com.seankim.zomatosearchex.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RspPhotoModel {

    @SerializedName("id")
    @Expose
    String id;

    @SerializedName("url")
    @Expose
    String url;

    @SerializedName("thumb_url")
    @Expose
    String thumb_url;

    @SerializedName("user")
    @Expose
    RspUserModel user;

    @SerializedName("res_id")
    @Expose
    Integer res_id;

    @SerializedName("caption")
    @Expose
    String caption;

    @SerializedName("timestamp")
    @Expose
    Integer timestamp;

    @SerializedName("friendly_time")
    @Expose
    String friendly_time;

    @SerializedName("width")
    @Expose
    Integer width;

    @SerializedName("height")
    @Expose
    Integer height;

    @SerializedName("comments_count")
    @Expose
    Integer comments_count;

    @SerializedName("likes_count")
    @Expose
    Integer likes_count;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumb_url() {
        return thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }

    public RspUserModel getUser() {
        return user;
    }

    public void setUser(RspUserModel user) {
        this.user = user;
    }

    public Integer getRes_id() {
        return res_id;
    }

    public void setRes_id(Integer res_id) {
        this.res_id = res_id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public String getFriendly_time() {
        return friendly_time;
    }

    public void setFriendly_time(String friendly_time) {
        this.friendly_time = friendly_time;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getComments_count() {
        return comments_count;
    }

    public void setComments_count(Integer comments_count) {
        this.comments_count = comments_count;
    }

    public Integer getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(Integer likes_count) {
        this.likes_count = likes_count;
    }
}
