package com.example.zombiealpha;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PointOfInterest;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.PlacesClient;

import java.util.Arrays;
import java.util.List;

public class ZombieMapActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener, GoogleMap.OnPoiClickListener {

    private GoogleMap mMap;
    private final int PERM_REQUEST_LOCATION_INT = 1;
    private FusedLocationProviderClient FusedLocationClient;
    private String apiKey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zombie_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //location
        FusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        //places API stuff
        apiKey  = getResources().getString(R.string.google_maps_key);
        Places.initialize(getApplicationContext(), apiKey);

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
            Toast.makeText(getApplicationContext(), "HAVE perms", Toast.LENGTH_SHORT).show();
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
        //type and Visuals
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setMinZoomPreference(18.0f);


        //location and markers
        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);
        mMap.setOnPoiClickListener(this);


        mMap.getUiSettings().setZoomControlsEnabled(true);//maybe not
        mMap.getUiSettings().setCompassEnabled(true);




        //move map to user
        FusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                // Got last known location. In some rare situations this can be null.
                if (location != null) {
                    LatLng poss = new LatLng(location.getLatitude(),location.getLongitude());
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom( poss, 15));
                } else{
                    makeToast("poss Null\nPlease check location");
                }
            }
        });

    }

    @Override
    public boolean onMyLocationButtonClick() {
//        Mayyyyybe have a centering map splash
        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        makeToast("This is you");
    }

    @Override
    public void onPoiClick(final PointOfInterest poi) {
        //distance check and throw out if to far

        //great place to think about a caching system for types.. to cut down on requests

        //placeId to place type method
        PlacesClient placesClient = Places.createClient(this);
        String placeId = poi.placeId;
        List<Place.Field> placeFields = Arrays.asList(Place.Field.ID, Place.Field.TYPES);
        FetchPlaceRequest request = FetchPlaceRequest.newInstance(placeId, placeFields);

        placesClient.fetchPlace(request).addOnSuccessListener(new OnSuccessListener<FetchPlaceResponse>() {
            @Override
            public void onSuccess(FetchPlaceResponse fetchPlaceResponse) {
                Place place = fetchPlaceResponse.getPlace();
                PlaceDataHolder holder = new PlaceDataHolder(place);
                String placeName = poi.name;
                makeLootFragment(holder,placeName);
                //play searching\looting SoundFX
            }
        });
    }

    private void makeLootFragment(PlaceDataHolder _holder,String name){

        //pack it for sending
        Bundle lootBundle = new Bundle();

        lootBundle.putParcelable("bPlace" , _holder);
        lootBundle.putString("bName",name);

        FragmentManager lootFragMan = getSupportFragmentManager();
        FragmentTransaction LootTrans = lootFragMan.beginTransaction();
        LootFragment lootFragment = new LootFragment();
        lootFragment.setArguments(lootBundle);
        LootTrans.add(R.id.lootContainer,lootFragment);
        LootTrans.addToBackStack("LootStack");
        LootTrans.commit();

    }





    private void makeToast(String words) {
        Toast.makeText(this, words, Toast.LENGTH_SHORT).show();
    }
}
