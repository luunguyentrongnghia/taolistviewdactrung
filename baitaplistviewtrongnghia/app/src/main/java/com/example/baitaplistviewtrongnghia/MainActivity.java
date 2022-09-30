package com.example.baitaplistviewtrongnghia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView;
        button = (Button) findViewById(R.id.btm);

        context = this;
        ArrayList<Item>arrayList;
        itemAdapter adapter;
        listView=findViewById(R.id.lv);
        arrayList=new ArrayList<>();
        arrayList.add(new Item("item1","item1",R.drawable.anhoto));
        arrayList.add(new Item("item1","item1",R.drawable.anhoto));

        adapter=new itemAdapter(MainActivity.this,R.layout.list_item,arrayList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent ,View view ,int position , long id){
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(new Item("item1","item1",R.drawable.anhoto));
                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent ,View view ,int position , long id) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setTitle("xac nhan");
                dialog.setMessage("ban co dong y xoa khong");
                dialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        arrayList.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
               dialog.setNegativeButton("no", null);
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
                return false;
            }
        });

    }
}