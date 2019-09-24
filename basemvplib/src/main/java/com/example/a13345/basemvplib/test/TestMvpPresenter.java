package com.example.a13345.basemvplib.test;

import com.example.a13345.basemvplib.basenet.DisposableUtil;
import com.example.a13345.basemvplib.basepage.RxPresenter;

import io.reactivex.functions.Consumer;

/**
 * Created by zhaoj on 2019/5/15.
 */

public class TestMvpPresenter extends RxPresenter<TestMvpContact.View> implements TestMvpContact.Presenter {

    @Override
    public void getTestUrl() {
        addDisposable(DisposableUtil.getInstance().getSTTime(new Consumer<SerTimStampResBean>() {
            @Override
            public void accept(SerTimStampResBean mSerTimStampResBean) throws Exception {
                mView.getTestUrlSuccess(mSerTimStampResBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mView.showError(throwable.getMessage());
            }
        }));
    }
}
