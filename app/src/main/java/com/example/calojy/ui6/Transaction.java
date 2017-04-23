package com.example.calojy.ui6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;

public class Transaction extends Activity {
    ListView list,list2,list3;

    private String[] item = {"เติมเงิน","ชำระค่าโดยสาร"};
    private String[] item2 = {"                                    ","                    "};
    private String[] item3 = {"+100 บาท","-42 บาท"};

    public String[] it = {"18/04/2017","เติมเงิน                               +500 บาท"};
    public Integer[] itt = {0,R.drawable.addmoney};

    public ArrayList<String> itemm = new ArrayList<String>();
    public ArrayList<String> itemm2 = new ArrayList<String>();
    public ArrayList<String> itemm3 = new ArrayList<String>();
    public ArrayList<Integer> imgidd = new ArrayList<Integer>();
    public ArrayList<Integer> imgidd2 = new ArrayList<Integer>();
    public ArrayList<Integer> imgidd3 = new ArrayList<Integer>();
    public ArrayList<String> bankname = new ArrayList<>();
    public ArrayList<String> bankname2 = new ArrayList<>();
    public ArrayList<String> bankname3 = new ArrayList<>();
    public ArrayList<String> banknum = new ArrayList<>();
    public ArrayList<String> banknum2 = new ArrayList<>();
    public ArrayList<String> banknum3 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        findViewById(R.id.menAdd).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent menu = new Intent(Transaction.this, menu.class);
                startActivity(menu);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_left);
            }
        });
        //trip();
        //topup();
        both();

        list=(ListView)findViewById(R.id.tab1);
        list.setAdapter(new CustomAdapterSummary(this, itemm,imgidd,bankname,banknum,1));

        list2=(ListView)findViewById(R.id.tab2);
        list2.setAdapter(new CustomAdapterSummary(this, itemm2,imgidd2,bankname2,banknum2,2));

        list3=(ListView)findViewById(R.id.tab3);
        list3.setAdapter(new CustomAdapterSummary(this, itemm3,imgidd3,bankname3,banknum3,3));


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
        spec.setIndicator("เติมเงิน");
        tabs.addTab(spec);

        spec=tabs.newTabSpec("tag3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("ชำระค่าโดยสาร");
        tabs.addTab(spec);
    }

    public void topup(){
        ArrayList<topup> topups = passengerList.currentUser.getTopups();
        for(int i=topups.size()-1;i>-1;i--){
            String thisDate = topups.get(i).getDate();
            boolean b = false;
            boolean b2 = false;
            boolean find;
            int index;
            for(int j = 0; j< itemm.size() ;j++){
                if(itemm.get(j).equals(thisDate)) {
                    b = true;
                    index=j;
                    break;
                }
            }
            for (int j = 0; j < itemm2.size(); j++) {
                if (itemm2.get(i).equals(thisDate)) {
                    b2 = true;
                    index =j;
                    break;
                }
            }
            if(!b) {
                itemm.add(thisDate);
                imgidd.add(R.drawable.addmoney);
                bankname.add("");
                banknum.add("");
            }
            if(!b2) {
                itemm2.add(thisDate);
                imgidd2.add(R.drawable.addmoney);
                bankname2.add("");
                banknum2.add("");
            }
            String amount="+"+Integer.toString(topups.get(i).getAmount())+" บาท";
            itemm.add(item[0]+item2[0]+amount);
            itemm2.add(item[0]+item2[0]+amount);
            imgidd.add(R.drawable.addmoney);
            imgidd2.add(R.drawable.addmoney);

            bankname.add(topups.get(i).getBank());
            bankname2.add(topups.get(i).getBank());

            banknum.add(topups.get(i).getBanknumber());
            banknum2.add(topups.get(i).getBanknumber());

        }
    }

    public void trip(){
        ArrayList<trip> trips = passengerList.currentUser.getTrips();
        for(int j=trips.size()-1;j>-1;j--) {
            String thisDate = trips.get(j).getDate();
            boolean b1 = false;
            boolean b3 = false;
            for (int i = 0; i < itemm.size(); i++) {
                if (itemm.get(i).equals(thisDate)) {
                    b1 = true;
                    break;
                }
            }
            for (int i = 0; i < itemm3.size(); i++) {
                if (itemm3.get(i).equals(thisDate)) {
                    b3 = true;
                    break;
                }
            }
            if (!b1) {
                itemm.add(thisDate);
                imgidd.add(R.drawable.paymoney);
                bankname.add("");
                banknum.add("");
            }
            if (!b3) {
                itemm3.add(thisDate);
                imgidd3.add(R.drawable.paymoney);
                bankname3.add("");
                banknum3.add("");
            }
            itemm.add(item[1] + item2[1] + item3[1]);
            itemm3.add(item[1] + item2[1] + item3[1]);
            imgidd.add(R.drawable.paymoney);
            imgidd3.add(R.drawable.paymoney);

            bankname.add("");
            bankname3.add("");

            banknum.add("");
            banknum3.add("");
        }
    }

    public void both(){
        ArrayList<trip> trips = passengerList.currentUser.getTrips();
        ArrayList<topup> topups = passengerList.currentUser.getTopups();
        int itr=trips.size()-1;
        int ito=topups.size()-1;
        String beforeDate = "";
        String trbDate="";
        String tobDate="";
        while(true) {
            String trDate="";
            String toDate="";
            if(itr<0||ito<0){
                break;
            }else if(itr<0){
                trDate="00/00/0000";
            }else if(ito<0){
                toDate="00/00/0000";
            }else{
                trDate = trips.get(itr).getDate();
                toDate = topups.get(ito).getDate();
            }
            if (trDate.substring(3, 5).compareTo(toDate.substring(3, 5)) < 0
                    || (trDate.substring(3, 5).equals(toDate.substring(3, 5))
                    && trDate.substring(0, 2).compareTo(toDate.substring(0, 2))<0)) {
                String amount = "+" + Integer.toString(topups.get(ito).getAmount()) + " บาท";

                if (!toDate.equals(beforeDate)) {
                    itemm.add(toDate);
                    imgidd.add(R.drawable.addmoney);
                    bankname.add("");
                    banknum.add("");

                    itemm2.add(toDate);
                    imgidd2.add(R.drawable.addmoney);
                    bankname2.add("");
                    banknum2.add("");
                    beforeDate = toDate;
                    tobDate=toDate;
                }else if(!toDate.equals(tobDate)){
                    itemm2.add(toDate);
                    imgidd2.add(R.drawable.addmoney);
                    bankname2.add("");
                    banknum2.add("");
                    tobDate=toDate;
                }

                itemm.add(item[0] + item2[0] + amount);
                itemm2.add(item[0] + item2[0] + amount);
                imgidd.add(R.drawable.addmoney);
                imgidd2.add(R.drawable.addmoney);

                bankname.add(topups.get(ito).getBank());
                bankname2.add(topups.get(ito).getBank());

                banknum.add(topups.get(ito).getBanknumber());
                banknum2.add(topups.get(ito).getBanknumber());
                ito--;
            } else {
                if (!trDate.equals(beforeDate)) {
                    itemm.add(trDate);
                    imgidd.add(R.drawable.paymoney);
                    bankname.add("");
                    banknum.add("");

                    itemm3.add(trDate);
                    imgidd3.add(R.drawable.paymoney);
                    bankname3.add("");
                    banknum3.add("");
                    beforeDate = trDate;
                    trbDate=trDate;
                }else if(!trDate.equals(trbDate)){
                    itemm3.add(trDate);
                    imgidd3.add(R.drawable.paymoney);
                    bankname3.add("");
                    banknum3.add("");
                    trbDate=trDate;
                }

                itemm.add(item[1] + item2[1] + item3[1]);
                itemm3.add(item[1] + item2[1] + item3[1]);
                imgidd.add(R.drawable.paymoney);
                imgidd3.add(R.drawable.paymoney);

                bankname.add("");
                bankname3.add("");

                banknum.add("");
                banknum3.add("");
                itr--;
            }
        }
    }


}
