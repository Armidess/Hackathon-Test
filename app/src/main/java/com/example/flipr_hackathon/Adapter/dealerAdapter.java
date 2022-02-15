package com.example.flipr_hackathon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flipr_hackathon.R;
import com.example.flipr_hackathon.userModel.dealerModel;
import com.example.flipr_hackathon.userModel.driverModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class dealerAdapter extends RecyclerView.Adapter<dealerAdapter.viewHolder> {

    ArrayList<driverModel> list= new ArrayList<>();
    String uid;
    Context context;
    FirebaseDatabase database;
    FirebaseAuth auth;

    public dealerAdapter(ArrayList<driverModel> list, String uid, Context context) {
        this.list = list;
        this.uid = uid;
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
        auth=FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        final String[] Pp1 = {""};
        String s1 = user.getUid();
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //System.out.println("Naman Noob1");
                try {
                    database.getReference().child("Booked").child(s1).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Pp1[0] = snapshot.getValue().toString();
                            //System.out.println("try"+Pp1[0]);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                } catch (Exception e) {
                    System.out.println("Something went wrong.");
                } finally {
                    System.out.println("finally"+Pp1[0]);
                    if(!Pp1[0].isEmpty()){
                        System.out.println(Pp1[0]);
                        Pp1[0] += ",";
                        System.out.println(Pp1[0]);
                        Pp1[0] += uid;
                        System.out.println(Pp1[0]);
                        database.getReference().child("Booked").child(s1).setValue(Pp1[0]);
                    }
                    else{
                        System.out.println("Naman Noob4");
                        database.getReference().child("Booked").child(s1).setValue(uid);
                    }
                }
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
