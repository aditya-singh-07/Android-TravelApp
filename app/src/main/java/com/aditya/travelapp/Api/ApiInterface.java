package com.aditya.travelapp.Api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("email_register.php")
    Call<users> performEmailRegistration(
        @Query("user_name") String user_name,
        @Query("user_email") String user_email,
        @Query("user_password") String user_pass


    );
    @GET("email_login.php")
    Call<users> performEmailLogin(
            @Query("user_email") String user_email,
            @Query("user_password") String user_pass

    );

}
