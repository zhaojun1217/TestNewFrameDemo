package com.example.testmodleone;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.example.a13345.basemvplib.basepage.BaseMvpActivity;
import com.example.testmodleone.R;
import com.example.testmodleone.TestModleOneFragment;
import com.luojilab.component.componentlib.service.AutowiredService;
import com.luojilab.router.facade.annotation.RouteNode;

@RouteNode(path = "/TestTwoModleActivity", desc = "测试的第er个activity")
public class TestTwoModleActivity extends BaseMvpActivity {

    Fragment fragment;
    FragmentTransaction ft;

    @Override
    protected int getLayout() {
        return R.layout.activity_test_two_modle;
    }

    @Override
    protected void initView() {
        super.initView();
        // 自动装载 项目执行build，会生成apt文件，具体可在build目录下面查看 同时还会在根目录生成UIRouterTable文件夹，里面会列出每个组件向外提供的路由表
        AutowiredService.Factory.getSingletonImpl().autowire(this);
        setAtyCenterTitle("测试二跳转页面", true, true);
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void showError(String msg) {

    }
}
