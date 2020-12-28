package com.example.uimix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.uimix.Helpers.BottomNavigationHelper;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsViewActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_view);
        bindViews();
    }

    private void bindViews(){
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void mwBackBTNOnClickListener(View view){
        BottomNavigationHelper.previous(this);
    }

    public void mwExitBTNOnClickListener(View view){
        BottomNavigationHelper.shutdown(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng kastamonuLoc = new LatLng(41.436090, 33.765789);
        googleMap.addMarker(new MarkerOptions().position(kastamonuLoc).title("Kastamonu Üniversitesi"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kastamonuLoc,15));
    }
}