package com.example.calojy.ui6;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class addMoney extends AppCompatActivity {

   public static int money=100;
   Spinner sp1;
   EditText mon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_money);

        mon=(EditText) findViewById(R.id.money);
        findViewById(R.id.minus).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(money==100) money=100;
                else money-=100;
                mon.setText(String.valueOf(money));
            }
        });
        findViewById(R.id.plus).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(money==2000) money=2000;
                else money+=100;
                mon.setText(String.valueOf(money));
            }
        });

        sp1=(Spinner)findViewById(R.id.spinner1);
        ArrayList<ItemData> list=new ArrayList<>();
        list.add(new ItemData("Choose Bank",R.drawable.iconbank0));
        list.add(new ItemData("Krugsi",R.drawable.iconbank1));
        list.add(new ItemData("TMB",R.drawable.iconbank2));
        list.add(new ItemData("Krugtep",R.drawable.iconbank3));
        list.add(new ItemData("Kasikorn",R.drawable.iconbank4));
        list.add(new ItemData("Krugthai",R.drawable.iconbank5));
        list.add(new ItemData("Thaipanit",R.drawable.iconbank6));

        SimpleImageArrayAdapter adapter=new SimpleImageArrayAdapter(this,
                R.layout.spinner_layout,R.id.txt,list);
        sp1.setAdapter(adapter);

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                DialogBox("ยืนยันการเติมเงินจำนวน "+money+" บาท");
            }
        });

        findViewById(R.id.cancleG).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent dash = new Intent(addMoney.this, dash.class);
                startActivity(dash);

            }
        });

        findViewById(R.id.menAdd).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent menuIntent = new Intent(addMoney.this, menu.class);
                startActivity(menuIntent);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_left);
            }
        });

    }//end onCreate

    private void DialogBox(String mes){
        AlertDialog alertDialog=new AlertDialog.Builder(this).create();
        alertDialog.setTitle("");
        alertDialog.setMessage(mes);
        alertDialog.setButton("ตกลง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //user.setBalance(money+User.getBalance());
                Intent dash = new Intent(addMoney.this, splip.class);
                startActivity(dash);
            }
        });
        alertDialog.show();
    }
}
