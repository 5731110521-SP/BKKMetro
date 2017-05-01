package com.example.calojy.ui6;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.TextView;

public class viewProfile extends AppCompatActivity {
    private TextView formName,formID,formMail,formPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

                formName = (TextView) findViewById(R.id.name);
                formID= (TextView) findViewById(R.id.id);
                formMail = (TextView) findViewById(R.id.mail);
                formPhone = (TextView) findViewById(R.id.phone);
                formName.setText(passengerList.currentUser.getName());
                formName.setTextColor(Color.BLACK);
                formID.setText((passengerList.currentUser.getId()));
                formID.setTextColor(Color.BLACK);
                formMail.setText((passengerList.currentUser.getEmail()));
                formMail.setTextColor(Color.BLACK);
                formPhone.setText((passengerList.currentUser.getPhone()));
                formPhone.setTextColor(Color.BLACK);


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

//            @Override
//            public void afterTextChanged(Editable s) {
//                String string = s.toString();
//                //what matters are the phone digits beneath the mask, so we always work with a raw string with only digits
//                String phone = string.replaceAll("[^\\d]", "");
//
//                //if the text was just edited, :afterTextChanged is called another time... so we need to verify the flag of edition
//                //if the flag is false, this is a original user-typed entry. so we go on and do some magic
//                if (!editedFlag) {
//
//                    //we start verifying the worst case, many characters mask need to be added
//                    //example: 999999999 <- 6+ digits already typed
//                    // masked: (999) 999-999
//                    if (phone.length() >= 12 && !backspacingFlag) {
//                        //we will edit. next call on this textWatcher will be ignored
//                        editedFlag = true;
//                        //here is the core. we substring the raw digits and add the mask as convenient
//                        String ans = phone.substring(0, 1) + "-" + phone.substring(1,5) + "-" + phone.substring(5,10)
//                                +"-"+phone.substring(10,12)+"-"+phone.substring(12);
//                        formID.setText(ans);
//                        //we deliver the cursor to its original position relative to the end of the string
//                        formID.setSelection(formID.getText().length()-cursorComplement);
//
//                        //we end at the most simple case, when just one character mask is needed
//                        //example: 99999 <- 3+ digits already typed
//                        // masked: (999) 99
//                    } else if (phone.length() >= 10 && !backspacingFlag) {
//                        editedFlag = true;
//                        String ans = phone.substring(0, 1) + "-" + phone.substring(1,5) + "-" + phone.substring(5,10)
//                                +"-"+phone.substring(10);
//                        formID.setText(ans);
//                        formID.setSelection(formID.getText().length()-cursorComplement);
//                    } else if (phone.length() >= 5 && !backspacingFlag) {
//                        editedFlag = true;
//                        String ans = phone.substring(0, 1) + "-" + phone.substring(1,5) + "-" + phone.substring(5);
//                        formID.setText(ans);
//                        formID.setSelection(formID.getText().length()-cursorComplement);
//                    } else if (phone.length() >= 1 && !backspacingFlag) {
//                        editedFlag = true;
//                        String ans = phone.substring(0, 1) + "-" + phone.substring(1);
//                        formID.setText(ans);
//                        formID.setSelection(formID.getText().length()-cursorComplement);
//                    }
//                    // We just edited the field, ignoring this cicle of the watcher and getting ready for the next
//                } else {
//                    editedFlag = false;
//                }
//            }
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

//            @Override
//            public void afterTextChanged(Editable s) {
//                String string = s.toString();
//                //what matters are the phone digits beneath the mask, so we always work with a raw string with only digits
//                String phone = string.replaceAll("[^\\d]", "");
//
//                //if the text was just edited, :afterTextChanged is called another time... so we need to verify the flag of edition
//                //if the flag is false, this is a original user-typed entry. so we go on and do some magic
//                if (!editedFlag) {
//
//                    //we start verifying the worst case, many characters mask need to be added
//                    //example: 999999999 <- 6+ digits already typed
//                    // masked: (999) 999-999
//                    if (phone.length() >= 6 && !backspacingFlag) {
//                        //we will edit. next call on this textWatcher will be ignored
//                        editedFlag = true;
//                        //here is the core. we substring the raw digits and add the mask as convenient
//                        String ans = phone.substring(0, 3) + "-" + phone.substring(3,6) + "-" + phone.substring(6);
//                        formPhone.setText(ans);
//                        //we deliver the cursor to its original position relative to the end of the string
//                        formPhone.setSelection(formPhone.getText().length()-cursorComplement);
//
//                        //we end at the most simple case, when just one character mask is needed
//                        //example: 99999 <- 3+ digits already typed
//                        // masked: (999) 99
//                    } else if (phone.length() >= 3 && !backspacingFlag) {
//                        editedFlag = true;
//                        String ans = phone.substring(0, 3) + "-" + phone.substring(3);
//                        formPhone.setText(ans);
//                        formPhone.setSelection(formPhone.getText().length()-cursorComplement);
//                    }
//                    // We just edited the field, ignoring this cicle of the watcher and getting ready for the next
//                } else {
//                    editedFlag = false;
//                }
//            }
                });


                findViewById(R.id.next).setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){


                        Intent changePassIntent = new Intent(viewProfile.this, changePass.class);
                        startActivity(changePassIntent);

                    }
                });

                findViewById(R.id.back0).setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        Intent menuIntent = new Intent(viewProfile.this, menu.class);
                        startActivity(menuIntent);
                    }
                });

                findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent viewBankAccountIntent = new Intent(viewProfile.this, viewBankAccount.class);
                        startActivity(viewBankAccountIntent);
                    }
                });







    }
}
