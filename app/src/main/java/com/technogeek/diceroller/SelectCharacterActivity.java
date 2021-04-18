package com.technogeek.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.media.Image;
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
    int choose1,choose2;
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
        choose1 = getResources().getIdentifier("char" + 1,"drawable", getPackageName());
        choose2 = getResources().getIdentifier("char" + 2,"drawable", getPackageName());
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
            info1.setText("PLAYER 2");
            info2.setText("PLAYER 1");
        } else {
            info1.setText("BOT");
            info2.setText("PLAYER");
        }
    }
    private  void setListenerEvent(){
        player1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hightPlayer(player1);
                flag = 1;
            }
        });
        player2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hightPlayer(player2);
                flag = 2;

            }
        });
        char1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highLightImage(char1);
                choose = getResources().getIdentifier("char" + 1,"drawable", getPackageName());
            }
        });
        char2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highLightImage(char2);
                choose = getResources().getIdentifier("char" + 2,"drawable", getPackageName());
            }
        });
        char3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highLightImage(char3);
                choose = getResources().getIdentifier("char" + 3,"drawable", getPackageName());
            }
        });
        char4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highLightImage(char4);
                choose = getResources().getIdentifier("char" + 4,"drawable", getPackageName());
            }
        });
        char5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highLightImage(char5);
                choose = getResources().getIdentifier("char" + 5,"drawable", getPackageName());
            }
        });
        char6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highLightImage(char6);
                choose = getResources().getIdentifier("char" + 6,"drawable", getPackageName());
            }
        });
        char7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highLightImage(char7);
                choose = getResources().getIdentifier("char" + 7,"drawable", getPackageName());
            }
        });
        char8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highLightImage(char8);
                choose = getResources().getIdentifier("char" + 8,"drawable", getPackageName());
            }
        });
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1.setBackgroundResource(0);
                player2.setBackgroundResource(0);
                if(flag == 1){
                    player1.setImageResource(choose);
                    choose1 = choose;
                    flag = 0;
                } else if(flag == 2){
                    player2.setImageResource(choose);
                    choose2 = choose;
                    flag = 0;
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
        intent.putExtra("Image_player_1",choose1);
        intent.putExtra("Image_player_2",choose2);
        startActivity(intent);
    }
    public void highLightImage(ImageView _this){
        char1.setBackgroundResource(0);
        char2.setBackgroundResource(0);
        char3.setBackgroundResource(0);
        char4.setBackgroundResource(0);
        char5.setBackgroundResource(0);
        char6.setBackgroundResource(0);
        char7.setBackgroundResource(0);
        char8.setBackgroundResource(0);
        GradientDrawable gd = new GradientDrawable();
        gd.setColor(0xFF00FF00); // Changes this drawbale to use a single color instead of a gradient
        _this.setBackgroundDrawable(gd);
    }
    public void hightPlayer(ImageView _this){
        player1.setBackgroundResource(0);
        player2.setBackgroundResource(0);

        GradientDrawable gd = new GradientDrawable();
        gd.setColor(Color.rgb(43, 31, 153)); // Changes this drawbale to use a single color instead of a gradient
        _this.setBackgroundDrawable(gd);
    }
}