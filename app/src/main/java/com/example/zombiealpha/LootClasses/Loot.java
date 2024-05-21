package com.example.zombiealpha.LootClasses;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.zombiealpha.interfaces.Use;
import com.google.android.libraries.places.api.model.Place;

public class Loot implements Use {
    private static final String TAG = "Loot Class";

    public String Title; //Name but name is a bad var name :P
    public String Description;
    float Weight;
    public int pic;

//        this.Title = "Name";
//        this.Description = "Some words that relate to the appearance";
//        this.Weight = roll * 10;

    public Boolean use(){
        return false;
    };


    public Loot(){
        this.Title = "Empty";
        this.Description = "Nothing to be found";
        this.Weight = 9000f;
        //pic = emptyBox
    }


    public static Loot RollLoot(Place.Type type){
        Loot result;
        float roll = (float)Math.random();
        String tableName;


        switch(type){
//Standard or undefined
            case ESTABLISHMENT:
            case POINT_OF_INTEREST:
            case DEPARTMENT_STORE:
            case FLORIST:
            case GYM:
            case LIGHT_RAIL_STATION:
            case MOVING_COMPANY:
            case PAINTER:
            case PARK:
            case SHOPPING_MALL:
            case STORAGE:
            case STORE:
            case SUBWAY_STATION:
            case TRAIN_STATION:
            case TRANSIT_STATION:
            case AQUARIUM:
                if (roll>0.5){
                    result = new Boring(roll);
                    return result;}
//animal Loots
            case VETERINARY_CARE:
            case ZOO:
                if (roll>0.5){
                    result = new Animal(roll);
                    return result;}
//Planes
            case AIRPORT:
                    if (roll>0.5){
                    result = new Aviation(roll);
                    return result;}
//Basic Food
            case CAFE:
            case CONVENIENCE_STORE:
            case GROCERY_OR_SUPERMARKET:
            case MEAL_DELIVERY:
            case MEAL_TAKEAWAY:
            case PET_STORE:
            case RESTAURANT:
            case SUPERMARKET:
            case FOOD:
                if (roll>0.5){
                    result = new Food(roll,"gen");
                    return result;}
//specific food bloc
            case AMUSEMENT_PARK:
            case STADIUM:
            case TOURIST_ATTRACTION:
                if (roll>0.5){
                    result = new Food(roll,"park");
                    return result;}

            case MOVIE_RENTAL:
            case MOVIE_THEATER:
                if (roll>0.5){
                    result = new Food(roll,"movie");
                    return result;}

            case BAKERY:
                if (roll>0.5){
                    result = new Food(roll,"bakery");
                    return result;}

            case BAR:
            case LIQUOR_STORE:
            case NIGHT_CLUB:
                if (roll>0.5) {
                    result = new Alcohol(roll);
                    return result;}
//Cars and stuff
            case GAS_STATION:
            case BUS_STATION:
            case CAR_DEALER:
            case CAR_REPAIR:
            case CAR_RENTAL:
            case CAR_WASH:
            case PARKING:
            case RV_PARK:
            case TAXI_STAND:
                if (roll>0.5){
                    result = new Automotive(roll, type.toString());
                    return result;}

            case BICYCLE_STORE:
            case HARDWARE_STORE:
            case HOME_GOODS_STORE:
            case LOCKSMITH:
            case PLUMBER:
            case ROOFING_CONTRACTOR:
                if (roll>0.5){
                    result = new Tool(roll);
                    return result;}

            case FIRE_STATION:
            case POLICE:
                if (roll>0.5){
                    result = new Municipal(roll,type.toString());
                    return result;}

            case ART_GALLERY:
                if (roll>0.5){
                    result = new Art(roll);
                    return result;}

            case ATM:
            case BANK:
            case CASINO:
                if (roll>0.5){
                    result = new Money(roll);
                    return result;}

            case BEAUTY_SALON:
            case HAIR_CARE:
            case SPA:
                if (roll>0.5){
                    result = new Beauty(roll);
                    return result;}

            case BOWLING_ALLEY:
                if (roll>0.5){
                    result = new Bowling(roll);
                    return result;}

            case CAMPGROUND:
                if (roll>0.5){
                    result = new Camping(roll);
                    return result;}

            case CEMETERY:
            case CHURCH:
            case HINDU_TEMPLE:
            case MOSQUE:
            case SYNAGOGUE:
                if (roll>0.5){
                    result = new Religious(roll,type);
                    return result;}

            case CITY_HALL:
            case COURTHOUSE:
            case EMBASSY:
            case FUNERAL_HOME:
            case INSURANCE_AGENCY:
            case LAWYER:
            case LOCAL_GOVERNMENT_OFFICE:
            case POST_BOX:
            case POST_OFFICE:
            case REAL_ESTATE_AGENCY:
            case TRAVEL_AGENCY:
                if (roll>0.5){
                    result = new PaperWork(roll);
                    return result;}

            case CLOTHING_STORE:
            case LAUNDRY:
            case LODGING:
            case SHOE_STORE:
                if (roll>0.5){
                    result = new Clothing(roll,type);
                    return result;}

            case DENTIST:
            case DOCTOR:
            case DRUGSTORE:
            case HOSPITAL:
            case PHARMACY:
            case PHYSIOTHERAPIST:
                if (roll>0.5){
                    result = new Medical(roll);
                    return result;}

            case ELECTRICIAN:
            case ELECTRONICS_STORE:
                if (roll>0.5){
                    result = new Electrics(roll);
                    return result;}

            case FURNITURE_STORE:
                if (roll>0.5){
                    result = new Furniture(roll);
                    return result;}

            case JEWELRY_STORE:
                if (roll>0.5){
                    result = new Jewelry(roll);
                    return result;}

            case BOOK_STORE:
            case LIBRARY:
            case MUSEUM:
            case PRIMARY_SCHOOL:
            case SCHOOL:
            case SECONDARY_SCHOOL:
            case UNIVERSITY:
                if (roll>0.5){
                    result = new Education(roll);
                    return result;}
                result = new Loot();
                return result;
            default:
                tableName = type + " is Broken";
                Log.e(TAG,"Problem With Loot Table assignment : " + tableName);
        }
        result = new Loot();
        return result;
    }

    @Override
    public boolean use(Context c, Loot loot) {
        if (loot != null){
            //needs gravity and dressing, maybe random selecting of responses
            Toast.makeText(c,"There is nothing I can do with this",Toast.LENGTH_SHORT);
            return false;
        } else {
            Toast.makeText(c,"Button Broken, Item Null",Toast.LENGTH_SHORT);
            return false;
        }

    }
}



