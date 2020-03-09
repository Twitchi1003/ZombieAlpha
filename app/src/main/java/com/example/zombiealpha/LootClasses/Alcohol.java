package com.example.zombiealpha.LootClasses;

public class Alcohol extends Loot {

    public Alcohol(Float roll) {
        this.Title = "Beer";
        this.Description = "A single can of fermented hops juice";
        this.Weight = roll * 2;
    }
}
