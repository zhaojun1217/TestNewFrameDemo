package com.example.a13345.basemvplib.test;

import android.content.Context;

import com.example.a13345.basemvplib.baseinterface.BasePresenter;
import com.example.a13345.basemvplib.baseinterface.BaseView;

import java.util.List;

/**
 * Created by zhaoj on 2019/5/15.
 */

public class TestMvpContact {

    interface View extends BaseView {

        Context getContext();

        void getTestUrlSuccess(SerTimStampResBean mSerTimStampResBean);

    }

    interface Presenter extends BasePresenter<TestMvpContact.View> {

        void getTestUrl();

    }

}
