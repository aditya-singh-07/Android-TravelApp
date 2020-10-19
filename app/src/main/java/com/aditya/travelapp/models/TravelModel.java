package com.aditya.travelapp.models;

public class TravelModel {
    private int travel_image;

    public TravelModel() {
    }

    public TravelModel(int travel_image) {
        this.travel_image = travel_image;
    }

    public int getTravel_image() {
        return travel_image;
    }

    public void setTravel_image(int travel_image) {
        this.travel_image = travel_image;
    }
}
