package com.example.zombiealpha.LootClasses;

public class Medical extends Loot {
    int Healing;

    public Medical(Float Roll) {
        this.Title = "Paracetamol";
        this.Description = "Mild Painkillers";
        this.Weight = 0.1f;
        this.Healing = 10;
    }
}
