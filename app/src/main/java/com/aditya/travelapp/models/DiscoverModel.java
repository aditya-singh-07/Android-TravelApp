package com.aditya.travelapp.models;

public class DiscoverModel {
    private int place_id;
    private String place_name,place_image,offer,price,rating,location,available,cat_title;
    public DiscoverModel() {
    }

    public DiscoverModel(int place_id, String place_name, String place_image, String offer, String price, String rating, String location, String available, String cat_title) {
        this.place_id = place_id;
        this.place_name = place_name;
        this.place_image = place_image;
        this.offer = offer;
        this.price = price;
        this.rating = rating;
        this.location = location;
        this.available = available;
        this.cat_title = cat_title;
    }

    public int getPlace_id() {
        return place_id;
    }

    public void setPlace_id(int place_id) {
        this.place_id = place_id;
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

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getCat_title() {
        return cat_title;
    }

    public void setCat_title(String cat_title) {
        this.cat_title = cat_title;
    }
}
