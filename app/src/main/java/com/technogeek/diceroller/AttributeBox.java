package com.technogeek.diceroller;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

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

}
