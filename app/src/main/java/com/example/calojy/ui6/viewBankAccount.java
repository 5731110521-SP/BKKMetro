package com.example.calojy.ui6;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class viewBankAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bank_account);

        final customAdapter adapter =new customAdapter(getApplicationContext(), passengerList.bank_list, passengerList.resId_list, passengerList.des_list);
        //final customAdapter adapter1 = new customAdapter(getApplicationContext(), passengerList.list, passengerList.resId, passengerList.des);
        ListView listView = (ListView)findViewById(R.id.listview1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Intent intent;
                passengerList.nameB = passengerList.name_list.get(arg2);
                passengerList.accB = passengerList.des_list.get(arg2);
                passengerList.bankB = passengerList.bank_list.get(arg2);
                intent = new Intent(getApplicationContext(), viewBank.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.addButton).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //passengerList.bank_list.add("Da");
                //passengerList.resId_list.add(R.drawable.iconbank1);
                //passengerList.des_list.add("11111111111111");
                Intent addBank = new Intent(viewBankAccount.this, addBankaccount.class);
                startActivity(addBank);
                adapter.notifyDataSetChanged();
            }
        });


    }
}
