package com.example.calojy.ui6;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Date;


public class CustomAdapterSummary extends ArrayAdapter<String> {

    private Activity context;
    public ArrayList<String> itemname;
    public ArrayList<Integer> imgid;
    public ArrayList<String> bankname;
    public ArrayList<String> banknum;
    private Integer n;

    public CustomAdapterSummary(Activity context, ArrayList<String> itemname, ArrayList<Integer> imgid, ArrayList<String> bankname, ArrayList<String> banknum, Integer n) {
        super(context, R.layout.mylist, itemname);
        this.context=context;
    //    this.itemname=Transaction.itemm;
     //   this.imgid=Transaction.imgidd;
        this.itemname=itemname;
        this.imgid=imgid;
        this.n=n;
        this.bankname=bankname;
        this.banknum=banknum;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);
        View rowView2=inflater.inflate(R.layout.mylist2, null,true);


        String[] date = {"05/02/2017","14/03/2017"};
        String[] week = {"30/01/2017 - 05/02/2017","13/03/2017 - 19/03/2017","17/04/2017 - 23/04/2017"};
        String[] month = {"กุมภาพันธ์ ","มีนาคม ","เมษายน "};
        String[] money = {"16 บาท","32 บาท","132 บาท"};
        String[] x = {"                                                                ","                                      ",
                        "                                                                        "};



        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        TextView txtTitle2 = (TextView) rowView2.findViewById(R.id.header);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.itemname);


     /*   if(this.itemname.get(position).contains("/")){
            txtTitle2.setText(this.itemname.get(position));
            txtTitle2.setTextSize(17);
            txtTitle2.setTextColor(Color.parseColor("FF024B51"));
            return rowView2;
        }else if(this.itemname.get(position).contains("เติมเงิน")){
            txtTitle.setText(itemname.get(position));
            imageView.setImageResource(imgid.get(position));
            extratxt.setTextColor(Color.parseColor("#FF809293"));
            extratxt.setText(" บัญชีธนาคาร: ไทยพาณิชย์\n หมายเลขบัญชี: 123-456789-0\n");
        }else if(this.itemname.get(position).contains("ชำระค่าโดยสาร")){
            txtTitle.setText(itemname.get(position));
            imageView.setImageResource(imgid.get(position));
            txtTitle.setTextColor(Color.parseColor("#FFFE545D"));
            extratxt.setTextColor(Color.parseColor("#FF809293"));
            extratxt.setText(" สถานีต้นทาง: สามย่าน                          7:30" +
                    "\n สถานีปลายทาง: บางซื่อ                        7:55\n");
        }*/



        if(/*n==1&&position==0*/itemname.get(position).contains("/")){
            txtTitle2.setTextColor(Color.parseColor("#FF024B51"));
            txtTitle2.setTextSize(17);
            txtTitle2.setText(itemname.get(position));
          //  txtTitle2.setText(date[0]+x[0]);
           return rowView2;
        }
        /*else if(n==1&&position==4){
            txtTitle2.setTextColor(Color.parseColor("#FF024B51"));
            txtTitle2.setTextSize(17);
            txtTitle2.setText(date[1]+x[0]);
            return rowView2;
        }else if(n==2&&position==0){
            txtTitle2.setTextColor(Color.parseColor("#FF024B51"));
            txtTitle2.setTextSize(17);
            txtTitle2.setText(week[0]+x[1]);
            return rowView2;
        }else if(n==2&&position==4){
            txtTitle2.setTextColor(Color.parseColor("#FF024B51"));
            txtTitle2.setTextSize(17);
            txtTitle2.setText(week[1]+x[1]);
            return rowView2;
        }else if(n==3&&position==0){
            txtTitle2.setTextColor(Color.parseColor("#FF024B51"));
            txtTitle2.setTextSize(17);
            txtTitle2.setText(month[0]+x[2]);
            return rowView2;
        }else if(n==3&&position==4){
            txtTitle2.setTextColor(Color.parseColor("#FF024B51"));
            txtTitle2.setTextSize(17);
            txtTitle2.setText(month[1]+x[2]);
            return rowView2;
        }*/

        if(/*(n==1||n==2||n==3) && (position==1 ||position==5)*/itemname.get(position).contains("เติมเงิน")){
            txtTitle.setText(itemname.get(position));
            imageView.setImageResource(imgid.get(position));
            extratxt.setTextColor(Color.parseColor("#FF809293"));
            extratxt.setText(" บัญชีธนาคาร: "+bankname.get(position)+"\n หมายเลขบัญชี: "+banknum.get(position)+"\n");
        }else if(/*(n==1||n==3||n==2) && (position==2||position==3||position==6||position==7)*/itemname.get(position).contains("ชำระค่าโดยสาร")){
                txtTitle.setText(itemname.get(position));
                imageView.setImageResource(imgid.get(position));
                txtTitle.setTextColor(Color.parseColor("#FFFE545D"));
                extratxt.setTextColor(Color.parseColor("#FF809293"));
                extratxt.setText(" สถานีต้นทาง: สามย่าน                          7:30" +
                        "\n สถานีปลายทาง: บางซื่อ                        7:55\n");
        }

        return rowView;

    };
}