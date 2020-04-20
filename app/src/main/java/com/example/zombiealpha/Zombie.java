package com.example.zombiealpha;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

class Zombie implements Parcelable {

    int Health;
        public int getHealth() {return Health;}
        public void addHealth(int healing) {Health += healing;}
        public void removeHealth(int damage) {Health -= damage;}
    int damage;
    public int picture; //stores reference INT

    public Zombie() {
            this.Health=3;
            this.damage=1;
            this.picture = R.drawable./*ic_*/temp_zombie;//scalable asset crashes setBackground on ImageView
    }

    //parcels
    protected Zombie(Parcel in) {
        Health = in.readInt();
        damage = in.readInt();
    }

    public static final Creator<Zombie> CREATOR = new Creator<Zombie>() {
        @Override
        public Zombie createFromParcel(Parcel in) {
            return new Zombie(in);
        }

        @Override
        public Zombie[] newArray(int size) {
            return new Zombie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Health);
        dest.writeInt(damage);
    }
}
