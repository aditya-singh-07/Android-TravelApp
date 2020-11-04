package com.aditya.travelapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aditya.travelapp.Api.ApiClient;
import com.aditya.travelapp.Api.ApiInterface;
import com.aditya.travelapp.Api.users;
import com.aditya.travelapp.R;
import com.aditya.travelapp.adapter.BannerAdapter;
import com.aditya.travelapp.adapter.DiscoverAdapter;
import com.aditya.travelapp.models.BannerModel;
import com.aditya.travelapp.models.DiscoverModel;
import com.aditya.travelapp.session.SessionManage;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Discover extends Fragment {
    private RecyclerView discoverrecycler;
    private List<DiscoverModel> discoverlist;
    private DiscoverAdapter discoverAdapter;
    public static ApiInterface apiInterface;
    public Discover() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loaddata();
                discoverAdapter.notifyDataSetChanged();
            }
        },800);

    }

     void loaddata() {

        Call<users> bannercall=apiInterface.getDiscovers();
        bannercall.enqueue(new Callback<users>() {
            @Override
            public void onResponse(Call<users> call, Response<users> response) {
                discoverlist=response.body().getDiscovers();
                discoverAdapter=new DiscoverAdapter(discoverlist,getContext());
                discoverrecycler.setAdapter(discoverAdapter);
                discoverAdapter.notifyDataSetChanged();
                discoverAdapter.shimmer=false;
            }

            @Override
            public void onFailure(Call<users> call, Throwable t) {

            }
        });

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
        discoverAdapter=new DiscoverAdapter(discoverlist,getContext());
        discoverrecycler.setAdapter(discoverAdapter);



//        discoverlist.add(new DiscoverModel(R.drawable.image1,"Washington dc","Hydrabad, 295 km from Hingoli","6 Nov-8 Nov,Fri- Sun","60% OFF BOOK Now","4.6","2000","Adventure"));
//        discoverlist.add(new DiscoverModel(R.drawable.image2,"Washington dc","Hydrabad, 295 km from Hingoli","6 Nov-8 Nov,Fri- Sun","60% OFF BOOK Now","4.6","2000","Adventure"));
//        discoverlist.add(new DiscoverModel(R.drawable.image3,"Washington dc","Hydrabad, 295 km from Hingoli","6 Nov-8 Nov,Fri- Sun","60% OFF BOOK Now","4.6","2000","Adventure"));
//        discoverlist.add(new DiscoverModel(R.drawable.image4,"Washington dc","Hydrabad, 295 km from Hingoli","6 Nov-8 Nov,Fri- Sun","60% OFF BOOK Now","4.6","2000","Adventure"));
//        discoverlist.add(new DiscoverModel(R.drawable.image1,"Washington dc","Hydrabad, 295 km from Hingoli","6 Nov-8 Nov,Fri- Sun","60% OFF BOOK Now","4.6","2000","Adventure"));
//        discoverlist.add(new DiscoverModel(R.drawable.image2,"Washington dc","Hydrabad, 295 km from Hingoli","6 Nov-8 Nov,Fri- Sun","60% OFF BOOK Now","4.6","2000","Adventure"));
//        discoverlist.add(new DiscoverModel(R.drawable.image3,"Washington dc","Hydrabad, 295 km from Hingoli","6 Nov-8 Nov,Fri- Sun","60% OFF BOOK Now","4.6","2000","Adventure"));
//        discoverlist.add(new DiscoverModel(R.drawable.image4,"Washington dc","Hydrabad, 295 km from Hingoli","6 Nov-8 Nov,Fri- Sun","60% OFF BOOK Now","4.6","2000","Adventure"));

    }
}