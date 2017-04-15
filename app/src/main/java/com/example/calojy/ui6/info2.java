package com.example.calojy.ui6;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
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

        formAcc.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!view.hasFocus()){
                    checkAcc();
                }
            }
        });

        formAcc.addTextChangedListener(new PhoneNumberFormattingTextWatcher(){
            //we need to know if the user is erasing or inputing some new character
            private boolean backspacingFlag = false;
            //we need to block the :afterTextChanges method to be called again after we just replaced the EditText text
            private boolean editedFlag = false;
            //we need to mark the cursor position and restore it after the edition
            private int cursorComplement;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //we store the cursor local relative to the end of the string in the EditText before the edition
                cursorComplement = s.length()-formAcc.getSelectionStart();
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
                    if (phone.length() >= 9 && !backspacingFlag) {
                        //we will edit. next call on this textWatcher will be ignored
                        editedFlag = true;
                        //here is the core. we substring the raw digits and add the mask as convenient
                        String ans = phone.substring(0, 3) + "-" + phone.substring(3, 4) + "-" + phone.substring(4,9)+ "-" + phone.substring(9);
                        formAcc.setText(ans);
                        //we deliver the cursor to its original position relative to the end of the string
                        formAcc.setSelection(formAcc.getText().length() - cursorComplement);

                        //we end at the most simple case, when just one character mask is needed
                        //example: 99999 <- 3+ digits already typed
                        // masked: (999) 99
                    }else if (phone.length() >= 4 && !backspacingFlag) {
                        //we will edit. next call on this textWatcher will be ignored
                        editedFlag = true;
                        //here is the core. we substring the raw digits and add the mask as convenient
                        String ans = phone.substring(0, 3) + "-" + phone.substring(3, 4) + "-" + phone.substring(4);
                        formAcc.setText(ans);
                        //we deliver the cursor to its original position relative to the end of the string
                        formAcc.setSelection(formAcc.getText().length() - cursorComplement);

                        //we end at the most simple case, when just one character mask is needed
                        //example: 99999 <- 3+ digits already typed
                        // masked: (999) 99
                    } else if (phone.length() >= 3 && !backspacingFlag) {
                        editedFlag = true;
                        String ans = phone.substring(0, 3) + "-" + phone.substring(3);
                        formAcc.setText(ans);
                        formAcc.setSelection(formAcc.getText().length()-cursorComplement);
                    }
                    // We just edited the field, ignoring this cicle of the watcher and getting ready for the next
                } else {
                    editedFlag = false;
                }
            }
        });

        findViewById(R.id.fin).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                acc=formAcc.getText().toString();
                bank=((ItemData)sp.getSelectedItem()).getText();
                if(checkAcc()){

                }else if(bank.equals("เลือกธนาคาร")){
                    DialogBox("กรุณาเลือกธนาคาร");
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
        list.add(new ItemData("เลือกธนาคาร",R.drawable.iconbank0));
        list.add(new ItemData("ธนาคารกรุงศรี",R.drawable.iconbank1));
        list.add(new ItemData("ธนาคารกรุงเทพ",R.drawable.iconbank3));
        list.add(new ItemData("ธนาคารกสิกร",R.drawable.iconbank4));
        list.add(new ItemData("ธนาคารกรุงไทย",R.drawable.iconbank5));
        list.add(new ItemData("ธนาคารไทยพานิชย์",R.drawable.iconbank6));

        SimpleImageArrayAdapter adapter=new SimpleImageArrayAdapter(this,
                R.layout.spinner_layout,R.id.txt,list);
        sp.setAdapter(adapter);

    }//end onCreate

    private boolean checkAcc() {
        formAcc = (EditText) findViewById(R.id.accNo);
        String s =formAcc.getText().toString().trim();
        s = s.replaceAll("\\D", "");
        if(s.equalsIgnoreCase("")){
            formAcc.setError("กรุณากรอกรหัสบัญชีธนาคาร");
            return true;
        }if(s.length()!=10) {
            formAcc.setError("กรุณากรอกรหัสบัญชีธนาคาร 10 หลัก");
            return true;
        }else{
            formAcc.setError(null);
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
                Intent dashIntent = new Intent(info2.this, dash.class);
                startActivity(dashIntent);
                ArrayList<bankAccount> bankAccounts = new ArrayList<>();
                bankAccounts.add(new bankAccount(formAcc.getText().toString(),bank));
                passengerList.addInList(info0.mail,info0.p1,info0.phone,0,bankAccounts);
            }
        });
        alertDialog.show();
    }

}
