package com.seankim.zomatosearchex.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RspResLocationModel {

    @SerializedName("address")
    @Expose
    String address;

    @SerializedName("locality")
    @Expose
    String locality;

    @SerializedName("city")
    @Expose
    String city;

    @SerializedName("city_id")
    @Expose
    Integer city_id;

    @SerializedName("latitude")
    @Expose
    Double latitude;

    @SerializedName("longitude")
    @Expose
    Double longitude;

    @SerializedName("zipcode")
    @Expose
    String zipcode;

    @SerializedName("country_id")
    @Expose
    Integer country_id;

    @SerializedName("locality_verbose")
    @Expose
    String locality_verbose;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Integer getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    public String getLocality_verbose() {
        return locality_verbose;
    }

    public void setLocality_verbose(String locality_verbose) {
        this.locality_verbose = locality_verbose;
    }
}
