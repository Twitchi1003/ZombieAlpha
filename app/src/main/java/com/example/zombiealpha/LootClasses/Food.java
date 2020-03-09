package com.example.zombiealpha.LootClasses;

public class Food extends Loot {


    float HPRegen = 0f;
    float Duration = 60f;


    public Food() {

        this.Title = "Sawdust";
        this.Description = "Waste Product From The Lumber Industry";
        this.Weight = 0.1f;
    }

    public Food(float roll, String type){

        switch(type){
            //needs gen
            case "park":
                this.Title = "HotDog";
                this.Description = "Both words in the name are a lie";
                this.Weight = roll;
            case "movie":
                this.Title = "PopCorn";
                this.Description = "Sad, stale and salted";
                this.Weight = roll;
            case "bakery":
                this.Title = "Bread Roll";
                this.Description = "Both hard AND soggy";
                this.Weight = roll;
            default:
                this.Title = "Dried Noodle";
                this.Description = "If only you had the spit to process this";
                this.Weight = roll;
        }

    }



    public Food(float regen, float duration){

        this.HPRegen = regen;
        this.Duration = duration;
        this.Title = "Magic Apple";
        this.Description = "Mythic healing Fruit";
        this.Weight = 0.3f;
    }
}
