package com.example.zombiealpha.LootClasses;

import com.google.android.libraries.places.api.model.Place;

public class Clothing extends Loot {
    Float insulation;
    Float protection;

    public Clothing(Float roll, Place.Type type) {
        this.insulation = roll-0.5f;
        this.protection = roll*10f;
        this.Title = "Rags";
        this.Description = "Scraps of Cloth toTie onto yourself";
        this.Weight = roll*3f;
    }
}
