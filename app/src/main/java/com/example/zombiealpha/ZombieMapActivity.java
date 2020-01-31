package com.example.zombiealpha;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ZombieMapActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener {

    private GoogleMap mMap;
    private final int PERM_REQUEST_LOCATION_INT = 1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zombie_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //navigation
        Button leaveMap = (Button) findViewById(R.id.leaveMap);
        leaveMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PlayerInv.class);
                view.getContext().startActivity(intent);}
        });
    }




    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
//perm check
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION))
                {
                    Toast.makeText(getApplicationContext(),"Need location for exploration, loot finding",Toast.LENGTH_SHORT).show();
                    requestPerms();
                } else {
                    requestPerms();
                }
            }
        else {
//            Toast.makeText(getApplicationContext(), "HAVE perms", Toast.LENGTH_SHORT).show();
            mapSetup();
        }
    }

    private void requestPerms() {
        ActivityCompat.requestPermissions
        (this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},PERM_REQUEST_LOCATION_INT);
    }

//catch request reply
    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            String permissions[],
            int[] grantResults)    {

        switch (requestCode) {
            case PERM_REQUEST_LOCATION_INT:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    mapSetup();
                } else {
                    Toast.makeText(this, "Permission Denied!", Toast.LENGTH_SHORT).show();
                    //response??
                }
        }
    }

    private void mapSetup() {
        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);
        mMap.getUiSettings().setZoomControlsEnabled(true);//maybe not
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.setPadding(10,10,10,100);
    }

    @Override
    public boolean onMyLocationButtonClick() {
//        Toast.makeText(this, "Button", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Current location:\n" + location, Toast.LENGTH_LONG).show();
    }
}
