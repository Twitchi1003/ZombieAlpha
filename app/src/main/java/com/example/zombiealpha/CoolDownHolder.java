package com.example.zombiealpha;

import com.google.android.gms.maps.model.PointOfInterest;

import java.util.Date;


public class CoolDownHolder {

    PointOfInterest pointOfInterest;
    Date dateStamp;

    CoolDownHolder(PointOfInterest poi, Date currentTime){
            pointOfInterest = poi;
            dateStamp = currentTime;
    }
}
