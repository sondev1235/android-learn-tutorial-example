package com.example.android.tutorial.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPageAdapter extends FragmentStatePagerAdapter {
    List<String> arrTitle = null;
    List<Fragment> arrFragment = null;

    public ViewPageAdapter(FragmentManager fm) {
        super(fm);
        arrTitle = new ArrayList<>();
        arrFragment = new ArrayList<>();
    }

    public void addFragment(String title,Fragment fm){
        arrTitle.add(title);
        arrFragment.add(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return arrFragment.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return arrTitle.get(position);
    }

    @Override
    public int getCount() {
        return arrTitle.size();
    }
}