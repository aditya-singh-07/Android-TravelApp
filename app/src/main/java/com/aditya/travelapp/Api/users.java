package com.aditya.travelapp.Api;

import com.aditya.travelapp.models.BannerModel;
import com.aditya.travelapp.models.CategoryModel;
import com.aditya.travelapp.models.DiscoverModel;
import com.aditya.travelapp.models.MostvisitModel;
import com.aditya.travelapp.models.NewarrivalModel;
import com.aditya.travelapp.models.TrackModel;
import com.aditya.travelapp.models.TrendsModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class users {
    @SerializedName("username")
    private String username;
    @SerializedName("email")
    private String email;
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

    @SerializedName("updateuser_id")
    private String updateuserid;

    @SerializedName("updateusername")
    private String updateusername;

    @SerializedName("updateemail")
    private String updateemail;

    @SerializedName("trends")
    private List<TrendsModel> trends;

    @SerializedName("mostvisit")
    private List<MostvisitModel> mostvisit;

    @SerializedName("newarrival")
    private List<NewarrivalModel> newarrival;

    public List<NewarrivalModel> getNewarrival() {
        return newarrival;
    }

    public List<MostvisitModel> getMostvisit() {
        return mostvisit;
    }

    public List<TrendsModel> getTrends() {
        return trends;
    }

    public String getUserid() {
        return userid;
    }

    public String getUpdateuserid() {
        return updateuserid;
    }


    public String getUpdateusername() {
        return updateusername;
    }

    public String getUpdateemail() {
        return updateemail;
    }

    public String getResponse() {
        return response;
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

    public String getEmail() {
        return email;
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
