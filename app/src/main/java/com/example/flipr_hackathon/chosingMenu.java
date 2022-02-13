package com.example.flipr_hackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.flipr_hackathon.databinding.ActivityChossingmenuBinding;
import com.example.flipr_hackathon.loginActivities.dealerLogin;
import com.example.flipr_hackathon.loginActivities.driverLogin;
import com.example.flipr_hackathon.signupActivities.dealerSignup;
import com.example.flipr_hackathon.signupActivities.driverSignup;

public class chosingMenu extends AppCompatActivity {

    ActivityChossingmenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChossingmenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.dealerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(chosingMenu.this, dealerLogin.class));

            }
        });
        binding.driverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(chosingMenu.this, driverLogin.class));

            }
        });
    }
}