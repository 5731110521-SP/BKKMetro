package com.example.calojy.ui6;


public class passenger {
    private String email;
    private String phone;
    private String pass;
    private int balance;

    public passenger(String email,String pass,String phone,int balance){
        this.email=email;
        this.phone=phone;
        this.pass=pass;
        this.balance=balance;
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

    public void setPass(String pass) { this.pass = pass;}

    public int getBalance() {
        return balance;
    }

    public void setBalance(int b){this.balance=b;}

}
