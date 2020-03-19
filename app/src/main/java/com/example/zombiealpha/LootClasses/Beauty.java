package com.example.zombiealpha.LootClasses;

public class Beauty extends Loot {
    public Beauty(Float roll) {
        this.Title = "MakeUp";
        this.Description = "Paint on Face";
        this.Weight  = roll/2f;
    }
}
