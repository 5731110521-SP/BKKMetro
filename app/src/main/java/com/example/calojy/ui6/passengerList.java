package com.example.calojy.ui6;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class passengerList {

    public static ArrayList<passenger> passengerlist = new ArrayList<>();

    public static passenger currentUser;
    public static int current;

    public static void initList() {
        if(passengerlist.isEmpty()){
<<<<<<< HEAD
            ArrayList<bankAccount> bankAccounts = new ArrayList<>();
            bankAccounts.add(new bankAccount("123-4-56789-0","ธนาคารกสิกร"));
            addInList("a","a","012-345-6789",0,bankAccounts);

            passengerlist.get(0).addTopup(new topup(300,bankAccounts.get(0).getBankName(),bankAccounts.get(0).getBankID(),"11/04/2017"));
            passengerlist.get(0).addTopup(new topup(100,bankAccounts.get(0).getBankName(),bankAccounts.get(0).getBankID(),"12/04/2017"));
            passengerlist.get(0).addTopup(new topup(100,bankAccounts.get(0).getBankName(),bankAccounts.get(0).getBankID(),"16/04/2017"));


            passengerlist.get(0).addTrip(new trip("00/00/0000"));
            passengerlist.get(0).addTrip(new trip("11/04/2017"));
            passengerlist.get(0).addTrip(new trip("15/04/2017"));
            passengerlist.get(0).addTrip(new trip("16/04/2017"));
            passengerlist.get(0).addTrip(new trip("17/04/2017"));
            passengerlist.get(0).addTrip(new trip("17/04/2017"));

=======
            //String bankID,String bankName,String name,int num
            //bankAccount.addBankaccount("123-4-56789-0","dd",3);
            addInList("test@test.com","555","012-345-6789",100,bankAccount.pos);
>>>>>>> refs/remotes/origin/master
        }
    }

    public static void addInList(String email,String pass,String phone,int balance,int bankNumInList){
        passengerlist.add(new passenger(email,pass,phone,balance,bankNumInList));
        login(email,pass);
    }

    public static boolean checkEmailInList(String email){
        for(int i =0;i<passengerlist.size();i++){
            if (email.equals(passengerlist.get(i).getEmail()))return true;
        }
        return false;
    }

    public static boolean checkPhoneInList(String phone){
        for(int i =0;i<passengerlist.size();i++){
            if (phone.equals(passengerlist.get(i).getPhone()))return true;
        }
        return false;
    }

    public static boolean login(String email,String pass){
        initList();
        for(int i =0;i<passengerlist.size();i++){
            if (email.equals(passengerlist.get(i).getEmail())
                    && pass.equals(passengerlist.get(i).getPass())){
                currentUser=passengerlist.get(i);
                current=i;
                return true;
            }
        }
        return false;
    }

}
