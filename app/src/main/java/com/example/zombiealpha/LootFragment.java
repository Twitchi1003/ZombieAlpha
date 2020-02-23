package com.example.zombiealpha;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.google.android.libraries.places.api.model.Place;

import java.util.List;


public class LootFragment extends Fragment implements View.OnClickListener {

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.loot_fragment,container,false);

        //Header
        TextView title = view.findViewById(R.id.lootHeader);
        String locName = this.getArguments().getString("bName");
        title.setText(locName);

        //loots
        PlaceDataHolder incoming = this.getArguments().getParcelable("bPlace");
        List<Place.Type> types = incoming.getTypes();
        ViewGroup lootField = view.findViewById(R.id.lootFeild);
        int  lootSize = types.size();
        for (int i = 0; i < lootSize;i++){

            String name = types.get(i).toString();
            Place.Type type = types.get(i);

            switch(type){
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
                    name = "Default";
                    break;
                case VETERINARY_CARE:
                case ZOO:
                    name = "Animal";
                    break;
                case AIRPORT:
                    name = "Aviation";
                    break;
                case AMUSEMENT_PARK:
                case STADIUM:
                case TOURIST_ATTRACTION:
                    name = "Park Snack";
                    break;
                case MOVIE_RENTAL:
                case MOVIE_THEATER:
                    name = "Movie Snacks";
                    break;
                case AQUARIUM:
                    name = "Fish";
                    break;
                case ART_GALLERY:
                    name = "Art";
                    break;
                case ATM:
                case BANK:
                case CASINO:
                    name = "Money";
                    break;
                case BAKERY:
                    name = "Bakery";
                    break;
                case BAR:
                case LIQUOR_STORE:
                case NIGHT_CLUB:
                    name = "Alcohol";
                    break;
                case BEAUTY_SALON:
                case HAIR_CARE:
                case SPA:
                    name = "Beauty Salon";
                    break;
                case BUS_STATION:
                case CAR_DEALER:
                case CAR_REPAIR:
                case CAR_RENTAL:
                case CAR_WASH:
                case PARKING:
                case RV_PARK:
                case TAXI_STAND:
                    name = "Automotive";
                    break;
                case BICYCLE_STORE:
                case HARDWARE_STORE:
                case HOME_GOODS_STORE:
                case LOCKSMITH:
                case PLUMBER:
                case ROOFING_CONTRACTOR:
                    name = "Tools";
                    break;
                case BOOK_STORE:
                case LIBRARY:
                    name= "Books";
                    break;
                case BOWLING_ALLEY:
                    name = "Bowling_Alley";
                    break;
                case CAFE:
                case CONVENIENCE_STORE:
                case GROCERY_OR_SUPERMARKET:
                case MEAL_DELIVERY:
                case MEAL_TAKEAWAY:
                case PET_STORE:
                case RESTAURANT:
                case SUPERMARKET:
                    name = "Gen Food";
                    break;
                case CAMPGROUND:
                    name = "Camping";
                    break;
                case CEMETERY:
                case CHURCH:
                case HINDU_TEMPLE:
                case MOSQUE:
                case SYNAGOGUE:
                    name = "Religious";
                    break;
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
                    name = "Office Paperwork";
                    break;
                case CLOTHING_STORE:
                case LAUNDRY:
                case LODGING:
                case SHOE_STORE:
                    name = "Clothing";
                    break;
                case DENTIST:
                case DOCTOR:
                case DRUGSTORE:
                case HOSPITAL:
                case PHARMACY:
                case PHYSIOTHERAPIST:
                    name = "Medical";
                    break;
                case ELECTRICIAN:
                case ELECTRONICS_STORE:
                    name = "electrics";
                    break;
                case FIRE_STATION:
                    name = "Fire Station";
                    break;
                case POLICE:
                    name = "Police";
                    break;
                case FURNITURE_STORE:
                    name = "Furniture";
                    break;
                case GAS_STATION:
                    name = "Petrol";
                    break;
                case JEWELRY_STORE:
                    name = "Jewels";
                    break;
                case MUSEUM:
                case PRIMARY_SCHOOL:
                case SCHOOL:
                case SECONDARY_SCHOOL:
                case UNIVERSITY:
                    name = "Education";
                    break;
            }


            TextView lootView = (TextView) lootField.getChildAt(i);
            lootView.setText(name);
            lootView.setVisibility(View.VISIBLE);

        }







        Button done = view.findViewById(R.id.but_finLoot);
        done.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {

    }


    private void makeToast(String words) {
        Toast.makeText(getActivity(), words, Toast.LENGTH_SHORT).show();
    }
}
