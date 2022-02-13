package com.example.flipr_hackathon.loginActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.view.View;

import com.example.flipr_hackathon.R;
import com.example.flipr_hackathon.databinding.ActivityDealerLoginBinding;
import com.example.flipr_hackathon.signupActivities.dealerSignup;
import com.example.flipr_hackathon.signupActivities.dealerSignupActivityP1;

public class dealerLogin extends AppCompatActivity {
    ActivityDealerLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDealerLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.driverLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dealerLogin.this,driverLogin.class));
                finish();
            }
        });
        binding.dealerSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dealerLogin.this, dealerSignupActivityP1.class));
                finish();
            }
        });
    }
}