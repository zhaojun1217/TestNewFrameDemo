package com.example.testmodleone;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.Toast;

import com.example.a13345.baselib.baseutil.ToastUtil;
import com.example.a13345.basemvplib.basepage.BaseMvpActivity;
import com.luojilab.component.componentlib.service.AutowiredService;
import com.luojilab.router.facade.annotation.Autowired;
import com.luojilab.router.facade.annotation.RouteNode;

@RouteNode(path = "/testOneModleActivity", desc = "测试的第一个activity")
public class TestOneModleActivity extends BaseMvpActivity {
    // 注意此处的参数需要设置为非private，否则编译会直接报错
    //    @Autowired
    //    String bookName;

    Fragment fragment;
    FragmentTransaction ft;

    @Override
    protected int getLayout() {
        return R.layout.activity_test_one_modle;
    }

    @Override
    protected void initView() {
        super.initView();
        // 自动装载 项目执行build，会生成apt文件，具体可在build目录下面查看 同时还会在根目录生成UIRouterTable文件夹，里面会列出每个组件向外提供的路由表
        AutowiredService.Factory.getSingletonImpl().autowire(this);
        ft = getSupportFragmentManager().beginTransaction();
        fragment = new TestModleOneFragment();
        ft.add(R.id.tab_content, fragment).commitAllowingStateLoss();
        //        ToastUtil.showShort(mContext, bookName);
        setAtyCenterTitle("测试一跳转页面", true, true);
    }

    @Override
    protected void initEvent() {
        super.initEvent();

    }

    @Override
    protected void initInject() {

    }

    @Override
    public void showError(String msg) {

    }

    //    long exitTime;
    //
    //    @Override
    //    public boolean onKeyDown(int keyCode, KeyEvent event) {
    //        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
    //            if ((System.currentTimeMillis() - exitTime) > 2000) {
    //                Toast.makeText(getApplicationContext(), com.example.a13345.baselib.R.string.again_exit, Toast.LENGTH_SHORT).show();
    //                exitTime = System.currentTimeMillis();
    //            } else {
    //                finish();
    //                System.exit(0);
    //            }
    //            return true;
    //        }
    //        return super.onKeyDown(keyCode, event);
    //    }

}
