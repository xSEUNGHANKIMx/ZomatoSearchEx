package com.seankim.zomatosearchex.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RspRestaurantBeanModel {

    @SerializedName("R")
    @Expose
    RspResIdModel R;

    @SerializedName("apikey")
    @Expose
    String apikey;

    @SerializedName("id")
    @Expose
    String id;

    @SerializedName("name")
    @Expose
    String name;

    @SerializedName("url")
    @Expose
    String url;

    @SerializedName("location")
    @Expose
    RspResLocationModel location;

    @SerializedName("switch_to_order_menu")
    @Expose
    Integer switch_to_order_menu;

    @SerializedName("cuisines")
    @Expose
    String cuisines;

    @SerializedName("average_cost_for_two")
    @Expose
    Integer average_cost_for_two;

    @SerializedName("price_range")
    @Expose
    Integer price_range;

    @SerializedName("currency")
    @Expose
    String currency;

    @SerializedName("opentable_support")
    @Expose
    Integer opentable_support;

    @SerializedName("is_zomato_book_res")
    @Expose
    Integer is_zomato_book_res;

    @SerializedName("mezzo_provider")
    @Expose
    String mezzo_provider;

    @SerializedName("is_book_form_web_view")
    @Expose
    Integer is_book_form_web_view;

    @SerializedName("book_form_web_view_url")
    @Expose
    String book_form_web_view_url;

    @SerializedName("book_again_url")
    @Expose
    String book_again_url;

    @SerializedName("thumb")
    @Expose
    String thumb;

    @SerializedName("user_rating")
    @Expose
    RspUserRatingModel user_rating;

    @SerializedName("photos_url")
    @Expose
    String photos_url;

    @SerializedName("menu_url")
    @Expose
    String menu_url;

    @SerializedName("featured_image")
    @Expose
    String featured_image;

    @SerializedName("has_online_delivery")
    @Expose
    Integer has_online_delivery;

    @SerializedName("is_delivering_now")
    @Expose
    Integer is_delivering_now;

    @SerializedName("include_bogo_offers")
    @Expose
    Boolean include_bogo_offers;

    @SerializedName("deeplink")
    @Expose
    String deeplink;

    @SerializedName("is_table_reservation_supported")
    @Expose
    Integer is_table_reservation_supported;

    @SerializedName("has_table_booking")
    @Expose
    Integer has_table_booking;

    @SerializedName("events_url")
    @Expose
    String events_url;

    @SerializedName("photos")
    @Expose
    RspPhotoModel[] photos;

    public RspPhotoModel[] getPhotos() {
        return photos;
    }

    public void setPhotos(RspPhotoModel[] photos) {
        this.photos = photos;
    }

    public RspResIdModel getR() {
        return R;
    }

    public void setR(RspResIdModel r) {
        R = r;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public RspResLocationModel getLocation() {
        return location;
    }

    public void setLocation(RspResLocationModel location) {
        this.location = location;
    }

    public Integer getSwitch_to_order_menu() {
        return switch_to_order_menu;
    }

    public void setSwitch_to_order_menu(Integer switch_to_order_menu) {
        this.switch_to_order_menu = switch_to_order_menu;
    }

    public String getCuisines() {
        return cuisines;
    }

    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }

    public Integer getAverage_cost_for_two() {
        return average_cost_for_two;
    }

    public void setAverage_cost_for_two(Integer average_cost_for_two) {
        this.average_cost_for_two = average_cost_for_two;
    }

    public Integer getPrice_range() {
        return price_range;
    }

    public void setPrice_range(Integer price_range) {
        this.price_range = price_range;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getOpentable_support() {
        return opentable_support;
    }

    public void setOpentable_support(Integer opentable_support) {
        this.opentable_support = opentable_support;
    }

    public Integer getIs_zomato_book_res() {
        return is_zomato_book_res;
    }

    public void setIs_zomato_book_res(Integer is_zomato_book_res) {
        this.is_zomato_book_res = is_zomato_book_res;
    }

    public String getMezzo_provider() {
        return mezzo_provider;
    }

    public void setMezzo_provider(String mezzo_provider) {
        this.mezzo_provider = mezzo_provider;
    }

    public Integer getIs_book_form_web_view() {
        return is_book_form_web_view;
    }

    public void setIs_book_form_web_view(Integer is_book_form_web_view) {
        this.is_book_form_web_view = is_book_form_web_view;
    }

    public String getBook_form_web_view_url() {
        return book_form_web_view_url;
    }

    public void setBook_form_web_view_url(String book_form_web_view_url) {
        this.book_form_web_view_url = book_form_web_view_url;
    }

    public String getBook_again_url() {
        return book_again_url;
    }

    public void setBook_again_url(String book_again_url) {
        this.book_again_url = book_again_url;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public RspUserRatingModel getUser_rating() {
        return user_rating;
    }

    public void setUser_rating(RspUserRatingModel user_rating) {
        this.user_rating = user_rating;
    }

    public String getPhotos_url() {
        return photos_url;
    }

    public void setPhotos_url(String photos_url) {
        this.photos_url = photos_url;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }

    public String getFeatured_image() {
        return featured_image;
    }

    public void setFeatured_image(String featured_image) {
        this.featured_image = featured_image;
    }

    public Integer getHas_online_delivery() {
        return has_online_delivery;
    }

    public void setHas_online_delivery(Integer has_online_delivery) {
        this.has_online_delivery = has_online_delivery;
    }

    public Integer getIs_delivering_now() {
        return is_delivering_now;
    }

    public void setIs_delivering_now(Integer is_delivering_now) {
        this.is_delivering_now = is_delivering_now;
    }

    public Boolean getInclude_bogo_offers() {
        return include_bogo_offers;
    }

    public void setInclude_bogo_offers(Boolean include_bogo_offers) {
        this.include_bogo_offers = include_bogo_offers;
    }

    public String getDeeplink() {
        return deeplink;
    }

    public void setDeeplink(String deeplink) {
        this.deeplink = deeplink;
    }

    public Integer getIs_table_reservation_supported() {
        return is_table_reservation_supported;
    }

    public void setIs_table_reservation_supported(Integer is_table_reservation_supported) {
        this.is_table_reservation_supported = is_table_reservation_supported;
    }

    public Integer getHas_table_booking() {
        return has_table_booking;
    }

    public void setHas_table_booking(Integer has_table_booking) {
        this.has_table_booking = has_table_booking;
    }

    public String getEvents_url() {
        return events_url;
    }

    public void setEvents_url(String events_url) {
        this.events_url = events_url;
    }
}
