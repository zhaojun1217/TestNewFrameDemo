package com.example.a13345.basemvplib.basenet;

import com.example.a13345.basemvplib.basemvpbean.PostCommonBean;
import com.example.a13345.basemvplib.test.SerTimStampResBean;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by $zhao on 2018/11/22.
 */

public class DisposableUtil {

    private static DisposableUtil disposableUtil;

    public static DisposableUtil getInstance() {
        if (disposableUtil == null) {
            synchronized (DisposableUtil.class) {
                if (disposableUtil == null) {
                    disposableUtil = new DisposableUtil();
                }
            }
        }
        return disposableUtil;
    }

    /**
     * getSTTime
     */
    public Disposable getSTTime(final Consumer<SerTimStampResBean> success, final Consumer<Throwable> error) {
        return RetrofitHelper.getRequestNetApi()
                .getSTTime()
                .compose(RxThreadTransformer.<PostCommonBean<SerTimStampResBean>>transformerSubThread())
                .compose(RxThreadTransformer.<PostCommonBean<SerTimStampResBean>>transformerUIThread())
                .compose(RxThreadTransformer.<SerTimStampResBean>handleRes())
                .subscribe(new SuccessConsumer<SerTimStampResBean>(success), new ErrorConsumer<Throwable>(error));
    }
}
