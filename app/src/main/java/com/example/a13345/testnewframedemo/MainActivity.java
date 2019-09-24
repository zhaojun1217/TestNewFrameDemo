package com.example.a13345.testnewframedemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.commbean.PreviewImgBean;
import com.example.componentservice.testonecomp.Test1Service;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.luojilab.component.componentlib.router.Router;
import com.luojilab.component.componentlib.router.ui.UIRouter;
import com.luojilab.component.componentlib.service.JsonService;
import com.luojilab.router.facade.annotation.RouteNode;

import java.util.ArrayList;

import basemvcpage.BaseMvcActivity;

@RouteNode(path = "/main", desc = "首页")
public class MainActivity extends BaseMvcActivity {
    Fragment fragmentTestDemo3;
    private ViewPager vpPager;
    private TabLayout tbPager;
    private AdapterTestDemo adapterTestDemo;
    private XRecyclerView xrvTest;
    private TextView tvGo, tvOpen, tvClose, tvPreviewPic;
    private AdapterTest adapterTest;

    @Override
    protected int getPageLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initPageView() {
        setAtyCenterTitle("首页", true, false);
        adapterTest = new AdapterTest(mContext);
        vpPager = bindView(R.id.vpPager);
        tbPager = bindView(R.id.tbPager);
        tvGo = bindView(R.id.tvGo);
        tvPreviewPic = bindView(R.id.tvPreviewPic);
        tvOpen = bindView(R.id.tvOpen);
        tvClose = bindView(R.id.tvClose);
        xrvTest = bindView(R.id.xrvTest);
        xrvTest.setArrowImageView(R.mipmap.loading); // 下拉时候的箭头替换图片
        xrvTest.setRefreshProgressStyle(0);
        xrvTest.getDefaultRefreshHeaderView().setRefreshTimeVisible(true);
        xrvTest.setAdapter(adapterTest);
        xrvTest.setLayoutManager(new LinearLayoutManager(mContext));

    }

    @Override
    protected void initPageEvent() {
        tvGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTestActivityWithUri();
            }
        });
        tvOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //                final String URI_LEGAL = "DDComp://testmodleone/TestTwoModleActivity";
                //                UIRouter.getInstance().openUri(mContext, URI_LEGAL, null);
                Router.registerComponent("com.example.picpreview.picpreviewlike.PicPreviewAppLike");
            }
        });
        tvClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router.unregisterComponent("com.example.picpreview.picpreviewlike.PicPreviewAppLike");
            }
        });
        tvPreviewPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPreviewPicActivityWithUri();
            }
        });
    }

    private void goToPreviewPicActivityWithUri() {
        final String URI_LEGAL = "DDComp://picpreview/picPreviewActivity";
        PreviewImgBean previewImgBean = new PreviewImgBean();
        previewImgBean.setName("namename");
        ArrayList<String> testPicList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testPicList.add("http://cn.bing.com/az/hprichbg/rb/TOAD_ZH-CN7336795473_1920x1080.jpg");
        }
        previewImgBean.setPicurls(testPicList);
        Bundle bundle = new Bundle();
        bundle.putString("previewImgBean", JsonService.Factory.getSingletonImpl().toJsonString(previewImgBean));

        UIRouter.getInstance().openUri(mContext, URI_LEGAL, bundle);
    }

    // UI transfer with URI
    private void goToTestActivityWithUri() {
        final String URI_LEGAL = "DDComp://testmodleone/testOneModleActivity";
        UIRouter.getInstance().openUri(mContext, URI_LEGAL, null);
    }

    @Override
    protected void initPageData() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        FragmentTestDemo1 fragmentTestDemo1 = new FragmentTestDemo1();
        FragmentTestDemo2 fragmentTestDemo2 = new FragmentTestDemo2();
        fragments.add(fragmentTestDemo1);
        fragments.add(fragmentTestDemo2);
        Router router = Router.getInstance();
        if (router.getService(Test1Service.class.getSimpleName()) != null) {
            Test1Service service = (Test1Service) router.getService(Test1Service.class.getSimpleName());
            fragmentTestDemo3 = service.getTest1Fragment();
            fragments.add(fragmentTestDemo3);
        }
        adapterTestDemo = new AdapterTestDemo(getSupportFragmentManager(), fragments);
        vpPager.setAdapter(adapterTestDemo);
        tbPager.setupWithViewPager(vpPager);
        vpPager.setOffscreenPageLimit(2);
    }

    long exitTime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), com.example.a13345.baselib.R.string.again_exit, Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
