package com.example.learn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.learn.activity.ContactActivity;
import com.example.learn.activity.NumberActivity;
import com.example.learn.activity.TransFactActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnSimple, btnCustome,btnViewPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addEvent();
    }

    private void init(){
        btnSimple = findViewById(R.id.btn_simple);
        btnCustome = findViewById(R.id.btn_custome);
        btnViewPage = findViewById(R.id.btn_viewpage);
    }

    private void addEvent() {
        btnSimple.setOnClickListener(new myClickButton());
        btnCustome.setOnClickListener(new myClickButton());
        btnViewPage.setOnClickListener(new myClickButton());
    }

    private class myClickButton implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_simple:
                    intent = new Intent(MainActivity.this, NumberActivity.class);
                    break;
                case R.id.btn_custome:
                    intent = new Intent(MainActivity.this, ContactActivity.class);
                    break;
                case R.id.btn_viewpage:
                    intent = new Intent(MainActivity.this, TransFactActivity.class);
                    break;
                    default:
                        break;
            }
            startActivity(intent);
        }
    }
}
