package com.example.a13345.baselib;

import android.view.View;
import android.widget.Button;

//import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.a13345.baselib.basepage.BaseActivity;

/**
 * Created by zhaoj on 2019/5/14.
 */
//@Route(path = "/base/app/Test2Activity", group = "base_group")
public class Test2Activity extends BaseActivity {

    private Button btnBack;

    @Override
    protected void initView() {
        super.initView();
        setAtyCenterTitle("Second", true, true);
        btnBack = findViewById(R.id.btnBack);
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressedSupport();
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_test2;
    }
}
