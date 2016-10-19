package com.olabilemez.guesswhat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by olabilemez on 3/6/2015.
 */
public class FinalActivity extends Activity implements View.OnClickListener{

    TextView playAgain,exit, cong,ach ;
    int move;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalpage);
        playAgain = (TextView) findViewById(R.id.tvPlayAgain);
        exit = (TextView) findViewById(R.id.tvExitGame);
        cong = (TextView) findViewById(R.id.tvCong);
        ach = (TextView) findViewById(R.id.tvAchievement);

        move = getIntent().getExtras().getInt("counter");

        if(move != 1) {
            ach.setText("You've finished with " +
                    move +
                    " moves!");
        }
        else {
            cong.setText("");
            String[] strings = new String[6];
            strings[0] = "This is awesome!\nJust one move!";
            strings[1] = "How did you do thaat!!";
            strings[2] = "You have talent baby!";
            strings[3] = "Extraordinary lad! Just One shot!";
            strings[4] = "MARVELLOUS!\nJust one try ha!";
            strings[5] = "You gotta be kiddin' me!";

            Random random = new Random();
            ach.setText(strings[random.nextInt(6)]);

        }
        cong.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/poppyseed.ttf"));
        playAgain.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/poppyseed.ttf"));
        exit.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/poppyseed.ttf"));
        ach.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/poppyseed.ttf"));


        playAgain.setOnClickListener(this);
        exit.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(FinalActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvExitGame:
                finish();
                break;
            case R.id.tvPlayAgain:
                Intent intent = new Intent(FinalActivity.this,AdjustmentActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
