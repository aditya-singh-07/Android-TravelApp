package com.aditya.travelapp.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import com.aditya.travelapp.Api.ApiClient;
import com.aditya.travelapp.Api.ApiInterface;
import com.aditya.travelapp.Api.users;
import com.aditya.travelapp.DashBoardActivity;
import com.aditya.travelapp.MainActivity;
import com.aditya.travelapp.R;
import com.aditya.travelapp.Tracklogin;
import com.aditya.travelapp.models.TrackModel;
import com.aditya.travelapp.models.TravelModel;
import com.aditya.travelapp.session.SessionManage;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Settings extends Fragment {
    TextView email,track;
    SessionManage sessionManage;
    public Settings() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sessionManage=new SessionManage(getContext());


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_settings, container, false);
        email=view.findViewById(R.id.setting_email);
        track=view.findViewById(R.id.tracklogin);
        String user=sessionManage.isuser();

        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(), Tracklogin.class);
                startActivity(i);
            }
        });

//        email.setText(user);
        return view;
    }




}