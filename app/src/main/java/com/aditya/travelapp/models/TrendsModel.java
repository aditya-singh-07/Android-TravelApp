package com.aditya.travelapp.models;

public class TrendsModel {
    private String  place_name,place_image;
    public TrendsModel() {
    }

    public TrendsModel(String place_name, String place_image) {
        this.place_name = place_name;
        this.place_image = place_image;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getPlace_image() {
        return place_image;
    }

    public void setPlace_image(String place_image) {
        this.place_image = place_image;
    }
}
