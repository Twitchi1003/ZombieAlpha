package com.example.zombiealpha.LootClasses;

public class Animal extends Loot {

    public Animal(float roll){
        //rare:ketamine,
        // animal pelts, animal food
        if (roll > 0.5){
            this.Title = "Pelts";
            this.Description = "One side is soft.. It's best you don't look at the other side";
            this.Weight = roll;
        }
    }
}
