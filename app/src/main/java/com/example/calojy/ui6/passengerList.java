package com.example.calojy.ui6;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class passengerList {

    public static ArrayList<passenger> passengerlist = new ArrayList<>();
    public static String nameB = "",accB="",bankB="";
    public static String[] list = {"Krungsri"};
    public static String[] des = {"1234567890"};
    public static String[] name1 = {"P"};
    public static Integer[] resId = {R.drawable.iconbank1};
    public static int[] icon ={R.drawable.iconbank1,R.drawable.iconbank2,R.drawable.iconbank3,R.drawable.iconbank4,R.drawable.iconbank5,R.drawable.iconbank6};
    public static String[] nameBank ={"Krungsri","TMB","Krungthep","Kasikorn","Krungthai","Thaipanit"};
    public static List<String> bank_list = new ArrayList<String>(Arrays.asList(list));
    public static List<String> des_list = new ArrayList<String>(Arrays.asList(des));
    public static List<Integer> resId_list = new ArrayList<Integer>(Arrays.<Integer>asList(resId));
    public static List<String> name_list = new ArrayList<String>(Arrays.asList(name1));
    public static int pos = 1;



    public static void initList() {
        if(passengerlist.isEmpty()){
            addInList("test@test.com","555","0123456789",0);
        }
    }

    public static void addInList(String email,String pass,String phone,int balance){
        passengerlist.add(new passenger(email,pass,phone,balance));
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
