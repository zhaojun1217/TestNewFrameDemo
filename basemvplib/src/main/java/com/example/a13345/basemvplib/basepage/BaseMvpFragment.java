package com.example.a13345.basemvplib.basepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.a13345.baselib.basepage.BaseFragment;
import com.example.a13345.basemvplib.baseinterface.BasePresenter;
import com.example.a13345.basemvplib.baseinterface.BaseView;

/**
 * Created by zhaoj on 2019/5/15.
 */

public abstract class BaseMvpFragment<T extends BasePresenter> extends BaseFragment implements BaseView {

    protected T mPresenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null) mPresenter.detachView();
        mPresenter = null;
        super.onDestroy();
    }

    protected abstract void initInject();

}
