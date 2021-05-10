package com.technogeek.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button pvspButton;
    private  Button pvsbotButton;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private  void initSharedPreferences(){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        pvspButton = findViewById(R.id.pvspbutton);
        pvsbotButton = findViewById(R.id.pvsbotbutton);
        pvspButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity("vsP");
            }
        });
        pvsbotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity("vsBOT");
            }
        });

    }
    public void changeActivity(String type) { // 1 pvsp , 2 pvsbot
        Intent intent = new Intent(MainActivity.this, SelectCharacterActivity.class);
        intent.putExtra("TYPE_OF_GAME",type);
        startActivity(intent);
    }

    public void exit(View view) {
        finish();
        System.exit(0);
    }
}