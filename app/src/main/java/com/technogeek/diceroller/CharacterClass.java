package com.technogeek.diceroller;

import android.widget.ImageView;
import android.widget.TextView;

public class CharacterClass {
    ImageView Image;
    int position; // exp : 3 => box3
    int Health;
    TextView textView;
    int imageWidth = 65;
    int imageHeight  = 66;
    CharacterClass Enemy;

    public void setEnemy(CharacterClass enemy) {
        Enemy = enemy;
    }

    public CharacterClass getEnemy() {
        return Enemy;
    }

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

    public void setImageResource(int id){
        this.Image.setImageResource(id);
    }

}
