package com.aditya.travelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aditya.travelapp.Api.ApiClient;
import com.aditya.travelapp.Api.ApiInterface;
import com.aditya.travelapp.Api.users;
import com.aditya.travelapp.session.SessionManage;
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

import static com.aditya.travelapp.registerActivity.apiInterface;

public class LoginActivity extends AppCompatActivity {
    TextView Lemail,Lpass;
    Button btnlogin;
    ImageView dialog;
    SessionManage sessionManage;
//    ProgressDialog progressDialog;

    public static ApiInterface apiInterface;
//    private FirebaseAuth mAuth;  //Declare firebase
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        ActionBar actionBar=getSupportActionBar();
//        actionBar.setTitle("Login");
//        actionBar.setDisplayShowHomeEnabled(true);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        sessionManage=new SessionManage(this);
        init();


    }
    private void init() {
        Lemail=findViewById(R.id.loginemail);
        Lpass=findViewById(R.id.loginpass);
        btnlogin=findViewById(R.id.btnlogin);
//        progressDialog=new ProgressDialog(this);
//        mAuth = FirebaseAuth.getInstance(); //initialize firebase at instance
        dialog=(ImageView) findViewById(R.id.loader);
        Glide.with(this).load(R.drawable.loader).into(dialog);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnlogin.setEnabled(false);
                login();
            }
        });

    }
    private void login() {
        String email=Lemail.getText().toString().trim();
        String pass=Lpass.getText().toString().trim();

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Lemail.setError("Invalid Email");
            Lemail.setFocusable(true);
        }else if(Lpass.length() <= 6){
            Lpass.setError("Password length should greater than 7");
            Lpass.setFocusable(true);
        }else {
//                    userlogin(email,pass);
            /////////////// Custom loader //////////////////////
            dialog.setVisibility(View.VISIBLE);
//            progressDialog.setTitle("Logging process");
//            progressDialog.setMessage("Please wait until authentication success");
//            progressDialog.setCanceledOnTouchOutside(false);
//            progressDialog.show();
            /////////////// Custom loader //////////////////////
            Call<users> call=apiInterface.performEmailLogin(email,pass);
            call.enqueue(new Callback<users>() {
                @Override
                public void onResponse(Call<users> call, Response<users> response) {
                    if(response.body().getResponse().equals("ok")){
                        btnlogin.setEnabled(true);
                        String uid=response.body().getUserid();
                        String uname=response.body().getUsername();
                        sessionManage.createsession(uid);
                        dialog.setVisibility(View.GONE);
                        Toast.makeText(LoginActivity.this, "Registration success", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(LoginActivity.this,DashBoardActivity.class);
                        startActivity(i);
                        Animatoo.animateSlideLeft(LoginActivity.this);
                        finish();

//                        progressDialog.dismiss();
                    }else if(response.body().getResponse().equals("No Account register")){
                        Toast.makeText(LoginActivity.this, "No Account register", Toast.LENGTH_SHORT).show();
                        dialog.setVisibility(View.GONE);
//                        progressDialog.dismiss();
                    }else{
                        Toast.makeText(LoginActivity.this, "Please try again..", Toast.LENGTH_SHORT).show();
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

//    private void userlogin(String email, String pass) {
//        progressDialog.show();
//        mAuth.signInWithEmailAndPassword(email, pass)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            progressDialog.dismiss();
//                            // Sign in success, update UI with the signed-in user's information
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            startActivity(new Intent(LoginActivity.this,DashBoardActivity.class));
//                            finish();
//                        } else {
//                            progressDialog.dismiss();
//                            // If sign in fails, display a message to the user.
//                            Toast.makeText(LoginActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                        }
//
//                        // ...
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                progressDialog.dismiss();
//                Toast.makeText(LoginActivity.this, ""+e.getMessage(),
//                        Toast.LENGTH_SHORT).show();
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
        Animatoo.animateFade(LoginActivity.this);
    }

    public void gohome(View view) {
        Intent i=new Intent(LoginActivity.this,MainActivity.class);
        startActivity(i);
        Animatoo.animateFade(LoginActivity.this);
        finish();

    }
}