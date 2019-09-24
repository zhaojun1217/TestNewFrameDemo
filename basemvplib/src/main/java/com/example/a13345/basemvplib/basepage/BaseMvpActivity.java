package com.example.a13345.basemvplib.basepage;

import android.os.Bundle;

import com.example.a13345.baselib.basepage.BaseActivity;
import com.example.a13345.basemvplib.baseinterface.BasePresenter;
import com.example.a13345.basemvplib.baseinterface.BaseView;

/**
 * Created by zhaoj on 2019/5/15.
 */

public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView {

    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initInject();
        if (mPresenter != null){
            mPresenter.attachView(this);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    protected abstract void initInject();

}
