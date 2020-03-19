package com.example.zombiealpha.LootClasses;

public class Automotive extends Loot {

    public Automotive(Float roll, String type) {
        this.Title = type + " PlaceHolder";
        this.Description = "Automotive place holder item";
        this.Weight  = roll * 10f;
    }
}
