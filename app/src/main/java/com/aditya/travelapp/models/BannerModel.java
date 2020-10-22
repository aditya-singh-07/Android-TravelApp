package com.aditya.travelapp.models;

public class BannerModel {
    private int banner_image;

    public BannerModel() {
    }

    public BannerModel(int banner_image) {
        this.banner_image = banner_image;
    }

    public int getBanner_image() {
        return banner_image;
    }

    public void setBanner_image(int banner_image) {
        this.banner_image = banner_image;
    }
}
