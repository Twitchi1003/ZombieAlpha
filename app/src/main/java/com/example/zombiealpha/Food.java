package com.example.zombiealpha;

public class Food extends Item {


    float HPRegen = 0f;
    float Duration = 60f;


    public Food() {

        this.Title = "Sawdust";
        this.Description = "Waste Product From The Lumber Industry";
        this.Weight = 0.1f;
    }

    public Food(float regen, float duration){

        this.HPRegen = regen;
        this.Duration = duration;
        this.Title = "Magic Apple";
        this.Description = "Mythic healing Fruit";
        this.Weight = 0.3f;
    }
}
