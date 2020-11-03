package com.aditya.travelapp.Api;

import com.aditya.travelapp.models.BannerModel;
import com.aditya.travelapp.models.CategoryModel;
import com.aditya.travelapp.models.DiscoverModel;
import com.aditya.travelapp.models.TrackModel;
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
    @SerializedName("banner")
    private List<BannerModel> banners;

    @SerializedName("discover")
    private List<DiscoverModel> discovers;

    @SerializedName("trackuser")
    private List<TrackModel> gettracks;

    public String getResponse() {
        return response;
    }

    public String getUserid() {
        return userid;
    }

    public List<CategoryModel> getCategories() {
        return categories;
    }

    public List<BannerModel> getBanners() {
        return banners;
    }

    public List<DiscoverModel> getDiscovers() {
        return discovers;
    }
    public List<TrackModel> getGettracks() {
        return gettracks;
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
