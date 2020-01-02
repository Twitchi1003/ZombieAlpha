package com.example.zombiealpha;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class CharacterSheet extends Application {

    //stats

    private int Health = 10;

        public int getHealth() {
        return Health;
    }

        public void setHealth(int health) {
        Health = health;
    }

    private int BodyTemp = 36;

        public int getBodyTemp() {
        return BodyTemp;
    }

        public void setBodyTemp(int bodyTemp) {
        BodyTemp = bodyTemp;
    }

    private int Calories = 2000;

        public int getCalories() {
        return Calories;
    }

        public void setCalories(int calories) {
        Calories = calories;
    }

    private int Thirst = 100;

        public int getThirst() {
        return Thirst;
    }

        public void setThirst(int thirst) {
        Thirst = thirst;
    }

    private int TodaysNoise = 0;

        public int getTodaysNoise() {
        return TodaysNoise;
    }

        public void setTodaysNoise(int todaysNoise) {
        TodaysNoise = todaysNoise;
    }



    //inventory

    List<Item> Inventory = new ArrayList<Item>();

        public List<Item> getInventory() {
            return Inventory;
            }

        public void addToInv(Item Item){
            Inventory.add(Item);
        }

        public void removeItem(Item item){
            Inventory.remove(item);
        }
}
