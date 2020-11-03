package com.aditya.travelapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.aditya.travelapp.Api.ApiClient;
import com.aditya.travelapp.Api.ApiInterface;
import com.aditya.travelapp.Api.users;
import com.aditya.travelapp.adapter.TrackAdapter;
import com.aditya.travelapp.models.TrackModel;
import com.aditya.travelapp.session.SessionManage;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tracklogin extends AppCompatActivity {
    private List<TrackModel> tracklist;
    private TrackAdapter trackAdapter;
    public static ApiInterface apiInterface;
    private RecyclerView trackrecyclers;
    SessionManage sessionManage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracklogin);
        trackrecyclers=findViewById(R.id.trackrecycler);
        sessionManage=new SessionManage(getApplicationContext());
        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); // status bar visibility transparent
        trackuser();
    }

   void trackuser(){
       LinearLayoutManager manager=new LinearLayoutManager(getApplicationContext());
       manager.setOrientation(RecyclerView.VERTICAL);
       trackrecyclers.setLayoutManager(manager);
       trackrecyclers.setHasFixedSize(true);
       tracklist= new ArrayList<TrackModel>();
    String user=sessionManage.isuser();
        Call<users> call=apiInterface.trackuser(user);
        call.enqueue(new Callback<users>() {
            @Override
            public void onResponse(Call<users> call, Response<users> response) {
//                try{
//                    if(response.isSuccessful()) {
                        tracklist = response.body().getGettracks();
                        trackAdapter = new TrackAdapter(tracklist, getApplicationContext());
                        trackrecyclers.setAdapter(trackAdapter);
                        trackAdapter.notifyDataSetChanged();

//                    }else{
//                        Toast.makeText(Tracklogin.this, "error no response", Toast.LENGTH_SHORT).show();
//                    }
//                }catch (Exception e){
//                    Toast.makeText(Tracklogin.this, "error" + e.getMessage(), Toast.LENGTH_SHORT).show();
//                }

            }

            @Override
            public void onFailure(Call<users> call, Throwable t) {

            }
        });
    }

}