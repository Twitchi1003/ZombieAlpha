package com.example.zombiealpha.LootClasses;

import android.content.Context;

import com.example.zombiealpha.interfaces.Use;

public class Food extends Loot implements Use {


    float calRegen = 0f;
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
                this.calRegen = 500f;
            case "movie":
                this.Title = "PopCorn";
                this.Description = "Sad, stale and salted";
                this.Weight = roll;
                this.calRegen = 250f;
            case "bakery":
                this.Title = "Bread Roll";
                this.Description = "Both hard AND soggy";
                this.Weight = roll;
                this.calRegen = 350f;
            default:
                this.Title = "Dried Noodle";
                this.Description = "If only you had the spit to process this";
                this.Weight = roll;
                this.calRegen = 200f;
        }
    }

//    @Override
//    public boolean use(Context c, Loot l){
//        //check if loot food, get calRegen, add cals to player, remove loot from inventory, retrun true
//
//        if()
//        return false;
//    }
}
