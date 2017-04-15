package com.example.calojy.ui6;

public class bankAccount {
    private String bankID;
    private String bankName;

    public bankAccount(String bankID,String bankName){
        this.bankID=bankID;
        this.bankName=bankName;
    }

    public String getBankID() {
        return bankID;
    }

    public String getBankName() {
        return bankName;
    }
}
