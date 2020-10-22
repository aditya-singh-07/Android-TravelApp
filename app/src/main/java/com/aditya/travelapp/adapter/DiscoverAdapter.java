package com.aditya.travelapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aditya.travelapp.R;
import com.aditya.travelapp.models.DiscoverModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class DiscoverAdapter extends RecyclerView.Adapter<DiscoverAdapter.Discoverviewholder> {
    private List<DiscoverModel> discoverlist;
    private Context context;

    public DiscoverAdapter(List<DiscoverModel> discoverlist, Context context) {
        this.discoverlist = discoverlist;
        this.context = context;
    }

    @NonNull
    @Override
    public DiscoverAdapter.Discoverviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.discover,parent,false);
        return new Discoverviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscoverAdapter.Discoverviewholder holder, int position) {
        DiscoverModel model=discoverlist.get(position);
        Glide.with(context).load(model.getPlace_image()).into(holder.placeimg);
        holder.placename.setText(model.getPlace_name());
        holder.location.setText(model.getLocation());
        holder.available.setText(model.getAvailable());
        holder.offer.setText(model.getOffer());
        holder.rating.setText(model.getRating());
        holder.price.setText(model.getPrice());

    }

    @Override
    public int getItemCount() {
        return discoverlist.size();
    }

    public class Discoverviewholder extends RecyclerView.ViewHolder {
        private ImageView placeimg;
        private TextView placename,location,available,offer,rating,price;

        public Discoverviewholder(@NonNull View itemView) {
            super(itemView);
            placeimg=itemView.findViewById(R.id.placeimage);
            placename=itemView.findViewById(R.id.placename);
            location=itemView.findViewById(R.id.location);
            available=itemView.findViewById(R.id.available);
            offer=itemView.findViewById(R.id.offer);
            rating=itemView.findViewById(R.id.rating);
            price=itemView.findViewById(R.id.price);



        }
    }
}
