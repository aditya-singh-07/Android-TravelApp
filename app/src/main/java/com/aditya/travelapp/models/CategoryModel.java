package com.aditya.travelapp.models;

public class CategoryModel {
    private int category_img;
    private String title;

    public CategoryModel() {
    }

    public CategoryModel(int category_img, String title) {
        this.category_img = category_img;
        this.title = title;
    }

    public int getCategory_img() {
        return category_img;
    }

    public void setCategory_img(int category_img) {
        this.category_img = category_img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
