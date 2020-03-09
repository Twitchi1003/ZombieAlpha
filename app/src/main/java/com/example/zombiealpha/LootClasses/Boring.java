package com.example.zombiealpha.LootClasses;

public class Boring extends Loot {

    public Boring(Float roll){
        this.Title = "Rubbish";
        this.Description = "Scrap and Detritus found in the corner";
        this.Weight = roll * 2;
    }

}
