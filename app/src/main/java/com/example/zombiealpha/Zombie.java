package com.example.zombiealpha;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

class Zombie implements Parcelable {
    int Health = 10;
    int damage = 1;
    Image picture; //not parceled?

    public Zombie() {

    }

    //parcel stuff


    protected Zombie(Parcel in) {
        Health = in.readInt();
        damage = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Health);
        dest.writeInt(damage);
    }

    @Override
    public int describeContents() {
        return 0;
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
}
