package com.example.zombiealpha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

    //open inv
        Button toInv = findViewById(R.id.buttonMapToInv);
        toInv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PlayerInv.class);
                view.getContext().startActivity(intent);}
        });

    //alpha give player stuff buttons
        Button GiveFood = findViewById(R.id.GiveFood);
        GiveFood.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                                giveFood();
                                        }
                                    }

        );



    }

    private void giveFood(){
        Food foundFood = new Food();
        ((CharacterSheet) this.getApplication()).addToInv(foundFood);

    }
}
