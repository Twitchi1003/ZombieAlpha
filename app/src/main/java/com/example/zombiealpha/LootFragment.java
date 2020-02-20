package com.example.zombiealpha;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
            //find lootview + i; roll on lootTable(type[i]); Display result;
            //If i !null set view visable






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
