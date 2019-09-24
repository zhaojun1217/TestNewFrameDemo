package com.example.componentservice;

import android.view.View;

//import com.alibaba.android.arouter.facade.annotation.Route;
//import com.alibaba.android.arouter.launcher.ARouter;
import com.example.a13345.baselib.basepage.BaseActivity;

//@Route(path = "/com/MainActivity")
public class MainActivity extends BaseActivity {

    @Override
    protected void initView() {
        super.initView();

//        ARouter.getInstance().inject(this);
        findViewById(R.id.tvHelloWorld).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ARouter.getInstance().build("/com/TestComActivity").navigation(MainActivity.this);
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }
}
