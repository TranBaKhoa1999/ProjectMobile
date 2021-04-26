package com.technogeek.diceroller;

import android.widget.ImageView;

public class AttributeBox {
    ImageView img;
    int positon;
    int imgWid = 129;
    int imgHei = 129;

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView src) {
        this.img = src;
    }

    public int getPositon() {
        return positon;
    }

    public void setPositon(int id) {
        this.positon = id;
    }

    public int getImgWid() {
        return imgWid;
    }

    public void setImgWid(int imgWid) {
        this.imgWid = imgWid;
    }

    public int getImgHei() {
        return imgHei;
    }

    public void setImgHei(int imgHei) {
        this.imgHei = imgHei;
    }

    public void setImageResource(int id){
        this.img.setImageResource(id);
    }

    public boolean isHome (int i){
        if (i == 1 || i == 12) {return true;}
        return false;
    }

    public  boolean checkPosition(int i){
        if (i == positon){ return true;}
        return false;
    }
}
