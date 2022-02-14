package com.example.flipr_hackathon.loginActivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.view.View;
import android.widget.Toast;

import com.example.flipr_hackathon.R;
import com.example.flipr_hackathon.databinding.ActivityDealerLoginBinding;
import com.example.flipr_hackathon.mainAcitvity.dealerMainActivity;
import com.example.flipr_hackathon.signupActivities.dealerSignup;
import com.example.flipr_hackathon.signupActivities.dealerSignupActivityP1;
import com.example.flipr_hackathon.userModel.dealerModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.List;
import java.util.Map;

public class dealerLogin extends AppCompatActivity {
    ActivityDealerLoginBinding binding;
    FirebaseDatabase database;
    FirebaseAuth auth;
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
        auth = FirebaseAuth.getInstance();
        database  = FirebaseDatabase.getInstance();
        binding.LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=binding.username.getText().toString();
                String s2=binding.password.getText().toString();
                final int[] flag = {0};
                if(s1.length()>0 && s2.length()>7){
                    database.getReference().child("Dealer").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for(DataSnapshot data : snapshot.getChildren()){

                                Map<String, String> map  = (Map) data.getValue();
                                if(!(map.get("username")==s1)){
                                    flag[0] =1;
                                    auth.signInWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if(task.isSuccessful()){
                                                startActivity(new Intent(dealerLogin.this, dealerMainActivity.class));
                                                Toast.makeText(dealerLogin.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                                finish();
                                            }else{
                                                Toast.makeText(dealerLogin.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                                            }

                                        }
                                    });
                                }
                            }
                            if(flag[0]!=1)
                            Toast.makeText(dealerLogin.this, "User Not Present", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                else{
                    Toast.makeText(dealerLogin.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}