package com.example.flipr_hackathon.mainAcitvity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.flipr_hackathon.Adapter.driverAdapter;
import com.example.flipr_hackathon.R;
import com.example.flipr_hackathon.chosingMenu;
import com.example.flipr_hackathon.databinding.ActivityDriverMainBinding;
import com.example.flipr_hackathon.userModel.dealerModel;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class driverMainActivity extends AppCompatActivity {
    ActivityDriverMainBinding binding;
    ArrayList<dealerModel> dealerlist;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDriverMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(driverMainActivity.this);
        driverAdapter adapter  =new driverAdapter(dealerlist,driverMainActivity.this);
        binding.driverRecyclerView.setLayoutManager(linearLayoutManager);
        binding.driverRecyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.setting:
                Toast.makeText(this, "Setting Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                auth.signOut();
                startActivity(new Intent(driverMainActivity.this,chosingMenu.class));
                finish();
                break;
        }
        return true;
    }
}