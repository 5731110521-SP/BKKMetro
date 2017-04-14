package com.example.calojy.ui6;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class viewBank extends AppCompatActivity {
    public static TextView setName,setAcc,setBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bank);

        setName = (TextView) findViewById(R.id.setName);
        setAcc = (TextView) findViewById(R.id.setAcc);
        setBank = (TextView) findViewById(R.id.setBank);

        viewBank.setName.setText(passengerList.nameB);
        viewBank.setAcc.setText(passengerList.accB);
        viewBank.setBank.setText(passengerList.bankB);

        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(passengerList.pos==1|| passengerList.resId_list.size()==1 || passengerList.bank_list.size()==1){
                    DialogBox("ไม่สามารถลบบัญชีได้");
                }else {
                    passengerList.pos--;
                    passengerList.name_list.remove(passengerList.pos);
                    passengerList.des_list.remove(passengerList.pos);
                    passengerList.bank_list.remove(passengerList.pos);
                    passengerList.resId_list.remove(passengerList.pos);
                    DialogBoxNext("ลบบัญชีธนาคารสำเร็จ");
                }
            }
        });
        findViewById(R.id.backbutton).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent loginIntent = new Intent(viewBank.this, viewBankAccount.class);
                startActivity(loginIntent);
            }
        });

    }



    private void DialogBoxNext(String mes){
        AlertDialog alertDialog=new AlertDialog.Builder(this).create();
        alertDialog.setTitle("แจ้งเตือน");
        alertDialog.setMessage(mes);
        alertDialog.setButton("ตกลง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent delBank = new Intent(viewBank.this, viewBankAccount.class);
                startActivity(delBank);
            }
        });
        alertDialog.show();
    }


    private void DialogBox(String mes){
        AlertDialog alertDialog=new AlertDialog.Builder(this).create();
        alertDialog.setTitle("แจ้งเตือน");
        alertDialog.setMessage(mes);
        alertDialog.setButton("ตกลง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.show();
    }

}
