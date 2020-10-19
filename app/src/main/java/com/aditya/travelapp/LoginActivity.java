package com.aditya.travelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    TextView Lemail,Lpass;
    Button btnlogin;
    ProgressDialog progressDialog;
    private FirebaseAuth mAuth;  //Declare firebase
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
        Lemail=findViewById(R.id.loginemail);
        Lpass=findViewById(R.id.loginpass);
        btnlogin=findViewById(R.id.btnlogin);
        progressDialog=new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance(); //initialize firebase at instance

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                    progressDialog.setTitle("Logging process");
                    progressDialog.setMessage("Please wait until authentication success");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();
                    Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();
                }
            }
        });



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