package com.technogeek.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

public class SelectCharacterActivity extends AppCompatActivity {
    public ImageView player1, player2, char1, char2, char3, char4, char5, char6, char7, char8;
    public Button btnSelect;
    public HorizontalScrollView charPool;
    public int flag = 0, choose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_character);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
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
        charPool = findViewById(R.id.scrollViewCharacter);
        player1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Select character for player 1",Toast.LENGTH_SHORT).show();
                flag = 1;
            }
        });
        player2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Select character for player 2",Toast.LENGTH_SHORT).show();
                flag = 2;

            }
        });
        char1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose = getResources().getIdentifier("char" + 1,"drawable", getPackageName());
                Toast.makeText(getApplicationContext(), "Warrior",Toast.LENGTH_SHORT).show();
            }
        });
        char2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose = getResources().getIdentifier("char" + 2,"drawable", getPackageName());
                Toast.makeText(getApplicationContext(), "Priest",Toast.LENGTH_SHORT).show();
            }
        });
        char3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose = getResources().getIdentifier("char" + 3,"drawable", getPackageName());
                Toast.makeText(getApplicationContext(), "Archer",Toast.LENGTH_SHORT).show();
            }
        });
        char4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose = getResources().getIdentifier("char" + 4,"drawable", getPackageName());
                Toast.makeText(getApplicationContext(), "Thief",Toast.LENGTH_SHORT).show();
            }
        });
        char5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose = getResources().getIdentifier("char" + 5,"drawable", getPackageName());
                Toast.makeText(getApplicationContext(), "Assasin",Toast.LENGTH_SHORT).show();
            }
        });
        char6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose = getResources().getIdentifier("char" + 6,"drawable", getPackageName());
                Toast.makeText(getApplicationContext(), "Hunter",Toast.LENGTH_SHORT).show();
            }
        });
        char7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose = getResources().getIdentifier("char" + 7,"drawable", getPackageName());
                Toast.makeText(getApplicationContext(), "Death Knight",Toast.LENGTH_SHORT).show();
            }
        });
        char8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose = getResources().getIdentifier("char" + 8,"drawable", getPackageName());
                Toast.makeText(getApplicationContext(), "Berserker",Toast.LENGTH_SHORT).show();
            }
        });
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag == 1){
                    player1.setImageResource(choose);
                    Toast.makeText(getApplicationContext(), "You have chosen character for player 1",Toast.LENGTH_SHORT).show();
                    flag = 0;
                } else if(flag == 2){
                    player2.setImageResource(choose);
                    Toast.makeText(getApplicationContext(), "You have chosen character for player 2",Toast.LENGTH_SHORT).show();
                    flag = 0;
                } else{
                    Toast.makeText(getApplicationContext(), "Please select player to set character",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    public void CloseActivity(View view) {
        onBackPressed();
    }
}