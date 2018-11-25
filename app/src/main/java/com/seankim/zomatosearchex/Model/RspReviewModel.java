package com.seankim.zomatosearchex.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RspReviewModel {

    @SerializedName("rating")
    @Expose
    Double rating;

    @SerializedName("review_text")
    @Expose
    String review_text;

    @SerializedName("id")
    @Expose
    Integer id;

    @SerializedName("rating_color")
    @Expose
    String rating_color;

    @SerializedName("review_time_friendly")
    @Expose
    String review_time_friendly;

    @SerializedName("rating_text")
    @Expose
    String rating_text;

    @SerializedName("timestamp")
    @Expose
    Double timestamp;

    @SerializedName("likes")
    @Expose
    Integer likes;

    @SerializedName("user")
    @Expose
    RspUserModel user;

    @SerializedName("comments_count")
    @Expose
    Integer comments_count;

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getReview_text() {
        return review_text;
    }

    public void setReview_text(String review_text) {
        this.review_text = review_text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRating_color() {
        return rating_color;
    }

    public void setRating_color(String rating_color) {
        this.rating_color = rating_color;
    }

    public String getReview_time_friendly() {
        return review_time_friendly;
    }

    public void setReview_time_friendly(String review_time_friendly) {
        this.review_time_friendly = review_time_friendly;
    }

    public String getRating_text() {
        return rating_text;
    }

    public void setRating_text(String rating_text) {
        this.rating_text = rating_text;
    }

    public Double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public RspUserModel getUser() {
        return user;
    }

    public void setUser(RspUserModel user) {
        this.user = user;
    }

    public Integer getComments_count() {
        return comments_count;
    }

    public void setComments_count(Integer comments_count) {
        this.comments_count = comments_count;
    }
}
