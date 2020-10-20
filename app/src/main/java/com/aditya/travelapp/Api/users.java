package com.aditya.travelapp.Api;

import com.google.gson.annotations.SerializedName;

public class users {
    @SerializedName("response")
    private String response;
    @SerializedName("userid")
    private String userid;
    @SerializedName("username")
    private String username;

    public String getResponse() {
        return response;
    }

    public String getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }
}
