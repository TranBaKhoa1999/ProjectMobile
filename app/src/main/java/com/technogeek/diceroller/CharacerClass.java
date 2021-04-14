package com.technogeek.diceroller;

import android.widget.ImageView;

public class CharacerClass {
    ImageView Image;
    int position; // exp : 3 => box3
    public void setImage(ImageView enemy) {
        this.Image = enemy;
    }

    public ImageView getImage() {
        return Image;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
