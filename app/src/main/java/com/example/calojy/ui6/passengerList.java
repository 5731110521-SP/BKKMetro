package com.example.calojy.ui6;

import java.util.ArrayList;

class passengerList {
    public static ArrayList<passenger> passengerlist = new ArrayList<>();

    public static void initList() {
        if(passengerlist.isEmpty()){
            addInList("test@test.com","555","0123456789",0);
        }
    }

    public static void addInList(String email,String pass,String phone,int balance){
        passengerlist.add(new passenger(email,pass,phone,balance));
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

    public static boolean checkEmailPass(String email,String pass){
        for(int i =0;i<passengerlist.size();i++){
            if (email.equals(passengerlist.get(i).getEmail())
                    && pass.equals(passengerlist.get(i).getPass())) return true;
        }
        return false;
    }

}
