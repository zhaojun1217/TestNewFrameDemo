package com.example.a13345.testnewframedemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by zhaoj on 2019/5/21.
 */

public class AdapterTestDemo extends FragmentStatePagerAdapter {

    ArrayList<Fragment> fragments;
    String[] strings = {"测试F1", "测试F2", "测试F3"};

    public AdapterTestDemo(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    public AdapterTestDemo(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings[position];
    }
}
