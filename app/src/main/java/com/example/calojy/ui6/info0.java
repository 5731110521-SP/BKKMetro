package com.example.calojy.ui6;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        formName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!view.hasFocus()){
                    checkName();
                }
            }
        });

        formMail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!view.hasFocus()){
                    checkEmail();
                }
            }
        });

        formID.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!view.hasFocus()){
                    checkID();
                }
            }
        });

        formPass1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!view.hasFocus()){
                    checkPass1();
                }
            }
        });

        formPass2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!view.hasFocus()){
                    checkPass2();
                }
            }
        });

        formPhone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!view.hasFocus()){
                   checkPhone();
                }
            }
        });


        findViewById(R.id.next).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (mybtnContClicked(v)) {
                    Intent info2Intent = new Intent(info0.this, info2.class);
                    startActivity(info2Intent);
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

    private Boolean VerifyPeopleID(String PID)
    {
        if (PID.trim().length() != 13)
            return false;
        int sumValue = 0;
        for(int i = 0;i< PID.length()-1;i++)//หรือ for (int i = 0; i < 12; i++)
            sumValue += Integer.parseInt(String.valueOf(PID.charAt(i))) * (13 - i);//หรือ i
        int v =11 - (sumValue % 11);
        return PID.charAt(12) - '0' == (v % 10);
    }

    public boolean mybtnContClicked(View v){
        mail=formMail.getText().toString();
        phone=formPhone.getText().toString();
        boolean error=false;

        if(checkName()||checkEmail()||checkPass1()||checkPass2()||checkID()||checkPhone()){
            return false;
        }

        if(passengerList.checkEmailInList(mail)){
            formMail.setText("");
            DialogBox("อีเมลถูกใช้ไปแล้ว");
            return false;
        }
        if(passengerList.checkPhoneInList(phone)){
            formPhone.setText("");
            DialogBox("เบอร์โทรศัพท์ถูกใช้ไปแล้ว");
            return false;
        }
        return true;
    }

    private boolean checkName(){
        formName = (EditText) findViewById(R.id.name);
        String s =formName.getText().toString().trim();
        if(s.equalsIgnoreCase("") || !s.contains(" ")){
            formName.setError("กรุณากรอกชื่อและนามสกุล");
            return true;
        }else {
            formName.setError(null);
        }
        return false;
    }

    private boolean checkID(){
        formID= (EditText) findViewById(R.id.id);
        String s =formID.getText().toString().trim();
        if(s.equalsIgnoreCase("")){
            formID.setError("กรุณากรอกรหัสประจำตัวประชาชน");
            return true;
        }else if(s.length()<13){
            formID.setError("กรุณากรอกรหัสประจำตัวประชาชน 13 หลัก");
            return true;
        }else if(!VerifyPeopleID(s)) {
            formID.setError("รหัสประจำตัวประชาชนผิดพลาด");
            return true;
        }else {
            formName.setError(null);
        }
        return false;
    }

    private boolean checkEmail(){
        formMail = (EditText) findViewById(R.id.mail);
        String s =formMail.getText().toString().trim();
        if(s.equalsIgnoreCase("")){
            formMail.setError("กรุณากรอกอีเมล");
            return true;
        }else if(!s.contains("@") || !s.contains(".")){
            formMail.setError("กรุณากรอกอีเมลให้ถูกต้อง");
            return true;
        }else {
            formName.setError(null);
        }
        return false;
    }

    private boolean checkPass1(){
        formPass1= (EditText) findViewById(R.id.pass1);
        String s =formPass1.getText().toString().trim();
        if(s.equalsIgnoreCase("")){
            formPass1.setError("กรุณากรอกรหัสผ่าน");
            return true;
        }else {
            formName.setError(null);
        }
        return false;
    }

    private boolean checkPass2(){
        formPass2= (EditText) findViewById(R.id.pass2);
        String s1 =formPass1.getText().toString().trim();
        String s2 =formPass2.getText().toString().trim();
        if(s2.equalsIgnoreCase("")){
            formPass2.setError("กรุณากรอกยืนยันรหัสผ่าน");
            return true;
        }else if(!s2.equals(s1)){
            formPass2.setError("รหัสผ่านไม่ตรงกัน");
            return true;
        }else {
            formName.setError(null);
        }
        return false;
    }

    private boolean checkPhone(){
        String s =formPhone.getText().toString().trim();
        if(s.equalsIgnoreCase("")){
            formPhone.setError("กรุณากรอกเบอร์โทรศัพท์");
            return true;
        }else if(s.length()<10){
            formPhone.setError("กรุณากรอกเบอร์โทรศัพท์ 10 หลัก");
            return true;
        }else {
            formName.setError(null);
        }
        return false;
    }

    private void DialogBox(String mes){
        AlertDialog alertDialog=new AlertDialog.Builder(this).create();
        alertDialog.setTitle("");
        alertDialog.setMessage(mes);
        alertDialog.setButton("ตกลง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.show();
    }
}
