package com.aditya.travelapp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aditya.travelapp.Api.ApiClient;
import com.aditya.travelapp.Api.ApiInterface;
import com.aditya.travelapp.Api.users;
import com.aditya.travelapp.MainActivity;
import com.aditya.travelapp.R;
import com.aditya.travelapp.adapter.BannerAdapter;
import com.aditya.travelapp.adapter.CategoryAdapter;
import com.aditya.travelapp.adapter.DiscoverAdapter;
import com.aditya.travelapp.adapter.MostvisitAdapter;
import com.aditya.travelapp.adapter.NewarrivalAdapter;
import com.aditya.travelapp.adapter.TrendsAdapter;
import com.aditya.travelapp.connection.Checknetwork;
import com.aditya.travelapp.database.category;
import com.aditya.travelapp.models.BannerModel;
import com.aditya.travelapp.models.CategoryModel;
import com.aditya.travelapp.models.MostvisitModel;
import com.aditya.travelapp.models.NewarrivalModel;
import com.aditya.travelapp.models.TrendsModel;
import com.aditya.travelapp.session.SessionManage;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends Fragment {
    private RecyclerView recyclerView,recyclerViewbanner,recycviewtrends,recyclerviewmostvisit,recyclerviewnewarrival;
    private List<CategoryModel> categorylist;
    private  List<BannerModel> bannerlist;
    private  List<TrendsModel> trendslist;
    private List<MostvisitModel> mostvisitList;
    private  List<NewarrivalModel> newarrivalList;

    private CategoryAdapter categoryAdapter;
    private BannerAdapter bannerAdapter;
    private TrendsAdapter trendsAdapter;
    private MostvisitAdapter mostvisitAdapter;
    private NewarrivalAdapter newarrivalAdapter;
    private SessionManage sessionManage;
    private Checknetwork checknetwork;
    public boolean shimmer=false;
    private int someStateValue;
    private final String SOME_VALUE_KEY = "someValueToSave";
    ///////// Api interface object ////////////////
    public static ApiInterface apiInterface;
    ///////// Api interface object ////////////////
    public Home() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sessionManage=new SessionManage(getContext());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loaddata();
                loadbanner();
                loadcategory();
                loadmostvisit();
                loadnewarrival();
                trendsAdapter.notifyDataSetChanged();
                bannerAdapter.notifyDataSetChanged();
                categoryAdapter.notifyDataSetChanged();
                mostvisitAdapter.notifyDataSetChanged();
                newarrivalAdapter.notifyDataSetChanged();
//                mostvisitAdapter.shimmer=false;

            }
        },100);

        category.getinstance(getContext());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ///////// Api interface object initialize ////////////////
        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        ///////// Api interface object initialize ////////////////

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        SessionManage session=new SessionManage(getContext());
        recyclerView=(RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerViewbanner=(RecyclerView) view.findViewById(R.id.recyclerviewbanner);
        recycviewtrends=view.findViewById(R.id.recyclerviewtrends);
        recyclerviewmostvisit=view.findViewById(R.id.recyclerviewmostvisit);
        recyclerviewnewarrival=view.findViewById(R.id.recyclerviewnewarrival);
        init();
        bannerinit();
        trendsinit();
        mostviewinit();
        newarrivalinit();
        return  view;
    }

    private void newarrivalinit() {
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerviewnewarrival.setLayoutManager(manager);
        recyclerviewnewarrival.setHasFixedSize(true);

        newarrivalList=new ArrayList<>();
//        newarrivalList.add(new NewarrivalModel(R.drawable.image1,"Yosemite"));
//        newarrivalList.add(new NewarrivalModel(R.drawable.image1,"Montana"));
//        newarrivalList.add(new NewarrivalModel(R.drawable.image4,"Grand Canyon"));
//        newarrivalList.add(new NewarrivalModel(R.drawable.image2,"New Orleans"));
//        newarrivalList.add(new NewarrivalModel(R.drawable.image3,"Laguna Califonia"));
        newarrivalAdapter=new NewarrivalAdapter(newarrivalList,getContext());
        recyclerviewnewarrival.setAdapter(newarrivalAdapter);
    }

    void loadnewarrival(){
        Call<users> newarrival=apiInterface.getNewarrival();
        newarrival.enqueue(new Callback<users>() {
            @Override
            public void onResponse(Call<users> call, Response<users> response) {
                newarrivalList=response.body().getNewarrival();
                newarrivalAdapter=new NewarrivalAdapter(newarrivalList,getContext());
                recyclerviewnewarrival.setAdapter(newarrivalAdapter);
                newarrivalAdapter.notifyDataSetChanged();
                newarrivalAdapter.shimmer=false;

            }

            @Override
            public void onFailure(Call<users> call, Throwable t) {

            }
        });
    }

   void loaddata(){
           Call<users> Trendcall=apiInterface.getTrends();
       Trendcall.enqueue(new Callback<users>() {
               @Override
               public void onResponse(Call<users> call, Response<users> response) {
//                   Log.i("response", String.valueOf(response.isSuccessful()));
                   trendslist=response.body().getTrends();
                   trendsAdapter=new TrendsAdapter(trendslist,getContext());
                   recycviewtrends.setAdapter(trendsAdapter);
                   trendsAdapter.shimmer=false;

               }

               @Override
               public void onFailure(Call<users> call, Throwable t) {

               }
           });
//
//       trendslist.add(new TrendsModel(R.drawable.image1,"Montana"));
//       trendslist.add(new TrendsModel(R.drawable.image2,"New Orleans"));
//       trendslist.add(new TrendsModel(R.drawable.image3,"Laguna Califonia"));
//       trendslist.add(new TrendsModel(R.drawable.image4,"Grand Canyon"));
//       trendslist.add(new TrendsModel(R.drawable.image1,"Yosemite"));
    }

    private void mostviewinit() {
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerviewmostvisit.setLayoutManager(manager);
        recyclerviewmostvisit.setHasFixedSize(true);
        mostvisitList=new ArrayList<MostvisitModel>();

        mostvisitAdapter=new MostvisitAdapter(mostvisitList,getContext());
        recyclerviewmostvisit.setAdapter(mostvisitAdapter);
//        mostvisitList=new ArrayList<>();
//        mostvisitList.add(new MostvisitModel(R.drawable.image1,"Yosemite"));
//        mostvisitList.add(new MostvisitModel(R.drawable.image1,"Montana"));
//        mostvisitList.add(new MostvisitModel(R.drawable.image4,"Grand Canyon"));
//        mostvisitList.add(new MostvisitModel(R.drawable.image2,"New Orleans"));
//        mostvisitList.add(new MostvisitModel(R.drawable.image3,"Laguna Califonia"));
//        mostvisitAdapter=new MostvisitAdapter(mostvisitList,getContext());
//        recyclerviewmostvisit.setAdapter(mostvisitAdapter);
//        mostvisitAdapter.notifyDataSetChanged();

    }
   void loadmostvisit(){
       Call<users> mostvisitcall=apiInterface.getMostvisit();
       mostvisitcall.enqueue(new Callback<users>() {
           @Override
           public void onResponse(Call<users> call, Response<users> response) {
//                   Log.i("response", String.valueOf(response.isSuccessful()));
               mostvisitList=response.body().getMostvisit();
               Log.i("response visit", String.valueOf(response.isSuccessful()));
               mostvisitAdapter=new MostvisitAdapter(mostvisitList,getContext());
               recyclerviewmostvisit.setAdapter(mostvisitAdapter);
               mostvisitAdapter.notifyDataSetChanged();
               mostvisitAdapter.shimmer=false;
           }

           @Override
           public void onFailure(Call<users> call, Throwable t) {

           }
       });

   }

    /////////////////// set trends recyclerview /////////////////////////
    private void trendsinit() {
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        recycviewtrends.setLayoutManager(manager);
        recycviewtrends.setHasFixedSize(true);

        trendslist=new ArrayList<>();

        trendsAdapter=new TrendsAdapter(trendslist,getContext());
        recycviewtrends.setAdapter(trendsAdapter);

    }
    /////////////////// set trends recyclerview /////////////////////////

    /////////////////// set Banner recyclerview /////////////////////////
    private void bannerinit() {
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewbanner.setLayoutManager(manager);
        recyclerViewbanner.setHasFixedSize(true);

        bannerlist=new ArrayList<>();

        bannerAdapter=new BannerAdapter(bannerlist,getContext());
        recyclerViewbanner.setAdapter(bannerAdapter);



//        bannerlist.add(new BannerModel(R.drawable.image1));
//        bannerlist.add(new BannerModel(R.drawable.image2));
//        bannerlist.add(new BannerModel(R.drawable.travel_black));
//        bannerlist.add(new BannerModel(R.drawable.travel_black));
//        bannerlist.add(new BannerModel(R.drawable.travel_black));
//        bannerAdapter=new BannerAdapter(bannerlist,getContext());
//        recyclerViewbanner.setAdapter(bannerAdapter);
//        bannerAdapter.notifyDataSetChanged();

    }
    void loadbanner(){
        Call<users> bannercall=apiInterface.getBanners();
        bannercall.enqueue(new Callback<users>() {
            @Override
            public void onResponse(Call<users> call, Response<users> response) {
                bannerlist=response.body().getBanners();
                Log.i("aditya","rest banner call");
                bannerAdapter=new BannerAdapter(bannerlist,getContext());
                recyclerViewbanner.setAdapter(bannerAdapter);
                bannerAdapter.notifyDataSetChanged();
                bannerAdapter.shimmer=false;
            }

            @Override
            public void onFailure(Call<users> call, Throwable t) {

            }
        });

    }
    /////////////////// set banner recyclerview /////////////////////////

    /////////////////// set Category recyclerview /////////////////////////
    private void init() {

        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        categorylist=new ArrayList<CategoryModel>();
        categoryAdapter=new CategoryAdapter(categorylist,getContext());
        recyclerView.setAdapter(categoryAdapter);

//        categorylist.add(new CategoryModel(R.drawable.travel_black,"Adventure travel"));
//        categorylist.add(new CategoryModel(R.drawable.travel_black,"Birth tourism"));
//        categorylist.add(new CategoryModel(R.drawable.travel_black,"camping"));
//        categorylist.add(new CategoryModel(R.drawable.travel_black,"Fashion tourism"));
//        categorylist.add(new CategoryModel(R.drawable.travel_black,"Adventure travel"));
//        categorylist.add(new CategoryModel(R.drawable.travel_black,"Birth tourism"));
//        categorylist.add(new CategoryModel(R.drawable.travel_black,"camping"));
//        categorylist.add(new CategoryModel(R.drawable.travel_black,"Fashion tourism"));
//        categoryAdapter=new CategoryAdapter(categorylist,getContext());
//        recyclerView.setAdapter(categoryAdapter);
//        categoryAdapter.notifyDataSetChanged();
    }
   void loadcategory(){
            categorylist=new ArrayList<CategoryModel>();
            Call<users> catcall=apiInterface.getCategorylist();
            catcall.enqueue(new Callback<users>() {
                @Override
                public void onResponse(Call<users> call, Response<users> response) {
                    categorylist=response.body().getCategories();
                    categoryAdapter=new CategoryAdapter(categorylist,getContext());
                    recyclerView.setAdapter(categoryAdapter);
                    categoryAdapter.notifyDataSetChanged();
                    categoryAdapter.shimmer=false;
                }

                @Override
                public void onFailure(Call<users> call, Throwable t) {

                }
            });


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
        init();
        if(!sessionManage.islogin()){
            sessionManage.editor.clear();
            sessionManage.editor.commit();
        }
        super.onStart();
    }


}