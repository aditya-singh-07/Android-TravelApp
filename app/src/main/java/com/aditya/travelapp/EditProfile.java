package com.aditya.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aditya.travelapp.Api.ApiClient;
import com.aditya.travelapp.Api.ApiInterface;
import com.aditya.travelapp.Api.users;
import com.aditya.travelapp.fragment.Home;
import com.aditya.travelapp.fragment.MapFragment;
import com.aditya.travelapp.fragment.Settings;
import com.aditya.travelapp.session.SessionManage;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfile extends AppCompatActivity {
    TextView updateemail,updateusername,Backlogin,btnupdates;
    ImageView dialog;
    public static ApiInterface apiInterface;
    SessionManage sessionManage;
    FrameLayout frameLayouts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        sessionManage=new SessionManage(getApplicationContext());
        updateemail=findViewById(R.id.updateemail);
        updateusername=findViewById(R.id.updateusername);
        Backlogin=findViewById(R.id.Backlogin);
        btnupdates=findViewById(R.id.btnupdate);
        dialog=findViewById(R.id.loader);

        final String username=getIntent().getStringExtra("username");
        final  String email=getIntent().getStringExtra("email");
        final String userid=sessionManage.isuser();
        updateemail.setText(email);
        updateusername.setText(username);
        dialog=(ImageView) findViewById(R.id.loader);
        Glide.with(this).load(R.drawable.loader).into(dialog);
        Backlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Animatoo.animateSlideRight(EditProfile.this);

            }
        });
        btnupdates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updatemail=updateemail.getText().toString();
                String updateusr=updateusername.getText().toString();
                updateusername=findViewById(R.id.updateusername);
                btnupdates.setEnabled(false);
                hideKeybaord(v);
                dialog.setVisibility(View.VISIBLE);
                Call<users> call=apiInterface.updateuser(userid,updateusr,updatemail);
                call.enqueue(new Callback<users>() {
                    @Override
                    public void onResponse(Call<users> call, Response<users> response) {
                        if(response.body().getResponse().equals("ok")){
                            btnupdates.setEnabled(true);
                            String uid=response.body().getUpdateuserid();
                            String uname=response.body().getUpdateusername();
                            String uemail=response.body().getUpdateemail();
                            sessionManage.createsession(uid,uname,uemail);
                            Log.w("response",response.body().getUpdateusername());
                            dialog.setVisibility(View.GONE);
                            Toast.makeText(EditProfile.this, "Update success", Toast.LENGTH_SHORT).show();
                            finish();
                            Animatoo.animateSlideRight(EditProfile.this);


//                        progressDialog.dismiss();
                        }else if(response.body().getResponse().equals("Failed to update")){
                            btnupdates.setEnabled(true);
                            Toast.makeText(EditProfile.this, "Failed to update", Toast.LENGTH_SHORT).show();
                            dialog.setVisibility(View.GONE);
//                        progressDialog.dismiss();
                        }else{
                            btnupdates.setEnabled(true);
                            Toast.makeText(EditProfile.this, "Please try again..", Toast.LENGTH_SHORT).show();
                            dialog.setVisibility(View.GONE);
//                        progressDialog.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<users> call, Throwable t) {

                    }
                });

            }
        });
    }
    private void hideKeybaord(View v) {
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
    }

}