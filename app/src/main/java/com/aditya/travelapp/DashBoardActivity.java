package com.aditya.travelapp;

import androidx.annotation.NonNull;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import android.widget.TextView;
import android.widget.Toast;

import com.aditya.travelapp.fragment.Discover;
import com.aditya.travelapp.fragment.Feeds;
import com.aditya.travelapp.fragment.Home;
import com.aditya.travelapp.fragment.Settings;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DashBoardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    FirebaseAuth firebaseAuth;
    TextView profile;
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        profile = findViewById(R.id.profile);
        firebaseAuth = FirebaseAuth.getInstance();
        drawerLayout = findViewById(R.id.drawlayout);
        navigationView = findViewById(R.id.navdraw);
        toolbar = findViewById(R.id.toolbar);
        ActionBar action = getSupportActionBar();
        // setSupportActionBar(toolbar);
        /////////////////- Actionbar set listener -///////////////////
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        ///////////////////- Actionbar set listener -///////////////////
        ////////////// drawale open /////////////////////////////////////
        navigationView.bringToFront();
        /////////////// drawale open ///////////////////////////////////

        //ActionBar action=getSupportActionBar();
        //action.setDisplayShowHomeEnabled(true);
        //action.setTitle("Travel");
        ///////////////Bottom navigation //////////////////////////////////////////
        bottomNavigationView = findViewById(R.id.bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigation);
        navigationView.setNavigationItemSelectedListener(this);
        ///////////////Bottom navigation /////////////////////////////////////////

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); // status bar visibility transparent
        ////////////// Repace bydefault framelayout with home ////////////////////
        frameLayout = findViewById(R.id.framelayout);
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new Home()).commit();
        ////////////// Repace bydefault framelayout with home ////////////////////
    }
        ////////////// Bottom navigation listner on item select //////////////////
    private BottomNavigationView.OnNavigationItemSelectedListener navigation = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.home:
                    Toast.makeText(DashBoardActivity.this, "Home selected", Toast.LENGTH_SHORT).show();
                    fragment = new Home();
                    break;
                case R.id.discover:
                    Toast.makeText(DashBoardActivity.this, "discover selected", Toast.LENGTH_SHORT).show();
                    fragment = new Discover();
                    break;
                case R.id.feeds:
                    Toast.makeText(DashBoardActivity.this, "Feeds selected", Toast.LENGTH_SHORT).show();
                    fragment = new Feeds();
                    break;
                case R.id.settings:
                    Toast.makeText(DashBoardActivity.this, "settings selected", Toast.LENGTH_SHORT).show();
                    fragment = new Settings();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, fragment).commit();
            return true;
        }
    };
    ////////////// Bottom navigation listner on item select //////////////////

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.bottom_menu,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.home:
//                Toast.makeText(this, "Home selected", Toast.LENGTH_SHORT).show();
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }


//    public  void checkuser(){
//        FirebaseUser user=firebaseAuth.getCurrentUser();
//        if(user!=null){
//            profile.setText(user.getEmail());
//        }else{
//            startActivity(new Intent(DashBoardActivity.this,MainActivity.class));
//            finish();
//        }
//    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
    //////////////  navigation drawer on item select //////////////////
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                Toast.makeText(DashBoardActivity.this, "Home selected", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(DashBoardActivity.this,LoginActivity.class));
                break;
            case R.id.discover:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    //////////////  navigation drawer on item select //////////////////
}