package com.example.flipr_hackathon.loginActivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.flipr_hackathon.R;
import com.example.flipr_hackathon.databinding.ActivityDriverLoginBinding;
import com.example.flipr_hackathon.mainAcitvity.dealerMainActivity;
import com.example.flipr_hackathon.mainAcitvity.driverMainActivity;
import com.example.flipr_hackathon.signupActivities.driverSignup;
import com.example.flipr_hackathon.signupActivities.driverSignupActivityP1;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class driverLogin extends AppCompatActivity {
    ActivityDriverLoginBinding binding;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDriverLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.dealerLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(driverLogin.this,dealerLogin.class));
                finish();
            }
        });
        binding.driverSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(driverLogin.this, driverSignupActivityP1.class));
                finish();
            }
        });

        auth = FirebaseAuth.getInstance();
        binding.LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=binding.username.getText().toString();
                String s2=binding.password.getText().toString();
                if(s1.length()>0 && s2.length()>7){
                    auth.signInWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Intent intent = new Intent(driverLogin.this, driverMainActivity.class);
                                startActivity(intent);
                                Toast.makeText(driverLogin.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                finish();
                            }else{
                                Toast.makeText(driverLogin.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }
                else{
                    Toast.makeText(driverLogin.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}