package com.aditya.travelapp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.aditya.travelapp.DashBoardActivity;
import com.aditya.travelapp.MainActivity;
import com.aditya.travelapp.R;
import com.aditya.travelapp.adapter.BannerAdapter;
import com.aditya.travelapp.adapter.CategoryAdapter;
import com.aditya.travelapp.adapter.MostvisitAdapter;
import com.aditya.travelapp.adapter.TrendsAdapter;
import com.aditya.travelapp.models.BannerModel;
import com.aditya.travelapp.models.CategoryModel;
import com.aditya.travelapp.models.MostvisitModel;
import com.aditya.travelapp.models.TravelModel;
import com.aditya.travelapp.models.TrendsModel;
import com.aditya.travelapp.session.SessionManage;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment {
    private RecyclerView recyclerView,recyclerViewbanner,recycviewtrends,recyclerviewmostvisit;
    private List<CategoryModel> categorylist;
    private  List<BannerModel> bannerlist;
    private  List<TrendsModel> trendslist;
    private List<MostvisitModel> mostvisitList;

    private CategoryAdapter categoryAdapter;
    private BannerAdapter bannerAdapter;
    private TrendsAdapter trendsAdapter;
    private MostvisitAdapter mostvisitAdapter;
    private SessionManage sessionManage;

    public Home() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sessionManage=new SessionManage(getContext());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        SessionManage session=new SessionManage(getContext());
        recyclerView=(RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerViewbanner=(RecyclerView) view.findViewById(R.id.recyclerviewbanner);
        recycviewtrends=view.findViewById(R.id.recyclerviewtrends);
        recyclerviewmostvisit=view.findViewById(R.id.recyclerviewmostvisit);
        init();
        bannerinit();
        trendsinit();
        mostviewinit();
        return  view;
    }

    private void mostviewinit() {
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerviewmostvisit.setLayoutManager(manager);
        recyclerviewmostvisit.setHasFixedSize(true);

        mostvisitList=new ArrayList<>();
        mostvisitList.add(new MostvisitModel(R.drawable.image1,"Yosemite"));
        mostvisitList.add(new MostvisitModel(R.drawable.image1,"Montana"));
        mostvisitList.add(new MostvisitModel(R.drawable.image4,"Grand Canyon"));
        mostvisitList.add(new MostvisitModel(R.drawable.image2,"New Orleans"));
        mostvisitList.add(new MostvisitModel(R.drawable.image3,"Laguna Califonia"));
        mostvisitAdapter=new MostvisitAdapter(mostvisitList,getContext());
        recyclerviewmostvisit.setAdapter(mostvisitAdapter);
        mostvisitAdapter.notifyDataSetChanged();

    }

    /////////////////// set trends recyclerview /////////////////////////
    private void trendsinit() {
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        recycviewtrends.setLayoutManager(manager);
        recycviewtrends.setHasFixedSize(true);

        trendslist=new ArrayList<>();
        trendslist.add(new TrendsModel(R.drawable.image1,"Montana"));
        trendslist.add(new TrendsModel(R.drawable.image2,"New Orleans"));
        trendslist.add(new TrendsModel(R.drawable.image3,"Laguna Califonia"));
        trendslist.add(new TrendsModel(R.drawable.image4,"Grand Canyon"));
        trendslist.add(new TrendsModel(R.drawable.image1,"Yosemite"));
        trendsAdapter=new TrendsAdapter(trendslist,getContext());
        recycviewtrends.setAdapter(trendsAdapter);
        trendsAdapter.notifyDataSetChanged();
    }
    /////////////////// set trends recyclerview /////////////////////////

    /////////////////// set Banner recyclerview /////////////////////////
    private void bannerinit() {
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewbanner.setLayoutManager(manager);
        recyclerViewbanner.setHasFixedSize(true);

        bannerlist=new ArrayList<>();
        bannerlist.add(new BannerModel(R.drawable.image1));
        bannerlist.add(new BannerModel(R.drawable.image2));
        bannerlist.add(new BannerModel(R.drawable.travel_black));
        bannerlist.add(new BannerModel(R.drawable.travel_black));
        bannerlist.add(new BannerModel(R.drawable.travel_black));
        bannerAdapter=new BannerAdapter(bannerlist,getContext());
        recyclerViewbanner.setAdapter(bannerAdapter);
        bannerAdapter.notifyDataSetChanged();

    }
    /////////////////// set banner recyclerview /////////////////////////

    /////////////////// set Category recyclerview /////////////////////////
    private void init() {

        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);

        categorylist=new ArrayList<CategoryModel>();
        categorylist.add(new CategoryModel(R.drawable.travel_black,"Adventure travel"));
        categorylist.add(new CategoryModel(R.drawable.travel_black,"Birth tourism"));
        categorylist.add(new CategoryModel(R.drawable.travel_black,"camping"));
        categorylist.add(new CategoryModel(R.drawable.travel_black,"Fashion tourism"));
        categorylist.add(new CategoryModel(R.drawable.travel_black,"Adventure travel"));
        categorylist.add(new CategoryModel(R.drawable.travel_black,"Birth tourism"));
        categorylist.add(new CategoryModel(R.drawable.travel_black,"camping"));
        categorylist.add(new CategoryModel(R.drawable.travel_black,"Fashion tourism"));
        categoryAdapter=new CategoryAdapter(categorylist,getContext());
        recyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();
    }
    /////////////////// Category recyclerview /////////////////////////

    private void logout() {
        sessionManage.editor.clear();
        sessionManage.editor.commit();
        Intent i=new Intent(getContext(), MainActivity.class);
        startActivity(i);
        Animatoo.animateFade(getContext());
    }
    @Override
    public void onStart() {
        if(!sessionManage.islogin()){
            sessionManage.editor.clear();
            sessionManage.editor.commit();
        }
        super.onStart();
    }


}