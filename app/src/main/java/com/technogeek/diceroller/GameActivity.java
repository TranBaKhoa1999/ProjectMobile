package com.technogeek.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    ImageView diceImage;
    ImageView Enemy_img;
    Random random = new Random();
    EnemyClass EnemyObject = new EnemyClass();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        diceImage = findViewById(R.id.dice_image);
        Enemy_img = findViewById(R.id.enemy);
        EnemyObject.setPosition(1);
        diceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rotateDice();
            }
        });
    }

    private void rotateDice() {
        int i = random.nextInt(5)+1;
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotate);
        diceImage.startAnimation(anim);
        int res = getResources().getIdentifier("dice" + i, "drawable",getPackageName());
        diceImage.setImageResource(res);
        Move(i);
        EnemyObject.setPosition(i + EnemyObject.getPosition() >22? (i +EnemyObject.getPosition() - 22): (i+ EnemyObject.getPosition()));
    }
    public void Move(int step){
        int currentPos = EnemyObject.getPosition();
        for(int i=1;i<=step;i++){
            currentPos = currentPos+1>22? 1 : currentPos+1;
            String Boxid_str = "box"+ currentPos;
            System.out.println(Boxid_str);
            int Boxid = getResources().getIdentifier(Boxid_str, "id", getPackageName());
            ImageView Box = (ImageView) findViewById(Boxid);
        Enemy_img.animate()
                    .x(Box.getX())
                    .y( Box.getY())
                    .setDuration(500)
                    .start();

        }
    }

}