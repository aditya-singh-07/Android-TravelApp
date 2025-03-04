package com.aditya.travelapp.Api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("users/email_register.php")
    Call<users> performEmailRegistration(
        @Query("user_name") String user_name,
        @Query("user_email") String user_email,
        @Query("user_password") String user_pass


    );
    @GET("users/email_login.php")
    Call<users> performEmailLogin(
            @Query("user_email") String user_email,
            @Query("user_password") String user_pass

    );
    @GET("ajax/api/track_user.php")
    Call<users> trackuser(
            @Query("user_id") String user_id
    );
    @GET("ajax/api/update_user.php")
    Call<users> updateuser(
            @Query("user_id") String user_id,
            @Query("user_name") String user_name,
            @Query("user_email") String user_email

    );


    @Headers("Cache-Control: public, max-age=640000, s-maxage=640000 , max-stale=2419200")
    @GET("ajax/api/category.php")
    Call<users> getCategorylist();
    @Headers("Cache-Control: public, max-age=640000, s-maxage=640000 , max-stale=2419200")
    @GET("ajax/api/banner.php")
    Call<users> getBanners();

    @Headers("Cache-Control: public, max-age=640000, s-maxage=640000 , max-stale=2419200")
    @GET("ajax/api/discover.php")
    Call<users> getDiscovers();

    @GET("ajax/api/track_user.php")
    Call<users> getGettrack();

    @Headers("Cache-Control: public, max-age=640000, s-maxage=640000 , max-stale=2419200")
    @GET("ajax/api/trends.php")
    Call<users> getTrends() ;

    @Headers("Cache-Control: public, max-age=640000, s-maxage=640000 , max-stale=2419200")
    @GET("ajax/api/mostvisit.php")
    Call<users> getMostvisit();

    @Headers("Cache-Control: public, max-age=640000, s-maxage=640000 , max-stale=2419200")
    @GET("ajax/api/newarrival.php")
    Call<users> getNewarrival();





}
