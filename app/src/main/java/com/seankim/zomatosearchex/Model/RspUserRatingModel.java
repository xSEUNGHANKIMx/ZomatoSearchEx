package com.seankim.zomatosearchex.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RspUserRatingModel {

    @SerializedName("aggregate_rating")
    @Expose
    Double aggregate_rating;

    @SerializedName("rating_text")
    @Expose
    String rating_text;

    @SerializedName("rating_color")
    @Expose
    String rating_color;

    @SerializedName("votes")
    @Expose
    Double votes;

    public Double getAggregate_rating() {
        return aggregate_rating;
    }

    public void setAggregate_rating(Double aggregate_rating) {
        this.aggregate_rating = aggregate_rating;
    }

    public String getRating_text() {
        return rating_text;
    }

    public void setRating_text(String rating_text) {
        this.rating_text = rating_text;
    }

    public String getRating_color() {
        return rating_color;
    }

    public void setRating_color(String rating_color) {
        this.rating_color = rating_color;
    }

    public Double getVotes() {
        return votes;
    }

    public void setVotes(Double votes) {
        this.votes = votes;
    }
}
