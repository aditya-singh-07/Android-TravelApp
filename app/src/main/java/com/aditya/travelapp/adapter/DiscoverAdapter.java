package com.aditya.travelapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.aditya.travelapp.Discover_details;
import com.aditya.travelapp.R;
import com.aditya.travelapp.models.DiscoverModel;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

public class DiscoverAdapter extends RecyclerView.Adapter<DiscoverAdapter.Discoverviewholder> {
    private List<DiscoverModel> discoverlist;
    private Context context;
//     public boolean shimmer=true;

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

            holder.placename.setText(model.getPlace_name());

            Glide.with(context).load(model.getPlace_image()).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .skipMemoryCache(false).placeholder(R.drawable.travel_black).into(holder.placeimg);

            holder.location.setText(model.getLocation());

            holder.available.setText(model.getAvailable());

            holder.offer.setText(model.getOffer());

            holder.rating.setText(model.getRating());

            holder.price.setText(model.getPrice());

            holder.category.setText(model.getCat_title());
            holder.cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "clicked" + getItemId(position), Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(context, Discover_details.class);
                    i.putExtra("id",model.getPlace_id());
                    i.putExtra("placetitle",model.getPlace_name());
                    i.putExtra("placecategory",model.getCat_title());
                    i.putExtra("placeimage",model.getPlace_image());
                    i.putExtra("placelocation",model.getLocation());
                    i.putExtra("available",model.getAvailable());
                    i.putExtra("rating",model.getRating());
                    context.startActivity(i);
                    Animatoo.animateFade(context);
                }
            });
//        if(shimmer){
//            holder.shimmerFrameLayout.startShimmer();
//        }else{
//            holder.shimmerFrameLayout.stopShimmer();
//            holder.shimmerFrameLayout.setShimmer(null);
//
//            DiscoverModel model=discoverlist.get(position);
//            holder.placename.setBackground(null);
//            holder.placename.setText(model.getPlace_name());
//            holder.placeimg.setBackground(null);
//            Glide.with(context).load(model.getPlace_image()).placeholder(R.drawable.travel_black).into(holder.placeimg);
//            holder.location.setBackground(null);
//            holder.location.setText(model.getLocation());
//            holder.available.setBackground(null);
//            holder.available.setText(model.getAvailable());
//            holder.offer.setBackground(null);
//            holder.offer.setText(model.getOffer());
//            holder.rating.setBackground(null);
//            holder.rating.setText(model.getRating());
//            holder.price.setBackground(null);
//            holder.price.setText(model.getPrice());
//            holder.category.setBackground(null);
//            holder.category.setText(model.getCat_title());
//        }


    }

    @Override
    public int getItemCount() {
        int shimmercount=5;
        return discoverlist.size();
    }

    public class Discoverviewholder extends RecyclerView.ViewHolder {
        private ImageView placeimg;
        private TextView placename,location,available,offer,rating,price,category;
        private CardView cardview;
        ShimmerFrameLayout shimmerFrameLayout;
        public Discoverviewholder(@NonNull View itemView) {
            super(itemView);
            cardview=itemView.findViewById(R.id.cardview);
            placeimg=itemView.findViewById(R.id.placeimagedetail);
            placename=itemView.findViewById(R.id.placename);
            location=itemView.findViewById(R.id.place_detail_location);
            available=itemView.findViewById(R.id.place_detail_available);
            offer=itemView.findViewById(R.id.offer);
            rating=itemView.findViewById(R.id.rating);
            price=itemView.findViewById(R.id.price);
            category=itemView.findViewById(R.id.category);


        }
    }
}
