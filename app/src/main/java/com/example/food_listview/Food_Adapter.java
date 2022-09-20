package com.example.food_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Food_Adapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Food> foodList;

    public Food_Adapter(Context context, int layout, List<Food> foodList) {
        this.context = context;
        this.layout = layout;
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);

        TextView textViewTen= (TextView) view.findViewById(R.id.textViewTen);
        TextView textViewMota =(TextView) view.findViewById(R.id.textViewMota);
        ImageView imgView =(ImageView) view.findViewById(R.id.imgView);

        Food food = foodList.get(i);

        textViewTen.setText(food.getTen());
        textViewMota.setText(food.getMoTa());
        imgView.setImageResource(food.getHinh());

        return view;
    }
}
