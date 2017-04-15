package com.example.calojy.ui6;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class passenger {
    private String email;
    private String phone;
    private String pass;
    private int balance;
    public static List<Integer> bankNumInList = new ArrayList<Integer>(Arrays.<Integer>asList(0));
    private ArrayList<bankAccount> bankAccounts = new ArrayList<>();

    public passenger(String email,String pass,String phone,int balance,int bankNumInList){
        this.email=email;
        this.phone=phone;
        this.pass=pass;
        this.balance=balance;
        this.bankNumInList.add(bankNumInList);
        this.bankAccounts=bankAccounts;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public ArrayList<bankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public boolean addBankAccout(bankAccount bankAccount){
        bankAccounts.add(bankAccount);
        return true;
    }

    public void setPass(String pass) { this.pass = pass;}

    public int getBalance() {
        return balance;
    }

    public void setBalance(int b){this.balance=b;}


}
