package com.example.calojy.ui6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class chooseAdd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_add);

        findViewById(R.id.menuinchadd).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent menuIntent = new Intent(chooseAdd.this, menu.class);
                startActivity(menuIntent);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_left);
            }
        });

        findViewById(R.id.addnormal).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent menuIntent = new Intent(chooseAdd.this, addMoney.class);
                startActivity(menuIntent);
            }
        });

        findViewById(R.id.addday).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent menuIntent = new Intent(chooseAdd.this, addDay.class);
                startActivity(menuIntent);
                finish();
            }
        });

    }
}
