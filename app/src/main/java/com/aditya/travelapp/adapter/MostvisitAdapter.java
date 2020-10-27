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
import com.aditya.travelapp.models.MostvisitModel;
import com.aditya.travelapp.models.TrendsModel;
import com.bumptech.glide.Glide;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

public class MostvisitAdapter extends RecyclerView.Adapter<MostvisitAdapter.Mostvisitviewholder> {
    private List<MostvisitModel> mostvisitModelList;
    private Context context;
    public boolean shimmer=true;

    public MostvisitAdapter(List<MostvisitModel> mostvisitModelList, Context context) {
        this.mostvisitModelList = mostvisitModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public Mostvisitviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.mostvisit,parent,false);
        return new Mostvisitviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Mostvisitviewholder holder, int position) {
        if(shimmer){
            holder.shimmerFrameLayout.startShimmer();
        }else{
            holder.shimmerFrameLayout.stopShimmer();
            holder.shimmerFrameLayout.setShimmer(null);
            MostvisitModel mostvisitModel=mostvisitModelList.get(position);
            holder.placename.setBackground(null);
            holder.placename.setText(mostvisitModel.getPlacename());
            holder.placeimage.setBackground(null);
            Glide.with(context).load(mostvisitModel.getPlaceimage()).into(holder.placeimage);

        }



    }

    @Override
    public int getItemCount() {
        int shimmercount=8;
        return shimmer? shimmercount:mostvisitModelList.size();
    }

    public class Mostvisitviewholder extends RecyclerView.ViewHolder {
        private ImageView placeimage;
        private TextView placename;
        ShimmerFrameLayout shimmerFrameLayout;

        public Mostvisitviewholder(@NonNull View itemView) {
            super(itemView);
            placeimage=itemView.findViewById(R.id.placeimage);
            placename=itemView.findViewById(R.id.placename);
            shimmerFrameLayout=itemView.findViewById(R.id.shimmerlayout);
        }
    }
}
