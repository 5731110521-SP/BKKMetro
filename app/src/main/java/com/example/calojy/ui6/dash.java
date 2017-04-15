package com.example.calojy.ui6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class dash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);


        findViewById(R.id.menDash).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent menuIntent = new Intent(dash.this, menu.class);
                startActivity(menuIntent);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_left);

            }
        });

    }


}
