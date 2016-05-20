package com.yy.zbase.lianliankan;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by Administrator on 2016/4/21.
 */
public class MainAdapter extends BaseAdapter {
    private Context context;

    private List<String> resultList=new ArrayList<>();
    private String[] result=new String[36];
    private TextView[] resultView=new TextView[36];

    public MainAdapter(Context context){
        this.context=context;

        List<String> list=new ArrayList<>();
        String[] array=new String[]{"1","2","3","4","5","6"};
        for(int i=0;i<6;i++) {
            Set<String> set=new HashSet<>();
            for (String data : array) {
                set.add(data);
            }
            list.addAll(set);
        }



        for(int i=0;i<36;i++) {
            Random random=new Random(System.currentTimeMillis());
            int size = list.size();
            int nextInt = random.nextInt(size);
            String str = list.get(nextInt);
            resultList.add(str);
            list.remove(nextInt);
        }


    }

    @Override
    public int getCount() {
        return 36;
    }

    @Override
    public Object getItem(int position) {
        return resultView[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Button button=new Button(this.context);
        button.setText("btn"+position);
//
//        return button;





        TextView textView=new TextView(this.context);
        textView.setHeight(100);
        textView.setText(resultList.get(position));
        resultView[position]=textView;
        return textView;
    }
}
