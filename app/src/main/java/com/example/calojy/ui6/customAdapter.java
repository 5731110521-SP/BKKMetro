package com.example.calojy.ui6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Palid on 4/14/2017.
 */

public class customAdapter extends BaseAdapter {
    Context mContext;
    //String[] strName;
    //String[] des;
    //int[] resId;
    private List<String> strName;
    private List<String> des;
    private List<Integer> resId;

    public customAdapter(Context context, List<String> strName, List<Integer> resId,List<String> des) {
        this.mContext= context;
        this.strName = strName;
        this.resId = resId;
        this.des = des;
    }

    public int getCount() {
        return strName.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater mInflater =
                (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(view == null)
            view = mInflater.inflate(R.layout.singlerow, parent, false);

        TextView textView = (TextView)view.findViewById(R.id.textView1);
        textView.setText(strName.get(position));

        //datry1
        TextView textView1 = (TextView)view.findViewById(R.id.textView2);
        textView1.setText(des.get(position));
        //

        ImageView imageView = (ImageView)view.findViewById(R.id.imageView1);
        imageView.setBackgroundResource(resId.get(position));

        return view;
    }
}
