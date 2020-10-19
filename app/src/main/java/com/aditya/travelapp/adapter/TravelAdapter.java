package com.aditya.travelapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aditya.travelapp.R;
import com.aditya.travelapp.models.TravelModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class TravelAdapter extends RecyclerView.Adapter<TravelAdapter.Travelviewholder> {
    private List<TravelModel> Travel_feedlist;
    private Context context;

    public TravelAdapter(List<TravelModel> list, Context context) {
        this.Travel_feedlist = list;
        this.context = context;
    }


    @NonNull
    @Override
    public Travelviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_travel,parent,false);
        return new Travelviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TravelAdapter.Travelviewholder holder, int position) {
        TravelModel model=Travel_feedlist.get(position);
        Glide.with(context).load(model.getTravel_image()).into(holder.travel_feed);

    }

    @Override
    public int getItemCount() {
        return Travel_feedlist.size();
    }

    public class Travelviewholder extends RecyclerView.ViewHolder {
        private ImageView travel_feed;
        public Travelviewholder(@NonNull View itemView) {
            super(itemView);
            travel_feed=itemView.findViewById(R.id.travel_feed);

        }
    }
}
