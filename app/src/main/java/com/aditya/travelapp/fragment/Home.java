package com.aditya.travelapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aditya.travelapp.R;
import com.aditya.travelapp.adapter.CategoryAdapter;
import com.aditya.travelapp.models.CategoryModel;
import com.aditya.travelapp.session.SessionManage;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment {
    private RecyclerView recyclerView;
    private List<CategoryModel> categorylist;
    private CategoryAdapter categoryAdapter;

    public Home() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        SessionManage session=new SessionManage(getContext());
        recyclerView=(RecyclerView) view.findViewById(R.id.recyclerview);
        init();
        return  view;
    }

    private void init() {

        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setKeepScreenOn(true);
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

}