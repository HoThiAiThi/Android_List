package com.example.food_listview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvFood;
    Food_Adapter adapter;
    ArrayList<Food> arrayFood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();
        adapter = new Food_Adapter(this,R.layout.activity_loai_food,arrayFood);
        lvFood.setAdapter(adapter);
        lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,Profile.class);
                startActivity(intent);
            }
        });
        lvFood.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                XacNhanXoa(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    private void anhXa() {
        lvFood =(ListView) findViewById(R.id.lvFood);
        arrayFood = new ArrayList<>();
        arrayFood.add(new Food("Cơm chiên dương châu","Ngon",R.drawable.com));
        arrayFood.add(new Food("Lẩu","Ngon",R.drawable.lau));
        arrayFood.add(new Food("Mì xào","Ngon",R.drawable.mi_xao));
        arrayFood.add(new Food("Rau xào","Ngon",R.drawable.rau_xao));
        arrayFood.add(new Food("Gà chiên mắm","Ngon",R.drawable.ga));
    }

    private void XacNhanXoa(int position){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thông báo!");
        alertDialog.setIcon(R.drawable.ic_baseline_info_24);
        alertDialog.setMessage("Bạn có muốn xóa không? ");
        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayFood.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();

    }
}