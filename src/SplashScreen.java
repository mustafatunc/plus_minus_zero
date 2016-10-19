package com.olabilemez.guesswhat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by olabilemez on 3/1/2015.
 */
public class SplashScreen extends Activity {
    TextView tv;
    String logo;
    String cont;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        logo = new String("PLUS\nMINUS\nZERO");
        cont = new String("");
        tv = (TextView) findViewById(R.id.tvSplashLogo);
        tv.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/poppyseed.ttf"));
        tv.setText(logo);
        animation = AnimationUtils.loadAnimation(this,R.anim.animation);
        tv.startAnimation(animation);

        Thread timer = new Thread(){
            @Override
            public void run() {

                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timer.start();

    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();

    }

}
