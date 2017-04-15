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

        viewBank.setName.setText(bankAccount.nameB);
        viewBank.setAcc.setText(bankAccount.accB);
        viewBank.setBank.setText(bankAccount.bankB);

        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(bankAccount.acc_list.size() ==1|| bankAccount.resId_list.size()==1 || bankAccount.bank_list.size()==1 || bankAccount.name_list.size()==1){
                    DialogBox("ไม่สามารถลบบัญชีได้");
                }else {
                    bankAccount.deleteBankaccount(bankAccount.pos);
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
