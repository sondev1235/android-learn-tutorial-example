package com.example.learn.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.learn.R;

import java.util.ArrayList;

public class NumberActivity extends AppCompatActivity {
    ListView lvSimple;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        init();
        bindData();
    }

    private void bindData() {
        arrayList = new ArrayList<>();
        for(int i=0; i<10; i++){
            arrayList.add(String.valueOf(i));
        }
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        lvSimple.setAdapter(adapter);
    }

    private void init() {
        lvSimple = findViewById(R.id.lv_simple);
    }
}
