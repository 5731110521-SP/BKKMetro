package com.example.calojy.ui6;


import java.util.ArrayList;

public class passenger {
    private String email;
    private String phone;
    private String pass;
    private int balance;
    private ArrayList<bankAccount> bankAccounts;
    private ArrayList<topup> topups;
    private ArrayList<trip> trips;

    public passenger(String email,String pass,String phone,int balance,ArrayList<bankAccount> bankAccounts){
        this.email=email;
        this.phone=phone;
        this.pass=pass;
        this.balance=balance;
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
}
