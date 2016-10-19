package com.olabilemez.guesswhat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by olabilemez on 3/6/2015.
 */
public class AdjustmentActivity extends Activity implements View.OnClickListener,RadioGroup.OnCheckedChangeListener {

    int digitNum = 3 ;
    TextView start,cancel, chooseDigit, instruction;

    RadioGroup rg;
    RadioButton three, four,five;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);
        start = (TextView) findViewById(R.id.tvStart);
        cancel = (TextView) findViewById(R.id.tvCancel);
        instruction = (TextView) findViewById(R.id.tvInstruction);
        chooseDigit = (TextView) findViewById(R.id.tvChooseDigit);
        start.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/poppyseed.ttf"));
        cancel.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/poppyseed.ttf"));
        chooseDigit.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/poppyseed.ttf"));
        instruction.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/poppyseed.ttf"));

        rg = (RadioGroup) findViewById(R.id.rgRadioGroup);
        three = (RadioButton) findViewById(R.id.rbThree);
        three.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/alittlesunshine.ttf"));
        four = (RadioButton) findViewById(R.id.rbFour);
        five = (RadioButton) findViewById(R.id.rbFive);
        four.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/alittlesunshine.ttf"));
        five.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/alittlesunshine.ttf"));
        rg.setOnCheckedChangeListener(this);


        start.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        Intent intentMain = new Intent(AdjustmentActivity.this, MainActivity.class);
        startActivity(intentMain);
        finish();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rbFive:
                digitNum = 5;
                break;
            case R.id.rbThree:
                digitNum = 3;
                break;
            case R.id.rbFour:
                digitNum = 4;
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvStart:
                Intent intent = new Intent(AdjustmentActivity.this,PlayGame.class);
                Bundle bundle = new Bundle();
                bundle.putInt("digitNumber", digitNum);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
                break;
            case R.id.tvCancel:
                Intent intentMain = new Intent(AdjustmentActivity.this, MainActivity.class);
                startActivity(intentMain);
                finish();
                break;
        }

    }


}
