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
import com.aditya.travelapp.models.CategoryModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.Categoryviewholder> {
    List<CategoryModel> categorylist;
    Context context;

    public CategoryAdapter(List<CategoryModel> categorylist, Context context) {
        this.categorylist = categorylist;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryAdapter.Categoryviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.category,parent,false);
        return new CategoryAdapter.Categoryviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.Categoryviewholder holder, int position) {
        CategoryModel model=categorylist.get(position);
        holder.category_name.setText(model.getCat_title());
        Glide.with(context).load(model.getCat_image()).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).skipMemoryCache(false).placeholder(R.drawable.travel_black).into(holder.category_image);

    }

    @Override
    public int getItemCount() {
        return categorylist.size();
    }

    public class Categoryviewholder extends RecyclerView.ViewHolder {
        private ImageView category_image;
        private TextView category_name;
        public Categoryviewholder(@NonNull View itemView) {
            super(itemView);
            category_name=(TextView) itemView.findViewById(R.id.categorytext);
            category_image=itemView.findViewById(R.id.categoryimage);

        }
    }
}
