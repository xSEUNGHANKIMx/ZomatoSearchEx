package com.seankim.zomatosearchex.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RspRestaurantBeanModel {

    @SerializedName("R")
    @Expose
    lateinit var r: RspResIdModel

    @SerializedName("apikey")
    @Expose
    lateinit var apikey: String

    @SerializedName("id")
    @Expose
    lateinit var id: String

    @SerializedName("name")
    @Expose
    lateinit var name: String

    @SerializedName("url")
    @Expose
    lateinit var url: String

    @SerializedName("location")
    @Expose
    lateinit var location: RspResLocationModel

    @SerializedName("switch_to_order_menu")
    @Expose
    var switch_to_order_menu: Int? = null

    @SerializedName("cuisines")
    @Expose
    lateinit var cuisines: String

    @SerializedName("average_cost_for_two")
    @Expose
    var average_cost_for_two: Int? = null

    @SerializedName("price_range")
    @Expose
    var price_range: Int? = null

    @SerializedName("currency")
    @Expose
    lateinit var currency: String

    @SerializedName("opentable_support")
    @Expose
    var opentable_support: Int? = null

    @SerializedName("is_zomato_book_res")
    @Expose
    var is_zomato_book_res: Int? = null

    @SerializedName("mezzo_provider")
    @Expose
    lateinit var mezzo_provider: String

    @SerializedName("is_book_form_web_view")
    @Expose
    var is_book_form_web_view: Int? = null

    @SerializedName("book_form_web_view_url")
    @Expose
    lateinit var book_form_web_view_url: String

    @SerializedName("book_again_url")
    @Expose
    lateinit var book_again_url: String

    @SerializedName("thumb")
    @Expose
    lateinit var thumb: String

    @SerializedName("user_rating")
    @Expose
    lateinit var user_rating: RspUserRatingModel

    @SerializedName("photos_url")
    @Expose
    lateinit var photos_url: String

    @SerializedName("menu_url")
    @Expose
    lateinit var menu_url: String

    @SerializedName("featured_image")
    @Expose
    lateinit var featured_image: String

    @SerializedName("has_online_delivery")
    @Expose
    var has_online_delivery: Int? = null

    @SerializedName("is_delivering_now")
    @Expose
    var is_delivering_now: Int? = null

    @SerializedName("include_bogo_offers")
    @Expose
    var include_bogo_offers: Boolean? = null

    @SerializedName("deeplink")
    @Expose
    lateinit var deeplink: String

    @SerializedName("is_table_reservation_supported")
    @Expose
    var is_table_reservation_supported: Int? = null

    @SerializedName("has_table_booking")
    @Expose
    var has_table_booking: Int? = null

    @SerializedName("events_url")
    @Expose
    lateinit var events_url: String

    @SerializedName("photos")
    @Expose
    lateinit var photos: Array<RspPhotoModel>
}
