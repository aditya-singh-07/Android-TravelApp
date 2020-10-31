package com.aditya.travelapp.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aditya.travelapp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
public class MapFragment extends Fragment {

    public MapFragment(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_map, container, false);

        SupportMapFragment supportMapFragment= (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {

                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(LatLng latLng) {
                        Uri uri= Uri.parse("geo:32.2190, 76.3234");
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        startActivity(mapIntent);
//                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));
//                        googleMap.addMarker(new MarkerOptions().position(new LatLng(32.2190, 76.3234)).title("Marker"));

                    }
                });

            }
        });
        return  view;
    }
}