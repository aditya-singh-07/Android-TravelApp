package com.aditya.travelapp.Api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URl_000webhost ="https://travelastojoy.000webhostapp.com/TravelAs/";
    public static final String BASE_URl_localhost ="http://localhost:8080/TravelAs/";
//    public static final String BASE_URl_infinitywebhost ="http://travelas.infinityfreeapp.com/TravelAs/users/";
    public static Retrofit retrofit=null;
     public static Retrofit getApiClient(){
        OkHttpClient.Builder okhttp= new OkHttpClient.Builder();
        okhttp.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
            Request request= chain.request();
            Request.Builder newrequest=request.newBuilder().header("auth","secret key");
           return chain.proceed( newrequest.build());
            }
        });
        if(retrofit == null){
            retrofit=new Retrofit.Builder().baseUrl(BASE_URl_000webhost).client(okhttp.build()).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;

     }
     
}
