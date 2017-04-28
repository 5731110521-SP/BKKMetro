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

   private int money=100;
   Spinner sp1;
   EditText mon;
    private int choose;


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
        ArrayList<bankAccount> bankAccounts = passengerList.currentUser.getBankAccounts();
        for(int i=0;i<bankAccount.resId_list.size();i++){
            /*Integer imageID;
            if(bankAccounts.get(i).getBankName().equals("ธนาคารกรุงศรี"))imageID=R.drawable.iconbank1;
            else if(bankAccounts.get(i).getBankName().equals("ธนาคารกรุงเทพ"))imageID=R.drawable.iconbank3;
            else if(bankAccounts.get(i).getBankName().equals("ธนาคารกสิกร"))imageID=R.drawable.iconbank4;
            else if(bankAccounts.get(i).getBankName().equals("ธนาคารกรุงไทย"))imageID=R.drawable.iconbank5;
            else imageID=R.drawable.iconbank6;
            list.add(new ItemData(bankAccounts.get(i).getBankID(),imageID));
*/

            list.add(new ItemData(bankAccount.acc_list.get(i),bankAccount.resId_list.get(i)));

        }

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
                //Intent dash = new Intent(addMoney.this, dash.class);
                //startActivity(dash);
                finish();

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
        /*AlertDialog alertDialog=new AlertDialog.Builder(this).create();
        alertDialog.setTitle("");
        alertDialog.setMessage(mes);
        alertDialog.setButton("ตกลง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                passengerList.currentUser.setBalance(money+passengerList.currentUser.getBalance());
                passengerList.currentUser.addTopup(new topup(money
                        ,bankAccount.bank_list.get(sp1.getSelectedItemPosition())
                        ,bankAccount.acc_list.get(sp1.getSelectedItemPosition())));
                //passengerList.passengerlist.get(passengerList.current).setBalance(money+passengerList.currentUser.getBalance());
                Intent dash = new Intent(addMoney.this, splip.class);
                startActivity(dash);
            }
        });
        alertDialog.show();*/
        AlertDialog.Builder builder = new AlertDialog.Builder(addMoney.this);
        builder.setMessage(mes);
        builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which){
                passengerList.currentUser.setBalance(money+passengerList.currentUser.getBalance());
                passengerList.currentUser.addTopup(new topup(money
                        ,bankAccount.bank_list.get(sp1.getSelectedItemPosition())
                        ,bankAccount.acc_list.get(sp1.getSelectedItemPosition())));
                //passengerList.passengerlist.get(passengerList.current).setBalance(money+passengerList.currentUser.getBalance());
                Intent dash = new Intent(addMoney.this, splip.class);
                startActivity(dash);
            }
        });
        builder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which){

            }
        });
        builder.show();
    }
}
