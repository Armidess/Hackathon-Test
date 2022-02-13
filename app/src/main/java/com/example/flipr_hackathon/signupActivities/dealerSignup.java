package com.example.flipr_hackathon.signupActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.flipr_hackathon.R;
import com.example.flipr_hackathon.databinding.ActivityDealerSignupBinding;
import com.example.flipr_hackathon.loginActivities.dealerLogin;

public class dealerSignup extends AppCompatActivity {

    ActivityDealerSignupBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDealerSignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.dealerLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dealerSignup.this, dealerLogin.class));
                finish();
            }
        });
        binding.driverSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dealerSignup.this, driverSignup.class));
                finish();
            }
        });
    }
}