package com.example.android.tutorial.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.android.tutorial.R;
import com.example.android.tutorial.adapter.ViewPageAdapter;
import com.example.android.tutorial.fragment.BlankFragment;
import com.example.android.tutorial.fragment.OneFragment;

public class TransFactActivity extends AppCompatActivity {
    ViewPager viewPager;
    OneFragment oneFragment;
    BlankFragment blankFragment;
    ViewPageAdapter adapter;
    TabLayout tableLayout; //options

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans_fact);
        init();
    }

    private void init() {
        viewPager = findViewById(R.id.view_pager);
        tableLayout = findViewById(R.id.tab_layout);

        oneFragment = new OneFragment();
        blankFragment = new BlankFragment();

        adapter = new ViewPageAdapter(getSupportFragmentManager());
        adapter.addFragment("Contact",oneFragment);
        adapter.addFragment("Info",blankFragment);
        viewPager.setAdapter(adapter);
        tableLayout.setupWithViewPager(viewPager);  // if tablayout
    }
}
