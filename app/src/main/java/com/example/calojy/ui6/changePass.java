package com.example.calojy.ui6;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class changePass extends AppCompatActivity {
    private EditText oldPass,formPass1,formPass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);

        oldPass = (EditText) findViewById(R.id.oldpass);
        formPass1 = (EditText) findViewById(R.id.newpass);
        formPass2 = (EditText) findViewById(R.id.confirmpass);


        oldPass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!view.hasFocus()){
                    checkPass();
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
        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // if has profile class go to profile na
                Intent loginIntent = new Intent(changePass.this, login.class);
                startActivity(loginIntent);
            }
        });
        findViewById(R.id.ok).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(mybtnContClicked(v)){
                    String newPass1 = formPass1.getText().toString();
                    passengerList.currentUser.setPass(newPass1);
                    passengerList.passengerlist.get(passengerList.current).setPass(newPass1);
                    // if has profile class go to profile na
                    DialogBoxNext("เปลี่ยนรหัสผ่านสำเร็จ");
                }else{
                    DialogBox("เปลี่ยนรหัสผ่านไม่สำเร็จ");
                }

            }
        });
        findViewById(R.id.menAdd).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent menu = new Intent(changePass.this, menu.class);
                startActivity(menu);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_left);
            }
        });

    }


    public boolean mybtnContClicked(View v){
        String n,p1,p2;
        n=oldPass.getText().toString();
        p1=formPass1.getText().toString();
        p2=formPass2.getText().toString();

        if(checkPass1()||checkPass2()||checkPass()){
            return false;
        }
        return true;
    }


    private boolean checkPass(){
        String s1 =oldPass.getText().toString().trim();
        if(s1.equalsIgnoreCase("")||!passengerList.currentUser.getPass().equals(s1)){
            oldPass.setError("กรุณากรอกรหัสผ่านให้ถูกต้อง");
            return true;
        } else {
            //formName.setError(null);
        }
        return false;
    }

    private boolean checkPass1(){
        String s =formPass1.getText().toString().trim();
        if(s.equalsIgnoreCase("")){
            formPass1.setError("กรุณากรอกรหัสผ่าน");
            return true;
        }else {
            //formName.setError(null);
        }
        return false;
    }

    private boolean checkPass2(){
        String s1 =formPass1.getText().toString().trim();
        String s2 =formPass2.getText().toString().trim();
        if(s2.equalsIgnoreCase("")){
            formPass2.setError("กรุณากรอกยืนยันรหัสผ่าน");
            return true;
        }else if(!s2.equals(s1)){
            formPass2.setError("รหัสผ่านไม่ตรงกัน");
            return true;
        }else {
            //formName.setError(null);
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

    private void DialogBoxNext(String mes){
        AlertDialog alertDialog=new AlertDialog.Builder(this).create();
        alertDialog.setTitle("");
        alertDialog.setMessage(mes);
        alertDialog.setButton("ตกลง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //go to profile instead
                Intent dashIntent = new Intent(changePass.this, login.class);
                startActivity(dashIntent);
            }
        });
        alertDialog.show();
    }

}
