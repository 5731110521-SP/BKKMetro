package com.example.calojy.ui6;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * Created by ice on 19-Apr-17.
 */

public class trip {
    private String date;
    private int fare;
    private String origin;
    private String terminal;
    private String starttime;
    private String endtime;

    public trip(){
        fare=42;
        origin="สามย่าน";
        terminal="บางซื่อ";
        Date today = new Date();
        SimpleDateFormat s = new SimpleDateFormat("HH:mm");
        starttime= s.format(today.getTime());

        SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        this.date = currentDate.format(date);
    }

    public trip(int fare){
        this.fare=fare;
        SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        this.date = currentDate.format(date);
    }

    public trip(String date){
        this.date=date;
        fare=42;
    }

    public trip(String date,int fare){
        this.date=date;
        this.fare=fare;
    }

    public void checkout(){
        Date today = new Date();
        SimpleDateFormat s = new SimpleDateFormat("HH:mm");
        endtime= s.format(today.getTime());
    }

    public int getFare() {
        return fare;
    }

    public String getEndtime() {
        return endtime;
    }

    public String getOrigin() {
        return origin;
    }

    public String getStarttime() {
        return starttime;
    }

    public String getTerminal() {
        return terminal;
    }

    public String getDate() {
        return date;
    }
}
