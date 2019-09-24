package com.example.a13345.basemvplib.test;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.a13345.baselib.baseutil.BaseLibPreUtils;
import com.example.a13345.basemvplib.R;
import com.example.a13345.basemvplib.basepage.BaseMvpActivity;
import com.google.gson.Gson;


//@Route(path = "/lib/mvp/TestMvpActivity")
public class TestMvpActivity extends BaseMvpActivity<TestMvpPresenter> implements TestMvpContact.View {

    private TextView tvGetInfo;
    private Button btnGetInfo;

    @Override
    protected void initView() {
        super.initView();
        setAtyCenterTitle("ACTIVITY_MVP_TEST", true, false);

        tvGetInfo = findViewById(R.id.tvGetInfo);
        btnGetInfo = findViewById(R.id.btnGetInfo);
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        tvGetInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getTestUrl();
                showTimingLoading(3333);
            }
        });
        btnGetInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SerTimStampResBean testBean = BaseLibPreUtils.getEntityInfo(mContext, "test");
                tvGetInfo.setText("这里是新取出来滴数据 : " + testBean.getTimeTimeStamp());
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_mvp_test;
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initInject() {
        mPresenter = new TestMvpPresenter();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void getTestUrlSuccess(SerTimStampResBean mSerTimStampResBean) {
        String s = new Gson().toJson(mSerTimStampResBean);
        tvGetInfo.setText(s);
        BaseLibPreUtils.saveEntityInfo(mContext, mSerTimStampResBean, "test");
    }
}
