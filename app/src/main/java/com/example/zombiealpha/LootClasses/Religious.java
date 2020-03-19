package com.example.zombiealpha.LootClasses;

import com.google.android.libraries.places.api.model.Place;

public class Religious extends Loot {

    public Religious(Float roll, Place.Type type) {

        this.Title = "Holy Book";
        this.Description = "Words of comfort and Guidance";
        this.Weight = roll * 2;
    }
}
