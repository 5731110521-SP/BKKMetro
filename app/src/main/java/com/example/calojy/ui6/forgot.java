package com.example.calojy.ui6;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class forgot extends AppCompatActivity {
    private EditText formEmailFor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        formEmailFor=(EditText) findViewById(R.id.mailfor);

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formEmailFor=(EditText) findViewById(R.id.mailfor);
                String email = formEmailFor.getText().toString();
                if(email.length()<=0){
                    DialogBox("กรุณากรอกอีเมล");
                }else if(email.indexOf("@")==-1) {
                    DialogBox("กรุณากรอกข้อมูลให้ถูกต้อง");
                }else if (!passengerList.checkEmailInList(email)){
                        DialogBox("ไม่มีอีเมลนี้ในระบบ");
                }else {
                        DialogBoxNext("ส่งไปยังอีเมลเรียบร้อย");
                }

            }
        });
        findViewById(R.id.back3).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent log = new Intent(forgot.this,login.class);
                startActivity(log);
            }
        });

    }//end conCreate

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

    private void DialogBoxNext(String mes){
        AlertDialog alertDialog=new AlertDialog.Builder(this).create();
        alertDialog.setTitle("สำเร็จ");
        alertDialog.setMessage(mes);
        alertDialog.setButton("ตกลง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent log = new Intent(forgot.this,login.class);
                startActivity(log);
            }
        });
        alertDialog.show();
    }

}