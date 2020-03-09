package com.example.zombiealpha.LootClasses;

public class Education extends Loot {
    String Subject;
    //make subject = roll based some how

    public Education(Float roll) {
        this.Title = "Book";
        this.Description = "Plant matter, pulped and compressed";
        this.Weight = roll * 2;
        this.Subject = "Fiction";
    }
}
