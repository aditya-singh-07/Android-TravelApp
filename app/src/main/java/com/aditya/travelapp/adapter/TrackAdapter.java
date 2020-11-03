package com.aditya.travelapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aditya.travelapp.R;
import com.aditya.travelapp.models.TrackModel;
import com.aditya.travelapp.models.TravelModel;

import java.util.List;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.trackviewholder> {
   List<TrackModel> tracklist;
   Context context;

    public TrackAdapter(List<TrackModel> tracklist, Context context) {
        this.tracklist = tracklist;
        this.context = context;
    }

    @NonNull
    @Override
    public trackviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.track,parent,false);
        return new trackviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull trackviewholder holder, int position) {
        TrackModel model=tracklist.get(position);
        holder.times.setText(model.getLogin_date());
        holder.ip.setText(model.getIp());
    }

    @Override
    public int getItemCount() {
        return tracklist.size();
    }

    public class trackviewholder extends RecyclerView.ViewHolder {
        TextView times,ip;
        public trackviewholder(@NonNull View itemView) {
            super(itemView);
            times=itemView.findViewById(R.id.historytime);
            ip=itemView.findViewById(R.id.ip);


        }
    }
}
