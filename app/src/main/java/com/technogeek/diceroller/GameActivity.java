package com.technogeek.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    ImageView diceImage;
    Boolean isHeroTurn = true;
    Random random = new Random();
    String type_Of_Game;
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
        TextView textView_p2 = findViewById(R.id.textView_p2);
        EnemyObject.setPosition(1);
        EnemyObject.setImage(Enemy_img);
        EnemyObject.setTextView(textView_p2);

        ImageView Hero_img = findViewById(R.id.hero);
        TextView textView_p1 = findViewById(R.id.textView_p1);
        HeroObject.setPosition(12);
        HeroObject.setImage(Hero_img);
        HeroObject.setTextView(textView_p1);
        // get type of game from main Activity
        type_Of_Game = getIntent().getStringExtra("TYPE_OF_GAME");
        //set style
        EnemyObject.getTextView().setText("Khoa péo");
        EnemyObject.getTextView().setTextColor(Color.rgb(18, 204, 59));

        HeroObject.getTextView().setText("Khoa khoai to");
        HeroObject.getTextView().setTextColor(Color.rgb(224, 75, 16));
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
        final int i = random.nextInt(5)+1;
        final Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotate);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                int res = getResources().getIdentifier("dice" + i, "drawable",getPackageName()); // change dot in dice
                diceImage.setImageResource(res);
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                if(isHeroTurn ==false){
                    Move(i,EnemyObject);
                }else{
                    Move(i,HeroObject);
                }
                isHeroTurn= isHeroTurn==false?true:false;
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        diceImage.startAnimation(anim);
    }
    public void Move(int step, final CharacerClass Character){
        final int[]s = {step};
        int currentPos = Character.getPosition();
        currentPos = currentPos+1>22? 1 : currentPos+1;
        String Boxid_str = "box"+ currentPos;
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
                        ChangePostitionHead(Character);
                        Character.setPosition(1 + Character.getPosition() >22? (1 +Character.getPosition() - 22): (1+ Character.getPosition()));
                        s[0]--;
                        if(s[0]>0) {
                            Move(s[0],Character);
                        }else{
                            if(type_Of_Game.equals("vsBOT") && isHeroTurn==false){
                                rotateDice();
                            }else{
                                diceImage.setClickable(true);
                            }

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

    public void CloseActivity(View view) {
        onBackPressed();
    }
    public void ChangePostitionHead(CharacerClass Character){
        Character.getTextView().animate()
                .x(Character.getImage().getX())
                .y(Character.getImage().getY())
                .setDuration(0)
                .start();
    }
}