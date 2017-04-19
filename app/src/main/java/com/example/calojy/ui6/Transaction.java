package com.example.calojy.ui6;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Transaction extends Activity {
    ListView list,list2,list3;

    private static String[] item = {"เติมเงิน","ชำระค่าโดยสาร"};
    private static String[] item2 = {"                                ","                    "};
    private static String[] item3 = {"+100 บาท","-42 บาท"};

    public static String[] it = {"18/04/2017","เติมเงิน                               +500 บาท"};
    public static Integer[] itt = {0,R.drawable.addmoney};

    public static ArrayList<String> itemm = new ArrayList<String>();
    public static ArrayList<String> itemm2 = new ArrayList<String>();
    public static ArrayList<String> itemm3 = new ArrayList<String>();
    public static ArrayList<Integer> imgidd = new ArrayList<Integer>();
    public static ArrayList<Integer> imgidd2 = new ArrayList<Integer>();
    public static ArrayList<Integer> imgidd3 = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        topup();
        trip();

        list=(ListView)findViewById(R.id.tab1);
        list.setAdapter(new CustomAdapter(this, itemm,imgidd,1));

        list2=(ListView)findViewById(R.id.tab2);
        list2.setAdapter(new CustomAdapter(this, itemm2,imgidd2,2));

        list3=(ListView)findViewById(R.id.tab3);
  //      list3.setAdapter(new CustomAdapter(this, itemm3,imgidd3,3));


        TabHost tabs=(TabHost)findViewById(R.id.tabhost);
        tabs.setup();
        TabHost.TabSpec spec=tabs.newTabSpec("tag1");

     /*   TextView txtTab1 = new TextView(this);
        TextView txtTab2 = new TextView(this);
        TextView txtTab3 = new TextView(this);
        txtTab1.setText("ทั้งหมด");
        txtTab2.setText("สัปดาห์");
        txtTab3.setText("เดือน");
        txtTab1.setTextSize(15);
        txtTab1.setTextColor(Color.WHITE);
        txtTab1.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        txtTab2.setTextSize(15);
        txtTab1.setTextColor(Color.WHITE);
        txtTab1.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        txtTab3.setTextSize(15);
        txtTab1.setTextColor(Color.WHITE);
        txtTab1.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);*/

        spec.setContent(R.id.tab1);
        spec.setIndicator("ทั้งหมด");
        tabs.addTab(spec);

        spec=tabs.newTabSpec("tag2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("สัปดาห์");
        tabs.addTab(spec);

        spec=tabs.newTabSpec("tag3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("เดือน");
        tabs.addTab(spec);
    }

    public static void topup(){
        SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
        Date todayDate = new Date();
        String thisDate = currentDate.format(todayDate);
        boolean b = false;
        for(int i = 0; i< itemm.size() ;i++){
            if(itemm.get(i).equals(thisDate)) b = true;
        }
        if(!b) {
            itemm.add(thisDate);
            itemm2.add(thisDate);
            imgidd.add(R.drawable.addmoney);
            imgidd2.add(R.drawable.addmoney);
        }
        itemm.add(item[0]+item2[0]+item3[0]);
        itemm2.add(item[0]+item2[0]+item3[0]);
        imgidd.add(R.drawable.addmoney);
        imgidd2.add(R.drawable.addmoney);
    }

    public static void trip(){
        SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
        Date todayDate = new Date();
        String thisDate = currentDate.format(todayDate);
        boolean b = false;
        for(int i = 0; i< itemm.size() ;i++){
            if(itemm.get(i).equals(thisDate)) b = true;
        }
        if(!b) {
            itemm.add(thisDate);
            itemm3.add(thisDate);
            imgidd.add(R.drawable.paymoney);
            imgidd3.add(R.drawable.paymoney);
        }
        itemm.add(item[1]+item2[1]+item3[1]);
        itemm3.add(item[1]+item2[1]+item3[1]);
        imgidd.add(R.drawable.paymoney);
        imgidd3.add(R.drawable.paymoney);
    }

}
