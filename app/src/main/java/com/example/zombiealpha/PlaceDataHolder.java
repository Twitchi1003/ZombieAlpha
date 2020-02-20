package com.example.zombiealpha;

import android.os.Parcel;
import android.os.Parcelable;


import com.google.android.libraries.places.api.model.Place;

import java.util.List;


public class PlaceDataHolder implements Parcelable {

    private Place placeData;

    public PlaceDataHolder(Place _place){
        placeData = _place;
    }

    protected PlaceDataHolder(Parcel in) {
        placeData = in.readParcelable(Place.class.getClassLoader());
    }

    public static final Creator<PlaceDataHolder> CREATOR = new Creator<PlaceDataHolder>() {
        @Override
        public PlaceDataHolder createFromParcel(Parcel in) {
            return new PlaceDataHolder(in);
        }

        @Override
        public PlaceDataHolder[] newArray(int size) {
            return new PlaceDataHolder[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(placeData, flags);
    }

    public List<Place.Type> getTypes(){
        return placeData.getTypes();
    }
}
