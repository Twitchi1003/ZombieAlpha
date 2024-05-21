package com.example.zombiealpha;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Date;

public class POIFragment extends Fragment {

    private TextView poiName;
    private TextView poiCoolDownStatus;
    private ImageView poiDisplay;
    private Button lootButton;
    private Button exitButton;

    private String placeName;

    public static POIFragment newInstance(String placeName) {
        POIFragment fragment = new POIFragment();
        Bundle args = new Bundle();
        args.putString("placeName", placeName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            placeName = getArguments().getString("placeName");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.poi_fragment, container, false);

        poiName = view.findViewById(R.id.text_poi_title);
        poiCoolDownStatus = view.findViewById(R.id.poi_cooldown_status);
        poiDisplay = view.findViewById(R.id.poi_display);
        lootButton = view.findViewById(R.id.loot_button);
        exitButton = view.findViewById(R.id.exit_button);

        poiName.setText(placeName);
        checkCooldownStatus();

        lootButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initiateLooting();
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeFragment();
            }
        });

        return view;
    }

    private void checkCooldownStatus() {
        Date lastLootTime = ((CharacterSheet) getActivity().getApplication()).GetCoolDown(placeName);
        if (lastLootTime == null || (new Date().getTime() - lastLootTime.getTime()) > 86400000) { // 24 hours in milliseconds
            poiCoolDownStatus.setText("You have not been here today");
        } else {
            poiCoolDownStatus.setText("You have been here recently");
        }
    }

    private void initiateLooting() {
        // Prepare arguments for LootFragment
        PlaceDataHolder placeDataHolder = new PlaceDataHolder(); // Fetch the actual PlaceDataHolder
        Bundle args = new Bundle();
        args.putString("bName", placeName);
        args.putParcelable("bPlace", placeDataHolder);

        LootFragment lootFragment = new LootFragment();
        lootFragment.setArguments(args);

        // Use the support fragment manager
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, lootFragment); // Replace with your container ID
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void closeFragment() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.popBackStack();
    }
}
