package com.olabilemez.guesswhat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.SparseLongArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener {
    Button gear;
    TextView  play, instructions, exit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = (TextView) findViewById(R.id.btnPlay);
        instructions = (TextView) findViewById(R.id.btnInstruction);
        exit = (TextView) findViewById(R.id.btnExit);
        gear = (Button) findViewById(R.id.btnGear);
        //ImageView iv = (ImageView) findViewById(R.id.ivLogo);


        play.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/poppyseed.ttf"));
        instructions.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/poppyseed.ttf"));
        exit.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/poppyseed.ttf"));

        play.setOnClickListener(this);
        instructions.setOnClickListener(this);
        exit.setOnClickListener(this);
        gear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnPlay:
                Intent intent = new Intent(MainActivity.this,AdjustmentActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btnInstruction:
                Intent intent1 = new Intent(MainActivity.this,Instructions.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.btnExit:
                MainActivity.this.finish();
                break;
            case R.id.btnGear:
                Toast toast = Toast.makeText(getApplicationContext(),"NANiK", Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
    }
}
