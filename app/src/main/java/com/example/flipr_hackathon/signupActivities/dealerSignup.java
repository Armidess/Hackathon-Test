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
import com.example.flipr_hackathon.loginActivities.dealerLogin;
import com.example.flipr_hackathon.mainAcitvity.dealerMainActivity;
import com.example.flipr_hackathon.userModel.dealerModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class dealerSignup extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseDatabase database;
    ActivityDealerSignupBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDealerSignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth  = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
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
        binding.SignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.F1.getText().toString().length()>0 &&
                        binding.f2.getText().toString().length()>0 &&
                        binding.f3.getText().toString().length()>0 &&
                        binding.f4.getText().toString().length()>0 &&
                        binding.f5.getText().toString().length()>0 &&
                        binding.f6.getText().toString().length()>0 &&
                        binding.f7.getText().toString().length()>0){
                    String s1 = getIntent().getStringExtra("Username").toString();
                    String s2 = getIntent().getStringExtra("Password").toString();
                    dealerModel user = new dealerModel(s1,s2,0);
                    user.setName(binding.F1.getText().toString());
                    user.setMobileno(binding.f2.getText().toString());
                    user.setNature(binding.f3.getText().toString());
                    user.setWeight(binding.f4.getText().toString());
                    user.setQuantity(binding.f5.getText().toString());
                    user.setCity(new Pair<String,String>(binding.f6.getText().toString(),binding.f7.getText().toString()));
                                        auth.createUserWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                database.getReference().child("Dealer").child(auth.getUid()).setValue(user);
                                database.getReference().child("Dealer").child(auth.getUid()).child("uid").setValue(auth.getUid());
                                database.getReference().child("Dealer").child(auth.getUid()).child("type").setValue(0);

                                startActivity(new Intent(dealerSignup.this, dealerMainActivity.class));
                                finish();
                            }
                            else{
                                Toast.makeText(dealerSignup.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(dealerSignup.this, "Invalid Entries Try Again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }
}