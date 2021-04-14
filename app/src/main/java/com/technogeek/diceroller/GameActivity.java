package com.technogeek.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    ImageView diceImage;
    Boolean isHeroTurn = false;
    Random random = new Random();
    CharacerClass EnemyObject = new CharacerClass();
    CharacerClass HeroObject = new CharacerClass();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setBasicGame();
        setListenerEvent();
    }
    private void setBasicGame(){
        diceImage = findViewById(R.id.dice_image);
        ImageView Enemy_img = findViewById(R.id.enemy);

        EnemyObject.setPosition(1);
        EnemyObject.setImage(Enemy_img);

        ImageView Hero_img = findViewById(R.id.hero);
        HeroObject.setPosition(12);
        HeroObject.setImage(Hero_img);

    }
    private void setListenerEvent(){
        diceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rotateDice();
            }
        });
    }
    private void rotateDice() {
        diceImage.setClickable(false);
        int i = random.nextInt(5)+1;
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotate);
        diceImage.startAnimation(anim);
        int res = getResources().getIdentifier("dice" + i, "drawable",getPackageName());
        diceImage.setImageResource(res);
        if(isHeroTurn ==false){
            Move(i,EnemyObject);
        }else{
            Move(i,HeroObject);
        }
        isHeroTurn= isHeroTurn==false?true:false;
    }
    public void Move(int step, final CharacerClass Character){
        final int[]s = {step};
        int currentPos = Character.getPosition();
        currentPos = currentPos+1>22? 1 : currentPos+1;
        String Boxid_str = "box"+ currentPos;
        System.out.println(Boxid_str);
        int Boxid = getResources().getIdentifier(Boxid_str, "id", getPackageName());
        ImageView Box = (ImageView) findViewById(Boxid);
        final int finalCurrentPos = currentPos;
        Character.getImage().animate()
                .x(Box.getX())
                .y( Box.getY())
                .setDuration(300)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        if(finalCurrentPos == 12){
                            Character.getImage().setRotationY(-190);
                        }
                        if(finalCurrentPos == 21){
                            Character.getImage().setRotationY(0);
                        }
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Character.setPosition(1 + Character.getPosition() >22? (1 +Character.getPosition() - 22): (1+ Character.getPosition()));
                        s[0]--;
                        if(s[0]>0) {
                            Move(s[0],Character);
                        }else{
                            diceImage.setClickable(true);
                        }
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                })
                .start();
    }

}