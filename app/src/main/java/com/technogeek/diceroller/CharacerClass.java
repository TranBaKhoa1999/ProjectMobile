package com.technogeek.diceroller;

import android.widget.ImageView;
import android.widget.TextView;

public class CharacerClass {
    ImageView Image;
    int position; // exp : 3 => box3
    int Health;
    TextView textView;
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

    public int getHealth() {
        return Health;
    }
    public void setHealth(int health) {
        Health = health;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }
}
