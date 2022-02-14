package com.example.flipr_hackathon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flipr_hackathon.R;
import com.example.flipr_hackathon.userModel.dealerModel;

import java.util.ArrayList;

public class driverAdapter extends RecyclerView.Adapter<driverAdapter.viewHolder> {

    ArrayList<dealerModel> dealerlist;
    Context context;

    public driverAdapter(ArrayList<dealerModel> dealerlist, Context context) {
        this.dealerlist = dealerlist;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.driverlayout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        dealerModel user = dealerlist.get(position);
        holder.textview.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        return dealerlist.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView textview;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textview=itemView.findViewById(R.id.textviewdriver);
        }
    }
}
