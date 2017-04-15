package com.example.calojy.ui6;

import java.util.ArrayList;

class passengerList {
    public static ArrayList<passenger> passengerlist = new ArrayList<>();
    public static passenger currentUser;

    public static void initList() {
        if(passengerlist.isEmpty()){
            ArrayList<bankAccount> bankAccounts = new ArrayList<>();
            bankAccounts.add(new bankAccount("123-4-56789-0","ธนาคารกสิกร"));
            addInList("test@test.com","555","012-345-6789",0,bankAccounts);
        }
    }

    public static void addInList(String email,String pass,String phone,int balance,ArrayList<bankAccount> bankAccounts){
        passengerlist.add(new passenger(email,pass,phone,balance,bankAccounts));
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
        for(int i =0;i<passengerlist.size();i++){
            if (email.equals(passengerlist.get(i).getEmail())
                    && pass.equals(passengerlist.get(i).getPass())){
                currentUser=passengerlist.get(i);
                return true;
            }
        }
        return false;
    }

}
