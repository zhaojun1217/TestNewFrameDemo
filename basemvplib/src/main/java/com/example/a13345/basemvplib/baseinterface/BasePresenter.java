package com.example.a13345.basemvplib.baseinterface;

import com.example.a13345.basemvplib.baseinterface.BaseView;

/**
 * Created by zhaoj on 2019/5/15.
 */

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();

}
