package com.example.zombiealpha;

import android.os.Parcel;
import android.os.Parcelable;

class Zombie implements Parcelable {
    int Health = 10;
    int damage = 1;

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
