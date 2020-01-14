package com.example.zombiealpha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayerInv extends AppCompatActivity {


    private int Health = 0;
    private int BodyTemp = 0;
    private int Calories = 0;
    private int Thirst = 0;
    private ArrayList<Item> Inv;

    private RecyclerView InventoryRecycler;
    private RecyclerView.Adapter InvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_inv);

        //Grab Stats from global CharacterSheet
        TextView PlayerHealth = findViewById(R.id.healthDisplay);
        Health = ((CharacterSheet) this.getApplication()).getHealth();
        PlayerHealth.setText(Integer.toString(Health));

        TextView PlayerTemp = findViewById(R.id.tempratureDisplay);
        BodyTemp =  ((CharacterSheet) this.getApplication()).getBodyTemp();
        PlayerTemp.setText(Integer.toString(BodyTemp));

        TextView PlayerCalories = findViewById(R.id.calorieDisplay);
        Calories =  ((CharacterSheet) this.getApplication()).getCalories();
        PlayerCalories.setText(Integer.toString(Calories));

        TextView PlayerThirst = findViewById(R.id.thirstDisplay);
        Thirst =  ((CharacterSheet) this.getApplication()).getThirst();
        PlayerThirst.setText(Integer.toString(Thirst));



        Inv = (ArrayList<Item>) ((CharacterSheet) this.getApplication()).getInventory();
        //Inv is player inventory.. need to get into adapter

        RecyclerView InventoryRecycler = findViewById(R.id.InventoryRecyclerView);
        InventoryRecycler.setLayoutManager(new LinearLayoutManager(this));
        InvAdapter = new InventoryAdaptor(Inv,this);
        InventoryRecycler.setAdapter(InvAdapter);



        //Navigation Buttons
        Button InvToMap = findViewById(R.id.ButtonInvToMap);
        InvToMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Map.class);
                view.getContext().startActivity(intent);}
        });

    }
}
