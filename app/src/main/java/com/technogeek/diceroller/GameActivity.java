package com.technogeek.diceroller;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    ImageView diceImage;
    Boolean isHeroTurn = true;
    Random random = new Random();
    String type_Of_Game;
    CharacerClass EnemyObject = new CharacerClass();
    CharacerClass HeroObject = new CharacerClass();
    AttributeBox HealBoxObject = new AttributeBox();
    AttributeBox AttackBoxObject = new AttributeBox();
    List<AttributeBox> list = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setBasicGame();
        createAttributeBox();
        setListenerEvent();
    }
    private void setBasicGame(){
        int id1 = getIntent().getIntExtra("Image_player_1",0);
        int id2 = getIntent().getIntExtra("Image_player_2",0);


        diceImage = findViewById(R.id.dice_image);
        ImageView Enemy_img = findViewById(R.id.enemy);
        TextView textView_p2 = findViewById(R.id.textView_p2);
        EnemyObject.setPosition(1);
        EnemyObject.setImage(Enemy_img);
        EnemyObject.setImageResource(id1);
        EnemyObject.setTextView(textView_p2);

        ImageView Hero_img = findViewById(R.id.hero);
        TextView textView_p1 = findViewById(R.id.textView_p1);
        HeroObject.setPosition(12);
        HeroObject.setImage(Hero_img);
        HeroObject.setImageResource(id2);
        HeroObject.setTextView(textView_p1);
        // get type of game from main Activity
        type_Of_Game = getIntent().getStringExtra("TYPE_OF_GAME");
        //set style
        if(type_Of_Game.equals("vsP")){
            EnemyObject.getTextView().setText("Player 2");
            HeroObject.getTextView().setText("Player 1");
        }else{
            EnemyObject.getTextView().setText("BOT");
            HeroObject.getTextView().setText("Player");
        }
        EnemyObject.getTextView().setTextColor(Color.rgb(18, 204, 59));
        HeroObject.getTextView().setTextColor(Color.rgb(224, 75, 16));

        //set health
        EnemyObject.setHealth(100);
        HeroObject.setHealth(100);

        //set health bar
        drawProgressBar();

        // fix size image
        int dimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 65, getResources().getDisplayMetrics());
        Hero_img.getLayoutParams().height = dimensionInDp;
        Hero_img.getLayoutParams().width = dimensionInDp;
        Hero_img.requestLayout();

        Enemy_img.getLayoutParams().height = dimensionInDp;
        Enemy_img.getLayoutParams().width = dimensionInDp;
        Enemy_img.requestLayout();

        HeroObject.setEnemy(EnemyObject);
        EnemyObject.setEnemy(HeroObject);
    }
    private void setListenerEvent(){
        diceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rotateDice();
            }
        });
    }
    public boolean containsPosition(final List<AttributeBox> list, final int position){
        return list.stream().anyMatch(o -> o.getPositon() == position);
    }
    public void randomAttributeBox(String atrb){
        int position;
        Random random = new Random();
        while(true){
            position = random.nextInt(22)+1;
            //check Home position ?
            if(position == 1 || position == 12) continue;
            //check exist position ?
            if(!containsPosition(list,position)) {
                //create box
                AttributeBox box = new AttributeBox();
                String boxId_str = "box" + position;
                int boxId = getResources().getIdentifier(boxId_str, "id", getPackageName());
                ImageView boxImage = (ImageView) findViewById(boxId);
                int res = getResources().getIdentifier(atrb, "drawable", getPackageName());
                //set box info
                box.setImg(boxImage);
                box.setNameAttribute(atrb);
                box.setPositon(position);
                box.setImageResource(res);
                //add box to list
                list.add(box);
                break;
            }
        }
    }
    public void createAttributeBox(){
        //6 heal box
        for (int hb = 0; hb < 6; hb++){
            randomAttributeBox("heal");
        }
        //10 attack box
        for (int ab = 0; ab < 10; ab++){
            randomAttributeBox("attack");
        }
    }

    private void rotateDice() {
        diceImage.setClickable(false);
        final int i = random.nextInt(6)+1;
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
                            Character.getImage().setRotationY(-180);
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
                            setActionWhenMoveDone(Character);
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
                .x(Character.getImage().getX() )
                .y(Character.getImage().getY() - Character.getImage().getHeight()/(5/2))
                .setDuration(0)
                .start();
    }
    public void setActionWhenMoveDone(CharacerClass character){
        Optional<AttributeBox> tmp =  list.stream().filter(p -> p.getPositon() ==  character.getPosition()).findFirst();
        if(tmp.isPresent()){
                if(tmp.get().getNameAttribute().equals("attack")){
                    character.getEnemy().setHealth(character.getEnemy().getHealth() - 30);
                }else if(tmp.get().getNameAttribute().equals("heal")){
                    character.setHealth(character.getHealth() + 10);
                }
            drawProgressBar();
        }
    }
    public void drawProgressBar(){
        ProgressBar healthBarP1 = findViewById(R.id.progressBar_ph1);
        ProgressBar healthBarP2 = findViewById(R.id.progressBar_ph2);
        //// set color
        healthBarP1.getProgressDrawable().setColorFilter(Color.rgb(217, 20, 33),android.graphics.PorterDuff.Mode.MULTIPLY);
        healthBarP2.getProgressDrawable().setColorFilter(Color.rgb(77, 219, 0),android.graphics.PorterDuff.Mode.MULTIPLY);
        ///set progress = health
        healthBarP1.setProgress(HeroObject.getHealth());
        healthBarP2.setProgress(EnemyObject.getHealth());
   }
}