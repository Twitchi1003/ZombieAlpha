package com.example.zombiealpha.LootClasses;

public class Tool extends Loot {

    public Tool(Float roll) {
        this.Title = "Hammer";
        this.Description = "Both a tool and a defensive item";
        this.Weight = roll * 2;
    }
}
