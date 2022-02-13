package com.example.flipr_hackathon.signupActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.flipr_hackathon.R;
import com.example.flipr_hackathon.databinding.ActivityDriverSignupP1Binding;
import com.example.flipr_hackathon.loginActivities.driverLogin;

public class driverSignupActivityP1 extends AppCompatActivity {
    ActivityDriverSignupP1Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDriverSignupP1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.driverloginp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(driverSignupActivityP1.this, driverLogin.class));
                finish();
            }
        });
        binding.dealersignupp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(driverSignupActivityP1.this,dealerSignupActivityP1.class));
                finish();
            }
        });
        binding.driversignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.driverPassword.getText().toString().length()>8 && binding.driverUserName.getText().toString().length()>0 ) {
                    Intent intent = new Intent(driverSignupActivityP1.this, driverSignup.class);
                    intent.putExtra("UserName", binding.driverUserName.getText().toString());
                    intent.putExtra("Password", binding.driverPassword.getText().toString());
                    startActivity(intent);
                    finish();
                }
                else{
                    binding.driverPassword.setText("");
                    Toast.makeText(driverSignupActivityP1.this, "Minimum Password Length Is 8", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}