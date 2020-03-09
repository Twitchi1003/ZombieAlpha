package com.example.zombiealpha.LootClasses;

public class Municipal extends Loot {

    public Municipal(Float roll, String type) {

        Float damage;
        Float protection;


        switch(type) {
            case "FIRE_STATION":

                damage = 4 + (roll * 2);

                this.Title = "Fire Axe";
                this.Description = "Old tools for new jobs";
                this.Weight = 2f;

            case "POLICE_STATION":

                protection = 4 + (roll * 2);

                this.Title = "Fire Axe";
                this.Description = "Old tools for new jobs";
                this.Weight = 2f;

        }
    }
}
