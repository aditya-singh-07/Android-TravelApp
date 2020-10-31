package com.aditya.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aditya.travelapp.fragment.Discover;
import com.aditya.travelapp.fragment.MapFragment;
import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Discover_details extends AppCompatActivity implements OnMapReadyCallback {
    TextView placetitle,placedetailtitle,placetitle1,placelocation,placelocation1,available,category,review,rating;
    ImageView placeimage,backbtn;
    FrameLayout frameLayout;
    private final int MY_PERMISSION= 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_details);
        frameLayout=findViewById(R.id.frame_map_layout);
      Fragment fragment=new MapFragment();

      getSupportFragmentManager().beginTransaction().replace(R.id.frame_map_layout,fragment).commit();

        backbtn=findViewById(R.id.back);
        placetitle=findViewById(R.id.placetitle);
        placetitle1=findViewById(R.id.placetitle1);
        placelocation1=findViewById(R.id.place_detail_location1);
        placelocation=findViewById(R.id.place_detail_location);
        placedetailtitle=findViewById(R.id.place_detail_title);
        placeimage=findViewById(R.id.placeimg);
        available=findViewById(R.id.place_detail_available);
        category=findViewById(R.id.category);
        review=findViewById(R.id.reviews);
        rating=findViewById(R.id.rating);

        final int id=getIntent().getIntExtra("id",0);
        final String placename=getIntent().getStringExtra("placetitle");
        final String placecat=getIntent().getStringExtra("placecategory");
        final String image=getIntent().getStringExtra("placeimage");
        final String location=getIntent().getStringExtra("placelocation");
        final String placeavailable=getIntent().getStringExtra("available");
        final String placerating=getIntent().getStringExtra("rating");

        placetitle.setText(placename);
        placetitle1.setText(placename);
        category.setText(placecat);
        Glide.with(getApplicationContext()).load(image).into(placeimage);
        placelocation.setText(location);
        placelocation1.setText(location);
        placedetailtitle.setText(placename);
        available.setText(placeavailable);
        rating.setText(placerating);
        if(placerating.equals("4.5" )){
            review.setText("Excellent");
        }else{
            review.setText("Good");
        }



        Toast.makeText(this, "placeid" + id, Toast.LENGTH_SHORT).show();
       backbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                finish();
           }
       });
       checkpermission();
    }


    public void checkpermission(){
        if(ContextCompat.checkSelfPermission(Discover_details.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(Discover_details.this,Manifest.permission.ACCESS_FINE_LOCATION)){
                new AlertDialog.Builder(Discover_details.this)
                        .setTitle("Permission request")
                        .setMessage("Your should enable this permission to Access location")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions(Discover_details.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},MY_PERMISSION);
                            }
                        })
                        .setPositiveButton("Grant Permission", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions(Discover_details.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},MY_PERMISSION);
                            }
                        })
                        .show();
            }else{
                ActivityCompat.requestPermissions(Discover_details.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},MY_PERMISSION);
            }
        }else{

        }



    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng loc = new LatLng(21, 57);
        googleMap.addMarker(new MarkerOptions().position(new LatLng(19.075983, 72.877655)).title("Marker"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(loc));
    }
}