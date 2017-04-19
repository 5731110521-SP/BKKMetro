package com.example.calojy.ui6;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ice on 19-Apr-17.
 */

public class topup {
    private String date;
    private int amount;
    private String bank;
    private String banknumber;

    public topup(int amount,String bank,String banknumber){
        SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
        Date todayDate = new Date();
        this.date = currentDate.format(todayDate);
        this.amount = amount;
        this.bank = bank;
        this.banknumber=banknumber;
    }

    public topup(int amount,String bank,String banknumber,String date){
        this.date = date;
        this.amount = amount;
        this.bank = bank;
        this.banknumber=banknumber;
    }

    public int getAmount() {
        return amount;
    }

    public String getBank() {
        return bank;
    }

    public String getBanknumber() {
        return banknumber;
    }

    public String getDate() {
        return date;
    }
}
