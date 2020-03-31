package com.example.zombiealpha;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Random;

public class CombatFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.combat_fragment, container, false);

        final Zombie zombie = this.getArguments().getParcelable("bZombie");


        TextView Title = view.findViewById(R.id.CombatFragmentTitle);
        ImageView zombiePicture = view.findViewById(R.id.combatPicture);

        ImageButton fightButton = view.findViewById(R.id.fightButton);
        ImageButton itemButton = view.findViewById(R.id.inventoryButton);
        ImageButton runButton = view.findViewById(R.id.escapeButton);//needs new character sheet value, last inventory item.. for picture

        if (surprise()) {zombieTurn();}

        fightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeToast("Hit it");
                //check for weapon in hand
                //attack roll
                //damage
                if (zombie.Health > 0){
                    zombieTurn();
                }
            }
        });

        itemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeToast("Bag Click");
                //check for item in equip slot
                //if no item open inventory panel
                //voodoo that uses item
                //if z=dead do winscreen()
                if (zombie.Health > 0){
                    zombieTurn();
                }
            }
        });

        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeToast("Cheese it!");
                //make escape roll
                //if escape winscreen(escape) else
                if (zombie.Health > 0){
                    zombieTurn();
                }
            }
        });


        return view;
    }

    private void zombieTurn() {
        makeToast("GrrrrrrgggG" +
                "Arrrrrrg");
    }

    private boolean surprise() {
        Random rng = new Random();
        int roll = rng.nextInt(11);
        int threshold = rng.nextInt(5);
        //add modifiers here
        if (roll > threshold) {return true;} else {return false;}

    }

    private void makeToast(String words) {

        Toast.makeText(this.getContext(), words, Toast.LENGTH_SHORT).show();



    }
}
