package com.example.flipr_hackathon.loginActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.flipr_hackathon.R;
import com.example.flipr_hackathon.databinding.ActivityDriverLoginBinding;
import com.example.flipr_hackathon.signupActivities.driverSignup;
import com.example.flipr_hackathon.signupActivities.driverSignupActivityP1;

public class driverLogin extends AppCompatActivity {
    ActivityDriverLoginBinding binding;
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


    }
}