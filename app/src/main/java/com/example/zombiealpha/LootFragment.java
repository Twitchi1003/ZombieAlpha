package com.example.zombiealpha;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.zombiealpha.LootClasses.Loot;
import com.google.android.libraries.places.api.model.Place;

import java.util.List;


public class LootFragment extends Fragment {

    private static final String TAG = "Loot Frag Setup";

    private View view;


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
        ViewGroup lootField = view.findViewById(R.id.lootField);
        int  lootSize = types.size();
        for (int i = 0; i < lootSize;i++){

            Place.Type type = types.get(i);

            Loot lootHolder = new Loot();

            final Loot potentialLoot = lootHolder.RollLoot(type);

            final TextView lootView = (TextView) lootField.getChildAt(i);

            try {
                lootView.setText(potentialLoot.Title);
                lootView.setVisibility(View.VISIBLE);
                lootView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (potentialLoot.Title.equals("Empty")){
                            makeToast("Nothing There");
                        } else
                        {
                            addLoot(potentialLoot);
                            lootView.setText("Empty");
                        }

                    }
                });
            }
            catch (Exception e){
                Log.e(TAG,"Oh Noe " + e);
                break;
            }

        }

        return view;
    }


    private void addLoot(Loot loot){
        ((CharacterSheet) this.getActivity().getApplication()).addToInv(loot);
        makeToast(loot.Title + "Added to inv");
    }


    private void makeToast(String words) {
        Toast.makeText(getActivity(), words, Toast.LENGTH_SHORT).show();
    }
}
