package com.aditya.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Toast;

import com.aditya.travelapp.Api.ApiClient;
import com.aditya.travelapp.Api.ApiInterface;
import com.aditya.travelapp.Api.users;
import com.aditya.travelapp.adapter.CategoryAdapter;
import com.aditya.travelapp.adapter.TravelAdapter;
import com.aditya.travelapp.models.CategoryModel;
import com.aditya.travelapp.models.TravelModel;
import com.aditya.travelapp.session.SessionManage;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btnlogin,btnregister;
    private List<TravelModel> travellist;
    private TravelAdapter traveladapter;
    private RecyclerView recyclerview;
    SessionManage sessionManage;
    Boolean exit = false;
    ///////// Api interface object ////////////////
    public static ApiInterface apiInterface;
    ///////// Api interface object ////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ///////// Api interface object initialize ////////////////
        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        ///////// Api interface object initialize ////////////////

        btnlogin=findViewById(R.id.Login);
        btnregister=findViewById(R.id.register);

        recyclerview=findViewById(R.id.recycler);

        ///////////// dummy data fetch /////////////////

        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerview.setLayoutManager(manager);
        recyclerview.setKeepScreenOn(true);
        recyclerview.setHasFixedSize(true);

        travellist=new ArrayList<TravelModel>();
        travellist.add(new TravelModel(R.drawable.image1));
        travellist.add(new TravelModel(R.drawable.image2));
        travellist.add(new TravelModel(R.drawable.image3));
        travellist.add(new TravelModel(R.drawable.image4));
        traveladapter=new TravelAdapter(travellist,this);
        recyclerview.setAdapter(traveladapter);
        traveladapter.notifyDataSetChanged();

        ///////////// dummy data fetch /////////////////
//        init();
        autoScroll();

        sessionManage=new SessionManage(this);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);
                Animatoo.animateSlideLeft(MainActivity.this);
            }
        });
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,registerActivity.class);
                startActivity(i);
                Animatoo.animateSlideLeft(MainActivity.this);
            }
        });



    }

    ///////////////// Fetch data from rest api //////////////////
//    private void init() {
//
//        LinearLayoutManager manager = new LinearLayoutManager(this);
//        manager.setOrientation(RecyclerView.HORIZONTAL);
//        recyclerview.setLayoutManager(manager);
//        recyclerview.setKeepScreenOn(true);
//        recyclerview.setHasFixedSize(true);
//
//        travellist = new ArrayList<CategoryModel>();
//        Call<users> catcall = apiInterface.getCategorylist();
//        catcall.enqueue(new Callback<users>() {
//            @Override
//            public void onResponse(Call<users> call, Response<users> response) {
//                travellist = response.body().getCategories();
//                traveladapter = new TravelAdapter(travellist, getApplicationContext());
//                recyclerview.setAdapter(traveladapter);
//                traveladapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onFailure(Call<users> call, Throwable t) {
//
//            }
//        });
//
//    }

    ///////////////// Fetch data from rest api //////////////////

    public void autoScroll(){
        final int speedscroll =3000;

        final Handler mHandler = new Handler();
        final Runnable SCROLLING_RUNNABLE = new Runnable() {
            int count=0;
            @Override
            public void run() {
                if(count== traveladapter.getItemCount())
                    count=0;
                    if(count< traveladapter.getItemCount()) {
                        recyclerview.smoothScrollToPosition(++count);
                        mHandler.postDelayed(this, speedscroll);
                    }
            }
        };
        mHandler.postDelayed(SCROLLING_RUNNABLE,speedscroll);
    }

    public void godashboard(View view) {
        Intent i=new Intent(MainActivity.this,DashBoardActivity.class);
        startActivity(i);
        Animatoo.animateSlideLeft(MainActivity.this);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(sessionManage.islogin()){
            Intent i=new Intent(MainActivity.this,DashBoardActivity.class);
            startActivity(i);
            finish();
            Animatoo.animateSlideRight(this);
        }else{

        }

    }

    @Override
    public void onBackPressed() {
            if (exit) {
                moveTaskToBack(true);
                finish(); // finish activity
            } else {
                Toast.makeText(this, "Press Back again to Exit.",
                        Toast.LENGTH_SHORT).show();
                exit = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        exit = false;
                    }
                }, 3 * 1000);
            }



    }

}