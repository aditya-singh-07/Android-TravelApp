package com.aditya.travelapp.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aditya.travelapp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
public class MapFragment extends Fragment {
    TextView lat,lng;
    public MapFragment(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView location= getActivity().findViewById(R.id.place_detail_location);
        lat=getActivity().findViewById(R.id.placelat);
        lng=getActivity().findViewById(R.id.placelong);
        String latitude=lat.getText().toString();
        String longgitude=lng.getText().toString();
        String address=location.getText().toString();
        View view= inflater.inflate(R.layout.fragment_map, container, false);

        SupportMapFragment supportMapFragment= (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                LatLng place =new LatLng(Double.parseDouble(latitude),Double.parseDouble(longgitude));
                googleMap.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(latitude),Double.parseDouble(longgitude))).title(address));
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(place,10));
                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(LatLng latLng) {
                        Uri uri= Uri.parse("geo:" + latitude + "," + longgitude );
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        startActivity(mapIntent);
                }
                });

            }
        });
        return  view;
    }
}