package com.olabilemez.guesswhat;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by olabilemez on 2/22/2015.
 */
public class PlayGame extends Activity implements View.OnClickListener {
    private int digit;
    private int pcNumber;
    ScrollView sv;
    int modeMe = 0;
    int tryCounter = 0;
    int[] linearLayouts = new int[3] ;
    int[] zeros = new int[2];
    Bundle bundle = new Bundle();
    ArrayList<Integer> allGuesses = new ArrayList<Integer>();

    boolean minusEver = true;
    boolean plusEver = true;


    String toBeShown = new String("");
    TextView numberShown , tryNumber;
    Button one, two, three ;
    Button four, five, six, seven, eight, nine ;
    Button tell, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_game);
        initialize();
        zeros[0] = 0;
        digit = getIntent().getExtras().getInt("digitNumber");
        pcNumber = DistinctNumberedInteger.randomizeDifferent(digit);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnOne:
                if (toBeShown.length()<digit) {
                    toBeShown += "1";
                    numberShown.setText(toBeShown);
                }
                break;
            case R.id.btnTwo:
                if (toBeShown.length()<digit) {
                    toBeShown += "2";
                    numberShown.setText(toBeShown);
                }
                break;
            case R.id.btnThree:
                if (toBeShown.length()<digit) {
                    toBeShown += "3";
                    numberShown.setText(toBeShown);
                }
                break;
            case R.id.btnFour:
                if (toBeShown.length()<digit) {
                    toBeShown += "4";
                    numberShown.setText(toBeShown);
                }
                break;
            case R.id.btnFive:
                if (toBeShown.length()<digit) {
                    toBeShown += "5";
                    numberShown.setText(toBeShown);
                }
                break;
            case R.id.btnSix:
                if (toBeShown.length()<digit) {
                    toBeShown += "6";
                    numberShown.setText(toBeShown);
                }
                break;
            case R.id.btnSeven:
                if (toBeShown.length()<digit) {
                    toBeShown += "7";
                    numberShown.setText(toBeShown);
                }
                break;
            case R.id.btnEight:
                if (toBeShown.length()<digit) {
                    toBeShown += "8";
                    numberShown.setText(toBeShown);
                }
                break;
            case R.id.btnNine:
                if (toBeShown.length()<digit) {
                    toBeShown += "9";
                    numberShown.setText(toBeShown);
                }
                break;
            case R.id.btnDelete:
                if(! toBeShown.equals("")){
                    toBeShown = toBeShown.substring(0,toBeShown.length()-1);
                    numberShown.setText(toBeShown);
                }
                break;
            case R.id.btnTell:
                if(digit != numberShown.getText().length()) {
                    Toast toast = Toast.makeText(getApplicationContext(),"Not Accurate Length" ,Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(unwantedConditions(numberShown.getText().toString())){
                    tryNumber.setText( Integer.toString(++tryCounter) );
                    answerToPlayer(numberShown.getText().toString());
                    numberShown.setText("");
                }
                break;

        }
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(PlayGame.this,AdjustmentActivity.class);
        startActivity(intent);
        finish();
    }

    private boolean unwantedConditions(String playerGuess) {
        if (!DistinctNumberedInteger.isDistinct(playerGuess)){
            Toast toast = Toast.makeText(getApplicationContext(),"Your Number Has Not Distinct Numbers",Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
        for (int i = 0 ; i < allGuesses.size(); i++){
            if(playerGuess.equals(Integer.toString(allGuesses.get(i)))){
                Toast toast = Toast.makeText(getApplicationContext(),"You Entered This Before", Toast.LENGTH_SHORT);
                toast.show();
                return false;
            }
        }
        return true;
    }

    public void answerToPlayer(String playerGuess){
        boolean isMatched = false;

        allGuesses.add(Integer.parseInt(playerGuess));

        String pcNum = new String(Integer.toString(pcNumber));
        String toBeSent = new String(playerGuess + "\n");
        int pluses = 0 ;
        int minuses = 0 ;

        for(int i = 0 ; i < digit ; i++){
            for(int j = 0 ; j < digit ; j++){
                if(playerGuess.charAt(i) == pcNum.charAt(j)){
                    if(i == j){
                        pluses++;
                        minusEver = false;
                    }
                    else{
                        minuses++;
                        plusEver = false;
                    }
                    isMatched = true;
                }
            }
        }
        if(isMatched){
            for (int i = 0 ; i < pluses ; i++) {
                toBeSent += "+";
            }
            for (int i = 0 ; i < minuses ; i++) {
                toBeSent += "-";
            }
        }
        else if (!isMatched) {
            toBeSent += "0";
            zeros[0]++;
            zeros[1] = tryCounter;
        }

        createNewTextView(toBeSent);
        toBeShown = "";
        sv.post(new Runnable() {
            @Override
            public void run() {
                sv.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });



        if (pluses == digit){
            Intent intent = new Intent(PlayGame.this, FinalActivity.class);
            bundle.putInt("counter",tryCounter);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        }

    }


    //@TargetApi(Build.VERSION_CODES.KITKAT)
    private void createNewTextView(String toBeSent) {

        LinearLayout ll = (LinearLayout) findViewById(linearLayouts[modeMe%3]);
        TextView tv = new TextView(this);
        tv.setText(toBeSent);
        tv.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        //tv.setBackgroundResource(R.drawable.textviewshape);
        tv.setTextColor(Color.BLACK);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        params.setMargins(10,5,0,10);
        tv.setLayoutParams(params);
        tv.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/alittlesunshine.ttf"));
        tv.setTextColor(Color.BLACK);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
        ll.addView(tv);

        modeMe++;

    }

    private void initialize() {

        one = (Button) findViewById(R.id.btnOne);
        two = (Button) findViewById(R.id.btnTwo);
        three = (Button) findViewById(R.id.btnThree);
        four = (Button) findViewById(R.id.btnFour);
        five = (Button) findViewById(R.id.btnFive);
        six = (Button) findViewById(R.id.btnSix);
        seven = (Button) findViewById(R.id.btnSeven);
        eight = (Button) findViewById(R.id.btnEight);
        nine = (Button) findViewById(R.id.btnNine);
        tell = (Button) findViewById(R.id.btnTell);
        delete = (Button) findViewById(R.id.btnDelete);

        numberShown = (TextView) findViewById(R.id.tvNumberToBeShown);
        tryNumber = (TextView) findViewById(R.id.tvTryNumber);

        numberShown.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/alittlesunshine.ttf"));
        tryNumber.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/alittlesunshine.ttf"));


        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        tell.setOnClickListener(this);
        delete.setOnClickListener(this);

        linearLayouts[0] = R.id.llLinear0;
        linearLayouts[1] = R.id.llLinear1;
        linearLayouts[2] = R.id.llLinear2;

        sv = (ScrollView) findViewById(R.id.svScroll);


    }



}

