package com.example.zombiealpha;

import android.app.Application;

import com.example.zombiealpha.LootClasses.Loot;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class CharacterSheet extends Application {

    //stats

    private int Health = 10;
        public int getHealth() {return Health;}
        public void addHealth(int healing) {Health += healing;}
        public void removeHealth(int damage) {Health -= damage;}


    private int BodyTemp = 36;
        public int getBodyTemp() {return BodyTemp;}
        public void addBodyTemp(int heating) {BodyTemp += heating;}
        public void removeBodyTemp(int cooling) {BodyTemp -= cooling;}

    private float Calories = 2000;
        public float getCalories() {return Calories;}
        public void addCalories(float calories) {Calories += calories;}
        public void removeCalories(float calories) {Calories -= calories;}


    private int Thirst = 100;
        public int getThirst() {return Thirst;}
        public void addThirst(int thirst) {Thirst += thirst;}
        public void removeThirst(int thirst) {Thirst -= thirst;}



    private int TodaysNoise = 0;

        public void setTodaysNoise(int todaysNoise) {TodaysNoise = todaysNoise;}//dev only

        public int getTodaysNoise() {return TodaysNoise;}
        public void addNoise (int noise) {TodaysNoise = TodaysNoise + noise;}
        public void removeNoise (int noise) {TodaysNoise = TodaysNoise - noise;}



    //inventory

    List<Loot> Inventory = new ArrayList<>();

        public List<Loot> getInventory() {return Inventory;}
        public void addToInv(Loot Item){Inventory.add(Item);}
        public void removeFromInv(Loot item){Inventory.remove(item);}
        public Loot getSingleInv (int Index){return Inventory.get(Index);}

    private Loot Hand;
         public Loot getHand() {return Hand;}
         public void setHand(Loot loot){Hand = loot;}

    private Loot Pocket;
         public Loot getPocket() {return Pocket;}
         public void setPocket(Loot loot){Pocket = loot;}


    //Time stamps
    private HashMap<String, Date> coolDowns = new HashMap<>();

        public HashMap GetAllCoolDowns() { return coolDowns; } //dev only

        public Date GetCoolDown(String poi) {return coolDowns.get(poi);}
        public Date SetCoolDown(String poi, Date date) {return coolDowns.put(poi, date);}

        //public Date putIfAbsent(PointOfInterest poi, Date current) { return coolDowns.putIfAbsent(poi,current); } //this is to new for my phone


}
