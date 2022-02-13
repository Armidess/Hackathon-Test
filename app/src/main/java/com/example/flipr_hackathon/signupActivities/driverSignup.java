package com.example.flipr_hackathon.signupActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.flipr_hackathon.R;
import com.example.flipr_hackathon.databinding.ActivityDealerSignupBinding;
import com.example.flipr_hackathon.databinding.ActivityDriverSignupBinding;
import com.example.flipr_hackathon.loginActivities.driverLogin;

public class driverSignup extends AppCompatActivity {
    ActivityDriverSignupBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding  = ActivityDriverSignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.driverLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(driverSignup.this, driverLogin.class));
                finish();
            }
        });
        binding.dealerSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(driverSignup.this, dealerSignup.class));
                finish();
            }
        });
    }
}