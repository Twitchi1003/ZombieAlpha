package com.example.zombiealpha.LootClasses;
//TODO several paintings and Statues
public class Art extends Loot {
    public Art(Float roll) {
        this.Title = "One Art";
        this.Description = "Paint on Canvas";
        this.Weight  = roll * 3f;
    }
}
