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

import java.util.List;

public class NewarrivalAdapter extends RecyclerView.Adapter<NewarrivalAdapter.Newarrivalviewholder> {
    private List<NewarrivalModel> newarrivalList;
    private Context context;

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
        NewarrivalModel newarrivalModel=newarrivalList.get(position);
        Glide.with(context).load(newarrivalModel.getPlaceimage()).into(holder.placeimage);
        holder.placename.setText(newarrivalModel.getPlacename());
    }

    @Override
    public int getItemCount() {
        return newarrivalList.size();
    }

    public class Newarrivalviewholder extends RecyclerView.ViewHolder {
        private ImageView placeimage;
        private TextView placename;
        public Newarrivalviewholder(@NonNull View itemView) {
            super(itemView);
            placeimage=itemView.findViewById(R.id.placeimagedetail);
            placename=itemView.findViewById(R.id.placename);

        }
    }
}
