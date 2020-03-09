package com.example.zombiealpha.LootClasses;

public class Camping extends Loot {
    public Camping(Float roll) {
        this.Title = "Tent";
        this.Description = "Keep warm at night, hide from Zombies";
        this.Weight = roll * 10;
    }
}
