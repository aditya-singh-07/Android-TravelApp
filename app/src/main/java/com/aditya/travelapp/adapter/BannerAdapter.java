package com.aditya.travelapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aditya.travelapp.R;
import com.aditya.travelapp.models.BannerModel;
import com.aditya.travelapp.models.CategoryModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.Bannerviewholder> {
    private List<BannerModel> bannerlist;
    private Context context;

    public BannerAdapter(List<BannerModel> bannerlist, Context context) {
        this.bannerlist = bannerlist;
        this.context = context;
    }

    @NonNull
    @Override
    public BannerAdapter.Bannerviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.banner,parent,false);
        return new Bannerviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerAdapter.Bannerviewholder holder, int position) {
        BannerModel model=bannerlist.get(position);
        Glide.with(context).load(model.getBanner_image()).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).skipMemoryCache(false).placeholder(R.drawable.travel_black).into(holder.banner_image);
    }

    @Override
    public int getItemCount() {
        return bannerlist.size();
    }

    public class Bannerviewholder extends RecyclerView.ViewHolder {
        private ImageView banner_image;
        public Bannerviewholder(@NonNull View itemView) {
            super(itemView);
            banner_image=itemView.findViewById(R.id.banner);
        }
    }
}
