package com.aditya.travelapp.models;

public class CategoryModel {
    private String cat_image;
    private String cat_title;
    public CategoryModel(){
    }

    public CategoryModel(String cat_image, String cat_title) {
        this.cat_image = cat_image;
        this.cat_title = cat_title;
    }

    public String getCat_image() {
        return cat_image;
    }

    public void setCat_image(String cat_image) {
        this.cat_image = cat_image;
    }

    public String getCat_title() {
        return cat_title;
    }

    public void setCat_title(String cat_title) {
        this.cat_title = cat_title;
    }
    //    private int category_img;
//    private String title;
//
//    public CategoryModel() {
//    }
//
//    public CategoryModel(int category_img, String title) {
//        this.category_img = category_img;
//        this.title = title;
//    }
//
//    public int getCategory_img() {
//        return category_img;
//    }
//
//    public void setCategory_img(int category_img) {
//        this.category_img = category_img;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
}
