package com.example.a13345.testnewframedemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.componentservice.testonecomp.Test1Service;
import com.luojilab.component.componentlib.router.Router;
import com.luojilab.router.facade.annotation.RouteNode;

import java.util.ArrayList;

import basemvcpage.BaseMvcActivity;

/**
 * Created by zhaoj on 2019/5/21.
 */

@Route(path = "/test/com/TestSecondActivity", group = "test_group")
//@RouteNode(path = "/main", desc = "首页")
public class SecondActivity extends BaseMvcActivity {
    Fragment fragmentTestDemo2;
    private ViewPager vpPager;
    private TabLayout tbPager;
    private AdapterTestDemo adapterTestDemo;

    @Override
    protected int getPageLayout() {
        return R.layout.activity_testdemo_second;
    }

    @Override
    protected void initPageView() {
        ARouter.getInstance().inject(this);
        setAtyCenterTitle("TestSecondActivity", true, true);
        vpPager = bindView(R.id.vpPager);
        tbPager = bindView(R.id.tbPager);
    }

    @Override
    protected void initPageEvent() {

    }

    @Override
    protected void initPageData() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        FragmentTestDemo1 fragmentTestDemo1 = new FragmentTestDemo1();
        fragments.add(fragmentTestDemo1);
        Router router = Router.getInstance();
        if (router.getService(Test1Service.class.getSimpleName()) != null) {
            Test1Service service = (Test1Service) router.getService(Test1Service.class.getSimpleName());
            fragmentTestDemo2 = service.getTest1Fragment();
            fragments.add(fragmentTestDemo2);
        }
        adapterTestDemo = new AdapterTestDemo(getSupportFragmentManager(), fragments);
        vpPager.setAdapter(adapterTestDemo);
        tbPager.setupWithViewPager(vpPager);
        vpPager.setOffscreenPageLimit(2);
    }

}
