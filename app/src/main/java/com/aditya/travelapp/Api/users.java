package com.aditya.travelapp.Api;

import com.aditya.travelapp.models.CategoryModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class users {
    @SerializedName("username")
    private String username;

    @SerializedName("response")
    private String response;
    @SerializedName("userid")
    private String userid;
    @SerializedName("category")
    private List<CategoryModel> categories;

    public String getResponse() {
        return response;
    }

    public String getUserid() {
        return userid;
    }

    public List<CategoryModel> getCategories() {
        return categories;
    }

    public String getUsername() {
        return username;
    }
    //    @SerializedName("username")
//    private String username;
//
//    public String getResponse() {
//        return response;
//    }
//
//    public String getUserid() {
//        return userid;
//    }
//
//    public String getUsername() {
//        return username;
//    }
}
