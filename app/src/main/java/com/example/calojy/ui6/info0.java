package com.example.calojy.ui6;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class info0 extends AppCompatActivity {
    private EditText formName,formID,formMail,formPass1,formPass2,formPhone;
    public static String name,id,mail,p1,p2,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info0);

        formName = (EditText) findViewById(R.id.name);
        formID= (EditText) findViewById(R.id.id);
        formMail = (EditText) findViewById(R.id.mail);
        formPass1= (EditText) findViewById(R.id.pass1);
        formPass2= (EditText) findViewById(R.id.pass2);
        formPhone = (EditText) findViewById(R.id.phone);


        findViewById(R.id.next).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                formName = (EditText) findViewById(R.id.name);
                formID= (EditText) findViewById(R.id.id);
                formMail = (EditText) findViewById(R.id.mail);
                formPass1= (EditText) findViewById(R.id.pass1);
                formPass2= (EditText) findViewById(R.id.pass2);
                formPhone = (EditText) findViewById(R.id.phone);

                name=formName.getText().toString();
                id=formID.getText().toString();
                mail=formMail.getText().toString();
                p1=formPass1.getText().toString();
                p2=formPass2.getText().toString();
                phone=formPhone.getText().toString();

                if(name.length()<=0 || id.length()!=13||mail.length()<=0||mail.indexOf("@")==-1||p1.length()<=0||phone.length()!=10){
                    if(name.length()<=0){formName.setText("");}
                    if(id.length()!=13){formID.setText("");}
                    if(mail.length()<=0||mail.indexOf("@")==-1){formMail.setText("");}
                    if(phone.length()!=10){formPhone.setText("");}
                    DialogBox("กรุณากรอกข้อมูลให้ถูกต้อง");
                }
                else if(!p2.equals(p1)){
                    formPass1.setText("");
                    formPass2.setText("");
                    DialogBox("รหัสผ่านไม่ตรงกัน");
                }
                else {
                    if (mybtnContClicked(v)) {
                        passengerList.nameB = name;
                        Intent info2Intent = new Intent(info0.this, info2.class);
                        startActivity(info2Intent);
                    } else {

                    }
                }

            }
        });

        findViewById(R.id.back0).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent loginIntent = new Intent(info0.this, login.class);
                startActivity(loginIntent);
            }
        });

        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(info0.this, login.class);
                startActivity(loginIntent);
            }
        });


    }//end onCreate

    public boolean mybtnContClicked(View v){
        mail=formMail.getText().toString();
        phone=formPhone.getText().toString();

        if(passengerList.checkInList(mail,phone)){
            DialogBox("อีเมลหรือเบอร์โทรศัพท์ถูกใช้ไปแล้ว");
            return false;
        }
        return true;
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
