package com.example.zombiealpha.LootClasses;

import android.widget.Toast;

import com.example.zombiealpha.MainActivity;



public class Boring extends Loot {

    public Boring(Float roll){
        this.Title = "Rubbish";
        this.Description = "Scrap and Detritus found in the corner";
        this.Weight = roll * 2;
    }

    @Override
    public Boolean use() {
        return false;
    }
}
