package com.aditya.travelapp.models;

public class DiscoverModel {
    private int place_image;
    private String place_name,location,available,offer,rating,price,category;

    public DiscoverModel() {
    }

    public DiscoverModel(int place_image, String place_name, String location, String available, String offer, String rating, String price, String category) {
        this.place_image = place_image;
        this.place_name = place_name;
        this.location = location;
        this.available = available;
        this.offer = offer;
        this.rating = rating;
        this.price = price;
        this.category = category;
    }

    public int getPlace_image() {
        return place_image;
    }

    public void setPlace_image(int place_image) {
        this.place_image = place_image;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
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

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
