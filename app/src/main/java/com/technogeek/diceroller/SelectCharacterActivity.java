package com.technogeek.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class SelectCharacterActivity extends AppCompatActivity {
    ImageView player1, player2, char1, char2, char3, char4, char5, char6, char7, char8;
    TextView info1, info2;
    Button btnSelect, btnPlay;
    int flag = 0, choose;
    String type_Of_Game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_character);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setGameInfo();
        setListenerEvent();
    }
    private void setGameInfo(){
        info1 = findViewById(R.id.textView1);
        info2 = findViewById(R.id.textView2);
        player1 = findViewById(R.id.imageViewPlayer1);
        player2 = findViewById(R.id.imageViewPlayer2);
        char1 = findViewById(R.id.char1Image);
        char2 = findViewById(R.id.char2Image);
        char3 = findViewById(R.id.char3Image);
        char4 = findViewById(R.id.char4Image);
        char5 = findViewById(R.id.char5Image);
        char6 = findViewById(R.id.char6Image);
        char7 = findViewById(R.id.char7Image);
        char8 = findViewById(R.id.char8Image);
        btnSelect = findViewById(R.id.buttonSelectCharacter);
        btnPlay = findViewById(R.id.buttonPlay);
        type_Of_Game = getIntent().getStringExtra("TYPE_OF_GAME");
        if(type_Of_Game.equalsIgnoreCase("vsP")){
            info1.setText("PLAYER 1");
            info2.setText("PLAYER 2");
        } else {
            info1.setText("PLAYER");
            info2.setText("BOT");
        }
    }
    private  void setListenerEvent(){
        player1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type_Of_Game.equalsIgnoreCase("vsP")) {
                    Toast.makeText(getApplicationContext(), "Select character for player 1", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(getApplicationContext(), "Select character for player", Toast.LENGTH_SHORT).show();
                }
                flag = 1;
            }
        });
        player2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type_Of_Game.equalsIgnoreCase("vsP")) {
                    Toast.makeText(getApplicationContext(), "Select character for player 2", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(getApplicationContext(), "Select character for bot", Toast.LENGTH_SHORT).show();
                }
                flag = 2;

            }
        });
        char1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose = getResources().getIdentifier("char" + 1,"drawable", getPackageName());
                if(flag == 0){
                    Toast.makeText(getApplicationContext(), "Please select who you want to set character",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Warrior", Toast.LENGTH_SHORT).show();
                }
            }
        });
        char2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose = getResources().getIdentifier("char" + 2,"drawable", getPackageName());
                if(flag==0){
                    Toast.makeText(getApplicationContext(), "Please select who you want to set character",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Priest", Toast.LENGTH_SHORT).show();
                }
            }
        });
        char3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose = getResources().getIdentifier("char" + 3,"drawable", getPackageName());
                if(flag==0){
                    Toast.makeText(getApplicationContext(), "Please select who you want to set character",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Archer", Toast.LENGTH_SHORT).show();
                }
            }
        });
        char4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose = getResources().getIdentifier("char" + 4,"drawable", getPackageName());
                if(flag==0){
                    Toast.makeText(getApplicationContext(), "Please select who you want to set character",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Thief", Toast.LENGTH_SHORT).show();
                }
            }
        });
        char5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose = getResources().getIdentifier("char" + 5,"drawable", getPackageName());
                if(flag==0){
                    Toast.makeText(getApplicationContext(), "Please select who you want to set character",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Assasin", Toast.LENGTH_SHORT).show();
                }
            }
        });
        char6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose = getResources().getIdentifier("char" + 6,"drawable", getPackageName());
                if(flag==0){
                    Toast.makeText(getApplicationContext(), "Please select who you want to set character",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Hunter", Toast.LENGTH_SHORT).show();
                }
            }
        });
        char7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose = getResources().getIdentifier("char" + 7,"drawable", getPackageName());
                if(flag ==0){
                    Toast.makeText(getApplicationContext(), "Please select who you want to set character",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Death Knight", Toast.LENGTH_SHORT).show();
                }
            }
        });
        char8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose = getResources().getIdentifier("char" + 8,"drawable", getPackageName());
                if(flag==0){
                    Toast.makeText(getApplicationContext(), "Please select who you want to set character",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Berserker", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag == 1){
                    player1.setImageResource(choose);
                    if(type_Of_Game.equalsIgnoreCase("vsP")) {
                        Toast.makeText(getApplicationContext(), "You have chosen character for player 1", Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(getApplicationContext(), "You have chosen character for player", Toast.LENGTH_SHORT).show();
                    }
                    flag = 0;
                } else if(flag == 2){
                    player2.setImageResource(choose);
                    if(type_Of_Game.equalsIgnoreCase("vsP")) {
                        Toast.makeText(getApplicationContext(), "You have chosen character for player 2", Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(getApplicationContext(), "You have chosen character for bot", Toast.LENGTH_SHORT).show();
                    }
                    flag = 0;
                } else{
                    Toast.makeText(getApplicationContext(), "Please select who you want to set character",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(type_Of_Game);
            }
        });
    }
    public void CloseActivity(View view) {
        onBackPressed();
    }

    public void changeActivity(String type) { // 1 pvsp , 2 pvsbot
        Intent intent = new Intent(SelectCharacterActivity.this, GameActivity.class);
        intent.putExtra("TYPE_OF_GAME",type);
        startActivity(intent);
    }
}