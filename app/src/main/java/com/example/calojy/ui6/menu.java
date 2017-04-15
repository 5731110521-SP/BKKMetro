package com.example.calojy.ui6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        findViewById(R.id.toAcc).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent log = new Intent(menu.this,dash.class);
                startActivity(log);
            }
        });
        findViewById(R.id.toAdd).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent add = new Intent(menu.this,addMoney.class);
                startActivity(add);
            }
        });

        findViewById(R.id.toSumm).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent log = new Intent(menu.this,login.class);
                startActivity(log);
            }
        });

        findViewById(R.id.toOut).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent log = new Intent(menu.this,viewBankAccount.class);
                startActivity(log);
                /*Intent i = new Intent(menu.this, login.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);*/
            }
        });

        findViewById(R.id.menuClose).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
               finish();
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_left);

            }
        });
    }//end onCreate
}
