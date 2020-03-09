package com.example.zombiealpha.LootClasses;

public class Furniture extends Loot {
    public Furniture(Float roll) {
        this.Title = "Side Table";
        this.Description = "Some day this will hold stuff";
        this.Weight = roll * 10f;
    }
}
