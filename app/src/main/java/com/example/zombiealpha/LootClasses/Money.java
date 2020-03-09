package com.example.zombiealpha.LootClasses;

public class Money extends Loot {

    private Float Ballance;

    public Money(Float roll) {
        this.Ballance = roll*100;
        this.Title = "Small Stack of BankNotes";
        this.Description = "Its used to be everything.. now  its worthless";
        this.Weight  = roll;}
}
