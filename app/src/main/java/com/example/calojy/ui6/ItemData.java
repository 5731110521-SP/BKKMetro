package com.example.calojy.ui6;

import android.support.v7.app.AppCompatActivity;

public class ItemData extends AppCompatActivity {

    String text;
    Integer imageId;
    public ItemData(String text, Integer imageId){
        this.text=text;
        this.imageId=imageId;
    }

    public String getText(){
        return text;
    }

    public Integer getImageId(){
        return imageId;
    }
}

