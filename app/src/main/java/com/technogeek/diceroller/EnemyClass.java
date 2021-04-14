package com.technogeek.diceroller;

import android.widget.ImageView;

public class EnemyClass {
    ImageView enemy;
    int position; // exp : 3 => box3
    public void setEnemy(ImageView enemy) {
        this.enemy = enemy;
    }

    public ImageView getEnemy() {
        return enemy;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
