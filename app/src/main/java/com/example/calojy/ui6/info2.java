package com.example.calojy.ui6;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class info2 extends AppCompatActivity {
    EditText formAcc;
    Spinner sp;
    String acc;
    String bank;
    info0 n=new info0();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info2);

        formAcc=(EditText) findViewById(R.id.accNo);
        sp=(Spinner)findViewById(R.id.spinner);

        findViewById(R.id.fin).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                acc=formAcc.getText().toString();
                bank=((ItemData)sp.getSelectedItem()).getText();
                if(acc.length()!=10 || bank.equals("Choose Bank")){
                    DialogBox("กรุณากรอกข้อมูลให้ถูกต้อง");
                }else {
                    DialogBoxNext("สมัครสมาชิกสำเร็จ");
                }

            }
        });
        findViewById(R.id.back2).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent info0Intent = new Intent(info2.this, info0.class);
                startActivity(info0Intent);
            }
        });

        findViewById(R.id.cancel2).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent loginIntent = new Intent(info2.this, login.class);
                startActivity(loginIntent);
            }
        });




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
        sp.setAdapter(adapter);

    }//end onCreate
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
        alertDialog.setTitle("แจ้งเตือน");
        alertDialog.setMessage(mes);
        alertDialog.setButton("ตกลง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent dashIntent = new Intent(info2.this, dash.class);
                startActivity(dashIntent);
                passengerList.addInList(info0.mail,info0.p1,info0.phone);
            }
        });
        alertDialog.show();
    }

}
