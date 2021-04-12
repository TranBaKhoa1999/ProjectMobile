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

public class HomeActivity extends AppCompatActivity {

    ImageView diceImage;
    ImageView X;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        diceImage = findViewById(R.id.dice_image);
        X = findViewById(R.id.X);
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
    }
    public void Move(int i){
//        ObjectAnimator animX = ObjectAnimator.ofFloat(X, "x",);
//        ObjectAnimator animY = ObjectAnimator.ofFloat(X, "y", 134);
//        AnimatorSet animSetXY = new AnimatorSet();
//        animSetXY.playTogether(animX, animY);
//        animSetXY.start();
    }

}