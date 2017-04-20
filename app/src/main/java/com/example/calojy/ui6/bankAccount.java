package com.example.calojy.ui6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bankAccount {

    public static String nameB = "",accB="",bankB="";
    public static String[] list = {"Krungsri"};
    public static String[] des = {"123-4-56789-0"};
    public static String[] name1 = {"P"};
    public static Integer[] resId = {R.drawable.iconbank1};
    public static int[] icon ={R.drawable.iconbank1,R.drawable.iconbank2,R.drawable.iconbank3,R.drawable.iconbank4,R.drawable.iconbank5,R.drawable.iconbank6};
    public static String[] nameBank ={"ธนาคารกรุงศรี","ธนาคารทหารไทย","ธนาคารกรุงเทพ","ธนาคารกสิกร","ธนาคารกรุงไทย","ธนาคารไทยพานิชย์"};

    public static List<String> bank_list = new ArrayList<String>(Arrays.asList(list));
    public static List<String> acc_list = new ArrayList<String>(Arrays.asList(des));
    public static List<Integer> resId_list = new ArrayList<Integer>(Arrays.<Integer>asList(resId));
    public static List<String> name_list = new ArrayList<String>(Arrays.asList(name1));
    public static int pos = 0;


    public bankAccount(String bankID,String bankName,String name,int num){
        this.accB= acc_list.get(num);
        this.bankB=bank_list.get(num);
        this.nameB = name_list.get(num);
    }

    public static void addBankaccount(String bankID,String name,int numBank){
        bank_list.add(bankAccount.nameBank[numBank]);
        acc_list.add(bankID);
        name_list.add(name);
        resId_list.add(bankAccount.icon[numBank]);
        pos++;
    }

    public static void deleteBankaccount(int numBank){
        pos--;
        name_list.remove(numBank);
        acc_list.remove(numBank);
        bank_list.remove(numBank);
        resId_list.remove(numBank);
    }

    public String getBankID(int num) {
        return acc_list.get(num);
    }

    public String getBankName(int num) {
        return bank_list.get(num);
    }
}
