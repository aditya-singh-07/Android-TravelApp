package com.aditya.travelapp.models;

public class NewarrivalModel {
    private int placeimage;
    private String placename;

    public NewarrivalModel() {
    }

    public NewarrivalModel(int placeimage, String placename) {
        this.placeimage = placeimage;
        this.placename = placename;
    }

    public int getPlaceimage() {
        return placeimage;
    }

    public void setPlaceimage(int placeimage) {
        this.placeimage = placeimage;
    }

    public String getPlacename() {
        return placename;
    }

    public void setPlacename(String placename) {
        this.placename = placename;
    }
}
