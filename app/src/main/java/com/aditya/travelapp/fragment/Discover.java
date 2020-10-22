package com.aditya.travelapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aditya.travelapp.R;
import com.aditya.travelapp.adapter.BannerAdapter;
import com.aditya.travelapp.adapter.DiscoverAdapter;
import com.aditya.travelapp.models.BannerModel;
import com.aditya.travelapp.models.DiscoverModel;
import com.aditya.travelapp.session.SessionManage;

import java.util.ArrayList;
import java.util.List;

public class Discover extends Fragment {
    private RecyclerView discoverrecycler;
    private List<DiscoverModel> discoverlist;
    private DiscoverAdapter discoverAdapter;
    public Discover() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_discover, container, false);
        SessionManage session=new SessionManage(getContext());
        discoverrecycler=(RecyclerView) view.findViewById(R.id.discoverrecycler);
        init();
        return view;
    }

    private void init() {
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.VERTICAL);
        discoverrecycler.setLayoutManager(manager);
        discoverrecycler.setHasFixedSize(true);

        discoverlist=new ArrayList<DiscoverModel>();
        discoverlist.add(new DiscoverModel(R.drawable.image1,"Washington dc","Hydrabad, 295 km from Hingoli","6 Nov-8 Nov,Fri- Sun","60% OFF BOOK Now","4.6","2000"));
        discoverlist.add(new DiscoverModel(R.drawable.image2,"Washington dc","Hydrabad, 295 km from Hingoli","6 Nov-8 Nov,Fri- Sun","60% OFF BOOK Now","4.6","2000"));
        discoverlist.add(new DiscoverModel(R.drawable.image3,"Washington dc","Hydrabad, 295 km from Hingoli","6 Nov-8 Nov,Fri- Sun","60% OFF BOOK Now","4.6","2000"));
        discoverlist.add(new DiscoverModel(R.drawable.image4,"Washington dc","Hydrabad, 295 km from Hingoli","6 Nov-8 Nov,Fri- Sun","60% OFF BOOK Now","4.6","2000"));
        discoverlist.add(new DiscoverModel(R.drawable.image1,"Washington dc","Hydrabad, 295 km from Hingoli","6 Nov-8 Nov,Fri- Sun","60% OFF BOOK Now","4.6","2000"));
        discoverlist.add(new DiscoverModel(R.drawable.image2,"Washington dc","Hydrabad, 295 km from Hingoli","6 Nov-8 Nov,Fri- Sun","60% OFF BOOK Now","4.6","2000"));
        discoverlist.add(new DiscoverModel(R.drawable.image3,"Washington dc","Hydrabad, 295 km from Hingoli","6 Nov-8 Nov,Fri- Sun","60% OFF BOOK Now","4.6","2000"));
        discoverlist.add(new DiscoverModel(R.drawable.image4,"Washington dc","Hydrabad, 295 km from Hingoli","6 Nov-8 Nov,Fri- Sun","60% OFF BOOK Now","4.6","2000"));
        discoverAdapter=new DiscoverAdapter(discoverlist,getContext());
        discoverrecycler.setAdapter(discoverAdapter);
        discoverAdapter.notifyDataSetChanged();
    }
}