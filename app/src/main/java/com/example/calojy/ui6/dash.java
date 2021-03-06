package com.example.calojy.ui6;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class dash extends AppCompatActivity {

    private int status = 0;
    public static TextView setBalance;
    private trip trip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);

        setBalance = (TextView) findViewById(R.id.money);
        dash.setBalance.setText(String.valueOf(passengerList.currentUser.getBalance()));

        TextView tvday = (TextView)findViewById(R.id.day);
        tvday.setText(Integer.toString(passengerList.currentUser.getDay()));

        TextView dayex = (TextView)findViewById(R.id.textView7);
        if(passengerList.currentUser.getDay()>0){
            dayex.setText("วันสุดท้าย "+passengerList.currentUser.getDayex());
        }else{
            dayex.setText("-");
        }


        ImageView activity= (ImageView) findViewById(R.id.activate);
        findViewById(R.id.menDash).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent menuIntent = new Intent(dash.this, menu.class);
                startActivity(menuIntent);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_left);

            }
        });

        findViewById(R.id.activate).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //activity.setImageResource(R.drawable.activatewaitbut);
                //activity.setBackgroundDrawable(R.drawable.activatewaitbut);
                if(status==0 && passengerList.currentUser.getBalance()<16 && passengerList.currentUser.getDay()==0){
                    AlertDialog.Builder builder = new AlertDialog.Builder(dash.this);
                    builder.setMessage("เงินไม่เพียงพอ");
                    builder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which){
                        }
                    });
                    builder.show();
                }else if(status==0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(dash.this);
                    builder.setMessage("กรุณาเข้าสู่ระบบภายใน 2 นาที");
                    builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            ImageView activity= (ImageView) findViewById(R.id.activate);
                            activity.setBackground(getResources().getDrawable(R.drawable.activatewaitbut));
                            status=1;
                        }
                    });
                    builder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which){
                        }
                    });
                    builder.show();
                }else if(status==1){
                    trip=new trip();
                        ImageView activity= (ImageView) findViewById(R.id.activate);
                        activity.setBackground(getResources().getDrawable(R.drawable.travelingbut));
                        status=2;

                }else if(status==2){
                    AlertDialog.Builder builder = new AlertDialog.Builder(dash.this);
                    builder.setMessage("กรุณาเออกจากระบบภายใน 2 นาที");
                    builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            ImageView activity= (ImageView) findViewById(R.id.activate);
                            activity.setBackground(getResources().getDrawable(R.drawable.travelingwaitbut));
                            status=3;
                        }
                    });
                    builder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which){
                        }
                    });
                    builder.show();
                }else{
                    ImageView activity= (ImageView) findViewById(R.id.activate);
                    activity.setBackground(getResources().getDrawable(R.drawable.activatebut));
                    if(passengerList.currentUser.getDay()==0){
                        passengerList.currentUser.setBalance(passengerList.currentUser.getBalance()-42);
                        trip.checkout();
                        passengerList.currentUser.addTrip(trip);
                    }else{
                        trip=new trip(0);
                        passengerList.currentUser.addTrip(trip);
                    }
                    status=0;
                    dash.setBalance.setText(String.valueOf(passengerList.currentUser.getBalance()));
                }

            }


        });

    }
}
