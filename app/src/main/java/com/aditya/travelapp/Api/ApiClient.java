package com.aditya.travelapp.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URl ="http://travelastojoy.000webhostapp.com/TravelAs/users/";
    public static Retrofit retrofit=null;
     public static Retrofit getApiClient(){
        if(retrofit == null){
            retrofit=new Retrofit.Builder().baseUrl(BASE_URl).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;

     }
}
