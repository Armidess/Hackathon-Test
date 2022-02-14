package com.example.flipr_hackathon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.example.flipr_hackathon.databinding.ActivityChossingmenuBinding;
import com.example.flipr_hackathon.loginActivities.dealerLogin;
import com.example.flipr_hackathon.loginActivities.driverLogin;
import com.example.flipr_hackathon.signupActivities.dealerSignup;
import com.example.flipr_hackathon.signupActivities.driverSignup;
import com.example.flipr_hackathon.userModel.driverModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;
import java.util.Set;

public class chosingMenu extends AppCompatActivity {

    ActivityChossingmenuBinding binding;
    FirebaseDatabase database;

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
        database = FirebaseDatabase.getInstance();
        database.getReference().child("Driver").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot data : snapshot.getChildren()){
                    Map<String, Object> map  = (Map) data.getValue();
                    Map p1  = (Map) map.get("p1");

                    //Pair p2 = (Pair)p1;
                    //System.out.println(p1.get("first"));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}