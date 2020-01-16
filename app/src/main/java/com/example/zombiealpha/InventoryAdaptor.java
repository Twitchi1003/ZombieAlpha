package com.example.zombiealpha;

import android.content.Context;
import android.media.Image;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class InventoryAdaptor extends RecyclerView.Adapter<InventoryAdaptor.InventoryViewHolder> {

    private ArrayList<Item> Inventory;
    private Context context;

    InventoryAdaptor(ArrayList<Item> _inventory, Context _context) {
        Inventory = _inventory;
        this.context = _context;
    }

    @NonNull
    @Override
    public InventoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create holder Variable view and pass in "inflated" layout (inventorylayout)
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inventorylayout, parent,false);
        return new InventoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull InventoryViewHolder holder, int position) {
        Item item =  Inventory.get(position);

        holder.TitleText.setText(item.Title);
        holder.DescriptionText.setText(item.Description);

    }

    @Override
    public int getItemCount() {
        return Inventory.size();
    }

    public class InventoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        ImageView ItemIcon;
        TextView TitleText;
        TextView DescriptionText;


        InventoryViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnLongClickListener(this);
            ItemIcon = itemView.findViewById(R.id.InventoryItemIcon);
            TitleText = itemView.findViewById(R.id.InvTitle);
            DescriptionText = itemView.findViewById(R.id.InvDescription);
        }

        @Override
        public void onClick(View v) {
            //do a select thing here.. out lne view or something
        }

        @Override
        public boolean onLongClick(View v) {
            int  pos  = getLayoutPosition();
            Item offender = Inventory.get(pos);
            ((CharacterSheet) context.getApplicationContext()).removeFromInv(offender);
            notifyItemRemoved(pos);
            return true;
        }
    }



}
