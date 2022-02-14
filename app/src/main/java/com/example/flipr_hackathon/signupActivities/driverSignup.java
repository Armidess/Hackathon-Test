package com.example.flipr_hackathon.signupActivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;

import com.example.flipr_hackathon.R;
import com.example.flipr_hackathon.databinding.ActivityDealerSignupBinding;
import com.example.flipr_hackathon.databinding.ActivityDriverSignupBinding;
import com.example.flipr_hackathon.loginActivities.driverLogin;
import com.example.flipr_hackathon.mainAcitvity.driverMainActivity;
import com.example.flipr_hackathon.userModel.driverModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class driverSignup extends AppCompatActivity {
    ActivityDriverSignupBinding binding;
    FirebaseAuth auth;
    FirebaseDatabase database;
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
        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=binding.d1.getText().toString();
                String s2=binding.d2.getText().toString();
                String s3=binding.d3.getText().toString();
                String s4=binding.d4.getText().toString();
                String s5=binding.d5.getText().toString();
                String s6=binding.d6.getText().toString();
                String s7=binding.d7.getText().toString();
                Pair<String,String> p1=new Pair<String,String>(binding.s1.getText().toString(),binding.c1.getText().toString());
                Pair<String,String> p2=new Pair<String,String>(binding.s2.getText().toString(),binding.c2.getText().toString());
                Pair<String,String> p3=new Pair<String,String>(binding.s3.getText().toString(),binding.c3.getText().toString());

                if(s1.length()>0 &&s2.length()>0 &&s3.length()>0 &&s4.length()>0 &&s5.length()>0 &&s6.length()>0 &&s7.length()>0 && p1.first.length()>0&&
                        p1.second.length()>0&&p2.first.length()>0&&p2.second.length()>0&&p3.first.length()>0&&p3.second.length()>0){
                    String a=null,b=null;
                    a=getIntent().getStringExtra("Username");
                    b=getIntent().getStringExtra("Password");
                    driverModel user = new driverModel(a,b,1);
                    user.setName(s1);
                    user.setAge(s2);
                    user.setTruckno(s3);
                    user.setMobileno(s4);
                    user.setTruckcapacity(s5);
                    user.setTransportername(s6);
                    user.setDrivingexp(s7);
                    user.setP1(p1);
                    user.setP2(p2);
                    user.setP3(p3);
                    auth.createUserWithEmailAndPassword(a,b).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                database.getReference().child("Driver").child(auth.getUid()).setValue(user);
                                database.getReference().child("Driver").child(auth.getUid()).child("uid").setValue(auth.getUid());
                                database.getReference().child("Driver").child(auth.getUid()).child("type").setValue(1);
                                startActivity(new Intent(driverSignup.this, driverMainActivity.class));
                                finish();
                            }
                            else{
                                Toast.makeText(driverSignup.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(driverSignup.this, "Enter Proper Details", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
}