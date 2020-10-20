package com.aditya.travelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.aditya.travelapp.Api.ApiClient;
import com.aditya.travelapp.Api.ApiInterface;
import com.aditya.travelapp.Api.users;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class registerActivity extends AppCompatActivity {
    TextView Remail,Rusername,Rpass;
    Button btnregister;
//    ProgressDialog progressDialog;
    ImageView dialog;
    public static ApiInterface apiInterface;


//    private FirebaseAuth mAuth;  //Declare firebase
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        ActionBar actionBar=getSupportActionBar();
//        actionBar.setTitle("Register");
//        actionBar.setDisplayShowHomeEnabled(true);
//        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
//        progressDialog=new ProgressDialog(this);
//        mAuth = FirebaseAuth.getInstance(); //initialize firebase at instance
        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        init();
    }

    private void init() {
        Remail=findViewById(R.id.registeremail);
        Rusername=findViewById(R.id.registerusername);
        Rpass=findViewById(R.id.registerpass);
        btnregister=findViewById(R.id.btnregister);
        dialog=(ImageView) findViewById(R.id.loader);
        Glide.with(this).load(R.drawable.loader).into(dialog);
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();

            }
        });

    }

    private void register() {
        String email=Remail.getText().toString().trim();
        String pass=Rpass.getText().toString().trim();
        String username=Rusername.getText().toString().trim();

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Remail.setError("Invalid Email");
            Remail.setFocusable(true);
        }else if(TextUtils.isEmpty("username")){
            Rusername.setError("Username should not be empty");
        }else if(Rpass.length() <= 6){
            Rpass.setError("Password length should greater than 7");
            Rpass.setFocusable(true);
        }else {
            dialog.setVisibility(View.VISIBLE);
//                    userregister(email,pass);
//            progressDialog.setTitle("Registering user...");
//            progressDialog.setMessage("Please wait until Registration success");
//            progressDialog.setCanceledOnTouchOutside(false);
//            progressDialog.show();
            Call<users> call=apiInterface.performEmailRegistration(username,email,pass);
            call.enqueue(new Callback<users>() {
                @Override
                public void onResponse(Call<users> call, Response<users> response) {
                    if(response.body().getResponse().equals("ok")){
                        Toast.makeText(registerActivity.this, "Registration success", Toast.LENGTH_SHORT).show();
                        dialog.setVisibility(View.GONE);
//                        progressDialog.dismiss();
                    }else if(response.body().getResponse().equals("failed")){
                        Toast.makeText(registerActivity.this, "Registration failed..try again", Toast.LENGTH_SHORT).show();
                        dialog.setVisibility(View.GONE);
//                        progressDialog.dismiss();
                    }else{
                        Toast.makeText(registerActivity.this, "Account already created", Toast.LENGTH_SHORT).show();
                        dialog.setVisibility(View.GONE);
//                        progressDialog.dismiss();
                    }
                }


                @Override
                public void onFailure(Call<users> call, Throwable t) {

                }
            });
        }
    }


//    private void userregister(String email, String pass) {
//        progressDialog.show();
//        mAuth.createUserWithEmailAndPassword(email, pass)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            progressDialog.dismiss();
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            Toast.makeText(registerActivity.this, "Register Success"+user.getEmail(), Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(registerActivity.this,DashBoardActivity.class));
//                            finish();
//                        } else {
//                            progressDialog.dismiss();
//                            // If sign in fails, display a message to the user.
//                            Toast.makeText(registerActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//
//                        }
//
//                        // ...
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(registerActivity.this, ""+ e.getMessage(),
//                        Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateFade(registerActivity.this);
    }
    public void gohome(View view) {
        Intent i=new Intent(registerActivity.this,MainActivity.class);
        startActivity(i);
        Animatoo.animateFade(registerActivity.this);
        finish();

    }
}