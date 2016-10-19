package com.olabilemez.guesswhat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.nfc.tech.IsoDep;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

/**
 * Created by olabilemez on 8/2/2015.
 */
public class Instructions extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructions);
        TextView text, back;
        text = (TextView) findViewById(R.id.tvText);
        back = (TextView) findViewById(R.id.tvBack);

        text.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/alittlesunshine.ttf"));
        back.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/poppyseed.ttf"));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Instructions.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Instructions.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
