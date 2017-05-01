package com.example.calojy.ui6;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class passenger {
    private String name;
    private String id;
    private String email;
    private String phone;
    private String pass;
    private int balance;
    private int day;
    private  String dayex;
    private ArrayList<topup> topups;
    private ArrayList<trip> trips;
    public static List<Integer> bankNumInList = new ArrayList<Integer>(Arrays.<Integer>asList(0));
    private ArrayList<bankAccount> bankAccounts = new ArrayList<>();

    public passenger(String email,String pass,String phone,int balance,int bankNumInList,String name,String id){
        this.name=name;
        this.id=id;
        this.email=email;
        this.phone=phone;
        this.pass=pass;
        this.balance=balance;
        day=0;
        this.bankNumInList.add(bankNumInList);
        this.bankAccounts=bankAccounts;
        topups = new ArrayList<>();
        trips = new  ArrayList<>();
    }

    public boolean addTopup(topup topup){
        topups.add(topup);
        return true;
    }

    public boolean addTrip(trip trip){
        trips.add(trip);
        return true;
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

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
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

    public ArrayList<topup> getTopups() {
        return topups;
    }

    public ArrayList<trip> getTrips() {
        return trips;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
        SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        date.setTime(date.getTime()+day*24*60*60*1000);
        this.dayex = currentDate.format(date);
    }

    public String getDayex() {
        return dayex;
    }

}
