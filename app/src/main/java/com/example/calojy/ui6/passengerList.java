package com.example.calojy.ui6;

import java.util.ArrayList;

class passengerList {
    public static ArrayList<passenger> passengerlist = new ArrayList<>();

    public static void initList() {
        if(passengerlist.isEmpty()){
            addInList("test@test.com","555","0123456789");
        }
    }

    public static void addInList(String email,String pass,String phone){
        passengerlist.add(new passenger(email,pass,phone));
    }

    public static boolean checkInList(String email,String phone){
        for(int i =0;i<passengerlist.size();i++){
            if (email.equals(passengerlist.get(i).getEmail()))return true;
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
