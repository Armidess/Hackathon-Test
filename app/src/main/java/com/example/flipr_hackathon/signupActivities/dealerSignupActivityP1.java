package com.example.flipr_hackathon.signupActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.flipr_hackathon.R;
import com.example.flipr_hackathon.databinding.ActivityDealerSignupP1Binding;
import com.example.flipr_hackathon.loginActivities.dealerLogin;
import com.example.flipr_hackathon.userModel.dealerModel;

public class dealerSignupActivityP1 extends AppCompatActivity {
    ActivityDealerSignupP1Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDealerSignupP1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.dealerloginp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dealerSignupActivityP1.this, dealerLogin.class));
                finish();
            }
        });
        binding.driversignupp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dealerSignupActivityP1.this,driverSignupActivityP1.class));
                finish();
            }
        });
        binding.dealersignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.dealerUsername.getText().toString().length()>0
                        && binding.dealerPassword.getText().toString().length()>=8){
                    Intent intent = new Intent(dealerSignupActivityP1.this, dealerSignup.class);
                    intent.putExtra("Username", binding.dealerUsername.getText().toString());
                    intent.putExtra("Password", binding.dealerPassword.getText().toString());
                    startActivity(intent);
                    finish();
                }
                else{
                    binding.dealerPassword.setText("");
                    Toast.makeText(dealerSignupActivityP1.this, "Minimum Password Length Is 8", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}