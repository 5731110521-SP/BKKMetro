package com.example.calojy.ui6;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class addBankaccount extends AppCompatActivity {

    EditText formAcc,formName;
    Spinner sp;
    String acc,name;
    String bank;
    info0 n=new info0();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bankaccount);

        formName=(EditText) findViewById(R.id.name);
        formAcc=(EditText) findViewById(R.id.accNo);
        sp=(Spinner)findViewById(R.id.spinner);

        findViewById(R.id.fin).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                acc=formAcc.getText().toString();
                bank=((ItemData)sp.getSelectedItem()).getText();
                int num = (int) sp.getSelectedItemId();
                name = formName.getText().toString();

                if(acc.length()!=10 || bank.equals("Choose Bank") || name.length()<=0){
                    if(name.length()<=0){formName.setText("");}
                    DialogBox("กรุณากรอกข้อมูลให้ถูกต้อง");
                }else {
                    passengerList.bank_list.add(passengerList.nameBank[num-1]);
                    passengerList.resId_list.add(passengerList.icon[num-1]);
                    passengerList.des_list.add(acc);
                    passengerList.name_list.add(name);
                    passengerList.pos++;
                    DialogBoxNext("เพิ่มบัญชีธนาคารสำเร็จ");
                }

            }
        });

        findViewById(R.id.cancel2).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent loginIntent = new Intent(addBankaccount.this, viewBankAccount.class);
                startActivity(loginIntent);
            }
        });

        ArrayList<ItemData> list=new ArrayList<>();
        list.add(new ItemData("Choose Bank",R.drawable.iconbank0));
        list.add(new ItemData("Krungsri",R.drawable.iconbank1));
        list.add(new ItemData("TMB",R.drawable.iconbank2));
        list.add(new ItemData("Krungthep",R.drawable.iconbank3));
        list.add(new ItemData("Kasikorn",R.drawable.iconbank4));
        list.add(new ItemData("Krungthai",R.drawable.iconbank5));
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
                Intent dashIntent = new Intent(addBankaccount.this, viewBankAccount.class);
                startActivity(dashIntent);
            }
        });
        alertDialog.show();
    }

}
