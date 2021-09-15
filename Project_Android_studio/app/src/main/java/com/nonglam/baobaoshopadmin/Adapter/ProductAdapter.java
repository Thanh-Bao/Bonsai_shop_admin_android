package com.nonglam.baobaoshopadmin.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nonglam.baobaoshopadmin.R;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {

    private ArrayList<String> items;
    private Activity activity;

    public ProductAdapter(Activity activity, ArrayList<String> items){
    this.activity = activity;
    this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.item_product, null);

        TextView tv = (TextView) view.findViewById(R.id.tv_name);
        tv.setText(items.get(i));
        return view;
    }
}
