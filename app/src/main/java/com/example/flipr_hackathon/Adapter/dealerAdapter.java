package com.example.flipr_hackathon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flipr_hackathon.R;
import com.example.flipr_hackathon.userModel.dealerModel;
import com.example.flipr_hackathon.userModel.driverModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class dealerAdapter extends RecyclerView.Adapter<dealerAdapter.viewHolder> {

    ArrayList<driverModel> list= new ArrayList<>();
    Context context;
    FirebaseDatabase database;
    FirebaseAuth auth;

    public dealerAdapter(ArrayList<driverModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dealerlayout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        driverModel user = list.get(position);
        holder.textview.setText(user.getName());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                auth = FirebaseAuth.getInstance();
                String uid = auth.getUid();
                database.getReference().child("Booked").child(user.getUid()).setValue(uid);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView textview;
        Button button;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textview = itemView.findViewById(R.id.dealerName);
            button  = itemView.findViewById(R.id.bookBtn);

        }
    }
}
