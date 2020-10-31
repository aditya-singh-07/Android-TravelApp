package com.aditya.travelapp;

import androidx.annotation.NonNull;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import android.widget.TextView;
import android.widget.Toast;

import com.aditya.travelapp.Api.ApiClient;
import com.aditya.travelapp.Api.ApiInterface;
import com.aditya.travelapp.fragment.Discover;
import com.aditya.travelapp.fragment.Feeds;
import com.aditya.travelapp.fragment.Home;
import com.aditya.travelapp.fragment.Settings;
import com.aditya.travelapp.session.SessionManage;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
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
    SessionManage sessionManage;
    Context context;
    Boolean exit = false;


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

        ////////////////Session management instance created////////////////
        sessionManage=new SessionManage(this);
        ////////////////Session management instance created////////////////

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


    //////////////  navigation drawer on item select //////////////////
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new Home()).commit();
//                Toast.makeText(DashBoardActivity.this, "Home selected", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(DashBoardActivity.this,DashBoardActivity.class));
                break;
            case R.id.discover:
                Toast.makeText(DashBoardActivity.this, "Discover selected", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new Discover()).commit();
                break;
            case R.id.feeds:
                Toast.makeText(DashBoardActivity.this, "Feeds selected", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new Feeds()).commit();
                break;
            case R.id.settings:
                Toast.makeText(DashBoardActivity.this, "Settings selected", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new Settings()).commit();
                break;
            case R.id.account:
                Toast.makeText(DashBoardActivity.this, "Account Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                Toast.makeText(DashBoardActivity.this, "Logout success", Toast.LENGTH_SHORT).show();
                logout();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    //////////////  navigation drawer on item select //////////////////

    ////////////// toolbar menu //////////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_search_menu, menu);
        return true;
    }
    ////////////// toolbar menu //////////////////////////////////


    private void logout() {
        sessionManage.editor.clear();
        sessionManage.editor.commit();
        Intent i=new Intent(DashBoardActivity.this,MainActivity.class);
        startActivity(i);
        finish();
        Animatoo.animateFade(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Menu menuNav = navigationView.getMenu();
        MenuItem logoutItem = menuNav.findItem(R.id.logout);
        if(!sessionManage.islogin()){
            sessionManage.editor.clear();
            sessionManage.editor.commit();
            logoutItem.setVisible(false);
            Animatoo.animateSwipeRight(this);
        }else{
            logoutItem.setVisible(true);
        }

    }
    
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
//        else if(!sessionManage.islogin()){
//            Intent i=new Intent(DashBoardActivity.this,MainActivity.class);
//            startActivity(i);
//            Animatoo.animateSwipeRight(this);
//        }
        else{

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
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }
}