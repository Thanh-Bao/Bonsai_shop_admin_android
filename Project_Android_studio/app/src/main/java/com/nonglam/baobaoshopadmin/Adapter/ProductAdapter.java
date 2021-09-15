package com.nonglam.baobaoshopadmin.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.nonglam.baobaoshopadmin.R;
import com.nonglam.baobaoshopadmin.model.Product;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {

    private ArrayList<Product> items;
    private Activity activity;

    public ProductAdapter(Activity activity, ArrayList<Product> items){
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
        TextView price = (TextView) view.findViewById(R.id.Pro_Price);
        TextView quantity = (TextView) view.findViewById(R.id.Pro_quantity);
        TextView height = (TextView) view.findViewById(R.id.Pro_height);
        TextView origin = (TextView) view.findViewById(R.id.Pro_Origin);


        tv.setText(items.get(i).getName());
        price.setText("Giá: "+ items.get(i).getPrice()+"");
        quantity.setText("Số Lượng: " + items.get(i).getQuantity()+"");
        height.setText("Chiều Cao: "+items.get(i).getHeight()+"");
        origin.setText("Xuất Xứ: "+items.get(i).getOrigin());
        return view;
    }
}
