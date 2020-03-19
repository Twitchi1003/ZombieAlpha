package com.example.zombiealpha.LootClasses;

public class Bowling extends Loot {
    public Bowling(Float roll) {
        this.Title = "Bowling Pin";
        this.Description = "To bash your balls against";
        this.Weight  = roll * 7f;
    }
}
