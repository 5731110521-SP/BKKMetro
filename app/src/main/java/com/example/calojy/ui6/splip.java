package com.example.calojy.ui6;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splip extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splip);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent dashIntent = new Intent(splip.this, dash.class);
                startActivity(dashIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}
