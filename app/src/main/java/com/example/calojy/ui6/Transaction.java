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
import java.util.ArrayList;
import java.util.Arrays;

public class Transaction extends Activity {
    ListView list,list2,list3;

    String[] item = {"เติมเงิน","ชำระค่าโดยสาร"};
    String[] item2 = {"                                ","                    "};
    String[] item3 = {"+100 บาท","-42 บาท"};

    String[] itemname ={"",item[0]+item2[0]+item3[0], item[1]+item2[1]+item3[1],item[1]+item2[1]+item3[1],
            "",item[0]+item2[0]+item3[0],item[1]+item2[1]+item3[1],item[1]+item2[1]+item3[1]};

    Integer[] imgid={R.drawable.addmoney,R.drawable.addmoney, R.drawable.paymoney,R.drawable.paymoney,
            R.drawable.addmoney, R.drawable.addmoney,R.drawable.paymoney,R.drawable.paymoney};

    ArrayList<String> itemm = new ArrayList<String>(Arrays.asList(itemname));
    ArrayList<Integer> imgidd = new ArrayList<Integer>(Arrays.asList(imgid));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);


        list=(ListView)findViewById(R.id.tab1);
        list.setAdapter(new CustomAdapter(this, itemm, imgidd,1));

        list2=(ListView)findViewById(R.id.tab2);
        list2.setAdapter(new CustomAdapter(this, itemm, imgidd,2));

        list3=(ListView)findViewById(R.id.tab3);
        list3.setAdapter(new CustomAdapter(this, itemm, imgidd,3));


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


}
