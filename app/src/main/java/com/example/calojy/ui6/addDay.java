package com.example.calojy.ui6;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class addDay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_day);

        findViewById(R.id.menuinchaddday).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent menuIntent = new Intent(addDay.this, menu.class);
                startActivity(menuIntent);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_left);
            }
        });

        findViewById(R.id.add1).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //120
                if(passengerList.currentUser.getDay()>0){
                    showDialogDay();
                } else if(passengerList.currentUser.getBalance()<120){
                    showDialogMoney();
                }else{
                    passengerList.currentUser.setBalance(passengerList.currentUser.getBalance()-120);
                    passengerList.currentUser.setDay(1);
                    passengerList.currentUser.addTrip(new trip(120));
                    Intent menuIntent = new Intent(addDay.this, menu.class);
                    menuIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(menuIntent);
                }
            }
        });

        findViewById(R.id.add3).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                //230
                if(passengerList.currentUser.getDay()>0){
                    showDialogDay();
                } else if(passengerList.currentUser.getBalance()<230){
                    showDialogMoney();
                }else{
                    passengerList.currentUser.setBalance(passengerList.currentUser.getBalance()-230);
                    passengerList.currentUser.setDay(3);
                    passengerList.currentUser.addTrip(new trip(230));
                    Intent menuIntent = new Intent(addDay.this, menu.class);
                    menuIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(menuIntent);
                }
            }
        });

        findViewById(R.id.add30).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                //1400
                if(passengerList.currentUser.getDay()>0){
                    showDialogDay();
                } else if(passengerList.currentUser.getBalance()<1400){
                    showDialogMoney();
                }else{
                    passengerList.currentUser.setBalance(passengerList.currentUser.getBalance()-1400);
                    passengerList.currentUser.setDay(30);
                    passengerList.currentUser.addTrip(new trip(1400));
                    Intent menuIntent = new Intent(addDay.this, menu.class);
                    menuIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(menuIntent);
                }
            }
        });
    }

    private void showDialogMoney() {
        AlertDialog.Builder builder = new AlertDialog.Builder(addDay.this);
        builder.setMessage("จำนวนเงินไม่เพียงพอ");
        builder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which){
                finish();
            }
        });

        builder.show();
    }

    private void showDialogDay() {
        AlertDialog.Builder builder = new AlertDialog.Builder(addDay.this);
        builder.setMessage("ไม่สามารถเดิมได้ ตั๋วเก่ายังไม่หมดอายุ");
        builder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which){
                finish();
            }
        });
        builder.show();
    }
}
