package com.example.a13345.baselib;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import com.alibaba.android.arouter.facade.annotation.Route;
//import com.alibaba.android.arouter.launcher.ARouter;
import com.example.a13345.baselib.basepage.BaseActivity;
import com.example.a13345.baselib.customview.LoadingDialog;
//import com.luojilab.component.componentlib.router.Router;

/**
 * Created by zhaoj on 2019/5/14.
 */

//@Route(path = "/base/app/TestActivity", group = "base_group")
public class TestActivity extends BaseActivity {

    private TextView tvGo;
    private Button btnShowLoading;

    @Override
    protected void initView() {
        super.initView();
//        ARouter.getInstance().inject(this);
        setAtyCenterTitle("测试首页", true, false);
        tvGo = findViewById(R.id.tvGo);
        btnShowLoading = findViewById(R.id.btnShowLoading);
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        tvGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ARouter.getInstance().build("/base/app/Test2Activity", "base_group").navigation();
            }
        });
        btnShowLoading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimingLoading(5000);
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_test;
    }
}
