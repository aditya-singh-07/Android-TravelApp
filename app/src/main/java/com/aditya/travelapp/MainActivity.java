package com.aditya.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;

import com.aditya.travelapp.adapter.TravelAdapter;
import com.aditya.travelapp.models.TravelModel;
import com.aditya.travelapp.session.SessionManage;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnlogin,btnregister;
    private List<TravelModel> travellist;
    private TravelAdapter traveladapter;
    private RecyclerView recyclerview;
    SessionManage sessionManage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlogin=findViewById(R.id.Login);
        btnregister=findViewById(R.id.register);

        recyclerview=findViewById(R.id.recycler);

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
            Animatoo.animateSlideLeft(this);
        }else{

        }

    }
}