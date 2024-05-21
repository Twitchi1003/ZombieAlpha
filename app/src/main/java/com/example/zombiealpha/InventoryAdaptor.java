package com.example.zombiealpha;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zombiealpha.LootClasses.Loot;

import java.util.ArrayList;

public class InventoryAdaptor extends RecyclerView.Adapter<InventoryAdaptor.InventoryViewHolder> {

    private ArrayList<Loot> Inventory;
    private Context context;

    InventoryAdaptor(ArrayList<Loot> _inventory, Context _context) {
        Inventory = _inventory;
        this.context = _context;
    }

    @NonNull
    @Override
    public InventoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create holder Variable view and pass in "inflated" layout (inventory_recycler_layout)
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inventory_recycler_layout, parent,false);
        return new InventoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull InventoryViewHolder holder, int position) {
        Loot item =  Inventory.get(position);

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



            AlertDialog.Builder invDialog = new AlertDialog.Builder(context);
            invDialog.setTitle("Inventory");
            invDialog.setMessage("use v to get item name");
            invDialog.setCancelable(true);
            invDialog.setPositiveButton("use", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
//                    Toast.makeText(context, "Implementation is next", Toast.LENGTH_SHORT).show();
                    int pos = getLayoutPosition();
                    Loot offender = ((CharacterSheet) context.getApplicationContext()).getSingleInv(pos);

                    //get cals from offender, Add cals to player, remove offender from INV,remove poss from recycler
                    //maybe need to do loot.use() and have use defined in items
                }
            });
            invDialog.setNegativeButton("Drop", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    int pos = getLayoutPosition();
                    Loot offender = Inventory.get(pos);
                    ((CharacterSheet) context.getApplicationContext()).removeFromInv(offender);
                    notifyItemRemoved(pos);
                }
            });
            AlertDialog alertDialog = invDialog.create();
            alertDialog.show();

            return true;
        }
    }
}
