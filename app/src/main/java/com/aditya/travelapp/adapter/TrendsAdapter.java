package com.aditya.travelapp.adapter;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aditya.travelapp.R;
import com.aditya.travelapp.models.DiscoverModel;
import com.aditya.travelapp.models.TrendsModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class TrendsAdapter extends RecyclerView.Adapter<TrendsAdapter.Trendsviewholder> {
    private List<TrendsModel> trendslist;
    private Context context;

    public TrendsAdapter(List<TrendsModel> trendslist, Context context) {
        this.trendslist = trendslist;
        this.context = context;
    }

    @NonNull
    @Override
    public TrendsAdapter.Trendsviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view=  LayoutInflater.from(parent.getContext()).inflate(R.layout.trends,parent,false);
        return new Trendsviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendsAdapter.Trendsviewholder holder, int position) {
        TrendsModel trendmodel=trendslist.get(position);
        Glide.with(context).load(trendmodel.getPlaceimage()).into(holder.placeimage);
        holder.placename.setText(trendmodel.getPlacename());
    }

    @Override
    public int getItemCount() {
        return trendslist.size();
    }

    public class Trendsviewholder extends RecyclerView.ViewHolder {
        private ImageView placeimage;
        private TextView placename;
        public Trendsviewholder(@NonNull View itemView) {
            super(itemView);
            placeimage=itemView.findViewById(R.id.placeimage);
            placename=itemView.findViewById(R.id.placename);

        }
    }
}
