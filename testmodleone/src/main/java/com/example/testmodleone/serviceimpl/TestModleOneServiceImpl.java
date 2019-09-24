package com.example.testmodleone.serviceimpl;

import android.support.v4.app.Fragment;

import com.example.componentservice.testonecomp.Test1Service;
import com.example.testmodleone.TestModleOneFragment;

/**
 * Created by zhaoj on 2019/5/22.
 */

public class TestModleOneServiceImpl implements Test1Service{
    @Override
    public Fragment getTest1Fragment() {
        return new TestModleOneFragment();
    }
}
