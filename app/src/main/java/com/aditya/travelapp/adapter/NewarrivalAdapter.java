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
import com.aditya.travelapp.models.NewarrivalModel;
import com.bumptech.glide.Glide;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

public class NewarrivalAdapter extends RecyclerView.Adapter<NewarrivalAdapter.Newarrivalviewholder> {
    private List<NewarrivalModel> newarrivalList;
    private Context context;
    public boolean shimmer=true;

    public NewarrivalAdapter(List<NewarrivalModel> newarrivalList, Context context) {
        this.newarrivalList = newarrivalList;
        this.context = context;
    }

    @NonNull
    @Override
    public Newarrivalviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view=  LayoutInflater.from(parent.getContext()).inflate(R.layout.newarrival,parent,false);
        return new Newarrivalviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Newarrivalviewholder holder, int position) {
        if(shimmer){
            holder.shimmerFrameLayout.startShimmer();
        }else {
            holder.shimmerFrameLayout.stopShimmer();
            holder.shimmerFrameLayout.setShimmer(null);
            NewarrivalModel newarrivalModel = newarrivalList.get(position);
            holder.placeimage.setBackground(null);
            Glide.with(context).load(newarrivalModel.getPlace_image()).into(holder.placeimage);
            holder.placename.setBackground(null);
            holder.placename.setText(newarrivalModel.getPlace_name());
        }
    }

    @Override
    public int getItemCount() {
        int shimmercount=10;
        return shimmer? shimmercount:newarrivalList.size();
    }

    public class Newarrivalviewholder extends RecyclerView.ViewHolder {
        private ImageView placeimage;
        private TextView placename;
        ShimmerFrameLayout shimmerFrameLayout;
        public Newarrivalviewholder(@NonNull View itemView) {
            super(itemView);
            placeimage=itemView.findViewById(R.id.placeimagedetail);
            placename=itemView.findViewById(R.id.placename);
            shimmerFrameLayout=itemView.findViewById(R.id.shimmerlayout);

        }
    }
}
