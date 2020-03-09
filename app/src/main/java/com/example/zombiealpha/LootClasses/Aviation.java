package com.example.zombiealpha.LootClasses;

public class Aviation extends Loot {

    //suitcase, backpack, tiny drinks bottles, fuel, clothes,

    public Aviation(float roll){
        this.Title = "SuitCase";
        this.Description = "This doesn't do what you want it to... Yet";
        this.Weight = roll * 10;
    }

}
