package com.example.flipr_hackathon.mainAcitvity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.flipr_hackathon.Adapter.dealerAdapter;
import com.example.flipr_hackathon.R;
import com.example.flipr_hackathon.chosingMenu;
import com.example.flipr_hackathon.databinding.ActivityDealerMainBinding;
import com.example.flipr_hackathon.userModel.dealerModel;
import com.example.flipr_hackathon.userModel.driverModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class dealerMainActivity extends AppCompatActivity {
    ActivityDealerMainBinding binding;
    FirebaseDatabase database;
    FirebaseAuth auth;
    public static String currntuid = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDealerMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();


        ArrayList<driverModel> driverlist = new ArrayList<>();
        final Pair<String, String>[] pair = new Pair[]{null};
        database.getReference().child("Dealer").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot data : snapshot.getChildren()){
                    Map<String, Object> map  = (Map) data.getValue();
                    String Pp1  = (String) map.get("uid");
                    currntuid =Pp1;
                    if(!(auth.getUid()==Pp1)){
                        Map cityy  = (Map) map.get("city");
                        Pair<String,String> ppp1 = new Pair<>(cityy.get("first").toString(),
                                cityy.get("second").toString());
                        pair[0] =ppp1;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(dealerMainActivity.this, "Database Cancelled", Toast.LENGTH_SHORT).show();
            }
        });

        database.getReference().child("Driver").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for(DataSnapshot data : snapshot.getChildren()){
                    Map<String, Object> map  = (Map) data.getValue();
                    Map P1  = (Map) map.get("p1");
                    Pair<String,String> p1 = new Pair<>(P1.get("first").toString(),
                            P1.get("second").toString());
                    Map P2  = (Map) map.get("p2");
                    Pair<String,String> p2 = new Pair<>(P2.get("first").toString(),
                            P2.get("second").toString());
                    Map P3  = (Map) map.get("p3");
                    Pair<String,String> p3 = new Pair<>(P3.get("first").toString(),
                            P3.get("second").toString());
                    Map P4  = (Map) map.get("p4");
                    Pair<String,String> p4 = new Pair<>(P4.get("first").toString(),
                            P4.get("second").toString());
                    Map P5  = (Map) map.get("p5");
                    Pair<String,String> p5 = new Pair<>(P5.get("first").toString(),
                            P5.get("second").toString());
                    Map P6  = (Map) map.get("p6");
                    Pair<String,String> p6 = new Pair<>(P6.get("first").toString(),
                            P6.get("second").toString());
                    if((pair[0].equals(p1)) ||(pair[0].equals(p2)) ||(pair[0].equals(p3)) ||
                            (pair[0].equals(p4)) ||(pair[0].equals(p5)) ||(pair[0].equals(p6))) {
                        driverModel model = new driverModel();
                        model.setUid(map.get("uid").toString());
                        model.setName(map.get("name").toString());
                        driverlist.add(model);
                    }
                }
                dealerAdapter adapter = new dealerAdapter(driverlist,currntuid,dealerMainActivity.this);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(dealerMainActivity.this);
                binding.dealerRecyclerView.setAdapter(adapter);
                binding.dealerRecyclerView.setLayoutManager(linearLayoutManager);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(dealerMainActivity.this, "Database Cancelled", Toast.LENGTH_SHORT).show();
            }
        });
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
                startActivity(new Intent(dealerMainActivity.this,chosingMenu.class));
                finish();
                break;
        }
        return true;
    }
}