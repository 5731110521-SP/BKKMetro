package com.example.calojy.ui6;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
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

        formID.addTextChangedListener(new PhoneNumberFormattingTextWatcher(){
            //we need to know if the user is erasing or inputing some new character
            private boolean backspacingFlag = false;
            //we need to block the :afterTextChanges method to be called again after we just replaced the EditText text
            private boolean editedFlag = false;
            //we need to mark the cursor position and restore it after the edition
            private int cursorComplement;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //we store the cursor local relative to the end of the string in the EditText before the edition
                cursorComplement = s.length()-formID.getSelectionStart();
                //we check if the user ir inputing or erasing a character
                if (count > after) {
                    backspacingFlag = true;
                } else {
                    backspacingFlag = false;
                }
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // nothing to do here =D
            }

            @Override
            public void afterTextChanged(Editable s) {
                String string = s.toString();
                //what matters are the phone digits beneath the mask, so we always work with a raw string with only digits
                String phone = string.replaceAll("[^\\d]", "");

                //if the text was just edited, :afterTextChanged is called another time... so we need to verify the flag of edition
                //if the flag is false, this is a original user-typed entry. so we go on and do some magic
                if (!editedFlag) {

                    //we start verifying the worst case, many characters mask need to be added
                    //example: 999999999 <- 6+ digits already typed
                    // masked: (999) 999-999
                    if (phone.length() >= 12 && !backspacingFlag) {
                        //we will edit. next call on this textWatcher will be ignored
                        editedFlag = true;
                        //here is the core. we substring the raw digits and add the mask as convenient
                        String ans = phone.substring(0, 1) + "-" + phone.substring(1,5) + "-" + phone.substring(5,10)
                                +"-"+phone.substring(10,12)+"-"+phone.substring(12);
                        formID.setText(ans);
                        //we deliver the cursor to its original position relative to the end of the string
                        formID.setSelection(formID.getText().length()-cursorComplement);

                        //we end at the most simple case, when just one character mask is needed
                        //example: 99999 <- 3+ digits already typed
                        // masked: (999) 99
                    } else if (phone.length() >= 10 && !backspacingFlag) {
                        editedFlag = true;
                        String ans = phone.substring(0, 1) + "-" + phone.substring(1,5) + "-" + phone.substring(5,10)
                                +"-"+phone.substring(10);
                        formID.setText(ans);
                        formID.setSelection(formID.getText().length()-cursorComplement);
                    } else if (phone.length() >= 5 && !backspacingFlag) {
                        editedFlag = true;
                        String ans = phone.substring(0, 1) + "-" + phone.substring(1,5) + "-" + phone.substring(5);
                        formID.setText(ans);
                        formID.setSelection(formID.getText().length()-cursorComplement);
                    } else if (phone.length() >= 1 && !backspacingFlag) {
                        editedFlag = true;
                        String ans = phone.substring(0, 1) + "-" + phone.substring(1);
                        formID.setText(ans);
                        formID.setSelection(formID.getText().length()-cursorComplement);
                    }
                    // We just edited the field, ignoring this cicle of the watcher and getting ready for the next
                } else {
                    editedFlag = false;
                }
            }
        });

        formPhone.addTextChangedListener(new PhoneNumberFormattingTextWatcher(){
            //we need to know if the user is erasing or inputing some new character
            private boolean backspacingFlag = false;
            //we need to block the :afterTextChanges method to be called again after we just replaced the EditText text
            private boolean editedFlag = false;
            //we need to mark the cursor position and restore it after the edition
            private int cursorComplement;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //we store the cursor local relative to the end of the string in the EditText before the edition
                cursorComplement = s.length()-formPhone.getSelectionStart();
                //we check if the user ir inputing or erasing a character
                if (count > after) {
                    backspacingFlag = true;
                } else {
                    backspacingFlag = false;
                }
            }
/*
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // nothing to do here =D
            }
//>>>>>>> refs/remotes/origin/master

            @Override
            public void afterTextChanged(Editable s) {
                String string = s.toString();
                //what matters are the phone digits beneath the mask, so we always work with a raw string with only digits
                String phone = string.replaceAll("[^\\d]", "");

                //if the text was just edited, :afterTextChanged is called another time... so we need to verify the flag of edition
                //if the flag is false, this is a original user-typed entry. so we go on and do some magic
                if (!editedFlag) {

                    //we start verifying the worst case, many characters mask need to be added
                    //example: 999999999 <- 6+ digits already typed
                    // masked: (999) 999-999
                    if (phone.length() >= 6 && !backspacingFlag) {
                        //we will edit. next call on this textWatcher will be ignored
                        editedFlag = true;
                        //here is the core. we substring the raw digits and add the mask as convenient
                        String ans = phone.substring(0, 3) + "-" + phone.substring(3,6) + "-" + phone.substring(6);
                        formPhone.setText(ans);
                        //we deliver the cursor to its original position relative to the end of the string
                        formPhone.setSelection(formPhone.getText().length()-cursorComplement);

                        //we end at the most simple case, when just one character mask is needed
                        //example: 99999 <- 3+ digits already typed
                        // masked: (999) 99
                    } else if (phone.length() >= 3 && !backspacingFlag) {
                        editedFlag = true;
                        String ans = phone.substring(0, 3) + "-" + phone.substring(3);
                        formPhone.setText(ans);
                        formPhone.setSelection(formPhone.getText().length()-cursorComplement);
                    }
                    // We just edited the field, ignoring this cicle of the watcher and getting ready for the next
                } else {
                    editedFlag = false;
                }
            }
        });
*/

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // nothing to do here =D
            }

            @Override
            public void afterTextChanged(Editable s) {
                String string = s.toString();
                //what matters are the phone digits beneath the mask, so we always work with a raw string with only digits
                String phone = string.replaceAll("[^\\d]", "");

                //if the text was just edited, :afterTextChanged is called another time... so we need to verify the flag of edition
                //if the flag is false, this is a original user-typed entry. so we go on and do some magic
                if (!editedFlag) {

                    //we start verifying the worst case, many characters mask need to be added
                    //example: 999999999 <- 6+ digits already typed
                    // masked: (999) 999-999
                    if (phone.length() >= 6 && !backspacingFlag) {
                        //we will edit. next call on this textWatcher will be ignored
                        editedFlag = true;
                        //here is the core. we substring the raw digits and add the mask as convenient
                        String ans = phone.substring(0, 3) + "-" + phone.substring(3,6) + "-" + phone.substring(6);
                        formPhone.setText(ans);
                        //we deliver the cursor to its original position relative to the end of the string
                        formPhone.setSelection(formPhone.getText().length()-cursorComplement);

                        //we end at the most simple case, when just one character mask is needed
                        //example: 99999 <- 3+ digits already typed
                        // masked: (999) 99
                    } else if (phone.length() >= 3 && !backspacingFlag) {
                        editedFlag = true;
                        String ans = phone.substring(0, 3) + "-" + phone.substring(3);
                        formPhone.setText(ans);
                        formPhone.setSelection(formPhone.getText().length()-cursorComplement);
                    }
                    // We just edited the field, ignoring this cicle of the watcher and getting ready for the next
                } else {
                    editedFlag = false;
                }
            }
        });


        findViewById(R.id.next).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (mybtnContClicked(v)) {
                    bankAccount.nameB = name;
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
                formName = (EditText) findViewById(R.id.name);
                formID= (EditText) findViewById(R.id.id);
                formMail = (EditText) findViewById(R.id.mail);
                formPass1= (EditText) findViewById(R.id.pass1);
                formPass2= (EditText) findViewById(R.id.pass2);
                formPhone = (EditText) findViewById(R.id.phone);

                mail=formMail.getText().toString();
                phone=formPhone.getText().toString();
                p1=formPass1.getText().toString();
                name=formName.getText().toString();
                p2=formPass2.getText().toString();
                id=formID.getText().toString();

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
                s=s.replaceAll("[^\\d]", "");
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
                s=s.replaceAll("[^\\d]", "");
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