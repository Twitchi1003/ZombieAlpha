package com.example.zombiealpha;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
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

import com.example.zombiealpha.LootClasses.Loot;
import com.example.zombiealpha.LootClasses.Weapon;

import java.util.Random;

public class CombatFragment extends Fragment {

    Random rng = new Random();

    private SoundPool soundPool;
    private int blurg;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.combat_fragment, container, false);

        final Zombie zombie = this.getArguments().getParcelable("bZombie");


        TextView Title = view.findViewById(R.id.CombatFragmentTitle);
        final ImageView zombiePicture = view.findViewById(R.id.combatPicture);

        ImageButton fightButton = view.findViewById(R.id.fightButton);
        ImageButton itemButton = view.findViewById(R.id.inventoryButton);
        ImageButton runButton = view.findViewById(R.id.escapeButton);//needs new character sheet value, last inventory item.. for picture


        zombiePicture.setBackground(getResources().getDrawable(zombie.picture));

        /* This is a check for what is in hand.. so we can put correct picture on attack button */

        Weapon mainHand = ((Weapon) getEquippedHand());//note: method in THIS class
        if (mainHand == null){
                   mainHand = new Weapon();
                   mainHand.Title = "Fist";
                   mainHand.Description = "Bare Knuckles are back in fashion";
                   mainHand.pic = R.drawable.temp_fist;
                   mainHand.damage = 1;
        }
        fightButton.setBackground(getResources().getDrawable(mainHand.pic));

        Loot pocket = getPocketItem();
        if (pocket != null){
            itemButton.setBackground(getResources().getDrawable(pocket.pic)); //if item equipped set button image, if not leave as default backpack
        }

        //sound
        if (Build.VERSION.SDK_INT >=  Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            soundPool = new SoundPool.Builder()
                            .setMaxStreams(3)
                            .setAudioAttributes(audioAttributes)
                            .build();
        } else {
            soundPool = new SoundPool(3, AudioManager.STREAM_NOTIFICATION, 0);
        }

        blurg = soundPool.load(getActivity(),R.raw.blurg, 1);








        //COMBAT LOGIC
        soundPool.play(blurg,1,1,0,0,1);

        if (surprise()) {zombieTurn(zombie);}

        final Weapon finalMainHand = mainHand;

        fightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int attackRoll = rng.nextInt(11);

                int dodge = rng.nextInt(9);
                if (attackRoll > dodge){

                    Runnable posReturn = new Runnable() {
                        public void run()
                        {
                            zombiePicture.animate().translationYBy(30f).setDuration(100).start();
                        }
                    };
                    zombiePicture.animate().translationYBy(-30f).setDuration(100).withEndAction(posReturn);

                    zombie.removeHealth(finalMainHand.damage);
                    if (zombie.getHealth() < 0){
                        winscreen();
                    }
                    soundPool.play(blurg,1,1,0,0,1);
                }
                else {
                    if (zombie.Health > 0) {
                        zombieTurn(zombie);
                        soundPool.play(blurg,1,1,0,0,1);
                    }
                }
            }
        });

        itemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeToast("Bag Click, Not implemented");
                //check for item in equip slot
                //if no item open inventory panel
                //voodoo that uses item
                //if z=dead do winscreen()
                if (zombie.Health > 0){
                    zombieTurn(zombie);
                }
            }
        });

        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeToast("Cheese it!");
                int roll = rng.nextInt(11);
                int threshold = rng.nextInt(9);//maybe tie to time since last rest?
                if (roll > threshold){winscreen();}
                    else {
                    if (zombie.Health > 0) {
                        zombieTurn(zombie);
                        soundPool.play(blurg,1,1,0,0,1);
                    }
                }
            }
        });


        return view;
    }



    private Loot getEquippedHand() {
        CharacterSheet sheet = (CharacterSheet)getActivity().getApplicationContext();
        Loot hand = sheet.getHand();
        return hand;
    }

    private Loot getPocketItem(){
        CharacterSheet sheet = (CharacterSheet)getActivity().getApplicationContext();
        Loot pocket = sheet.getPocket();
        return pocket;
    }

    private void zombieTurn(Zombie zombie) {
        /*makeToast("GrrrrrrgggG" +
                "Arrrrrrg");*/
        int roll = rng.nextInt(11);
        int threshold = rng.nextInt(2);
        if (roll > threshold) {
            CharacterSheet sheet = (CharacterSheet)getActivity().getApplicationContext();
            sheet.removeHealth(zombie.damage);

            if (sheet.getHealth() <= 0) {
                makeToast("Your Dead!");
                //real implementation to come
            }
        }

    }

    private boolean surprise() {

        int roll = rng.nextInt(11);
        int threshold = rng.nextInt(5);
        //add modifiers here
        return roll > threshold;

    }


    private void winscreen() {
        //make new  fragment?
        getActivity().onBackPressed();//brutal

    }

    private void makeToast(String words) {
        Toast.makeText(this.getContext(), words, Toast.LENGTH_SHORT).show();
    }
}
