package com.example.a13345.basemvplib.basenet;

import android.text.TextUtils;

import com.example.a13345.baselib.app.Constans;
import com.example.a13345.basemvplib.basemvpbean.PostCommonBean;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by $zhao on 2018/11/22.
 */

public class RxThreadTransformer {

    public RxThreadTransformer() {

    }

    /**
     * 线程切换到子线程
     */
    public static <T> ObservableTransformer<T, T> transformerSubThread() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(Schedulers.io());
            }
        };
    }

    /**
     * 线程切换到UI线程
     */
    public static <T> ObservableTransformer<T, T> transformerUIThread() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 统一处理返回信息
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<PostCommonBean<T>, T> handleRes() {
        return new ObservableTransformer<PostCommonBean<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<PostCommonBean<T>> upstream) {
                return upstream.flatMap(new Function<PostCommonBean<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(PostCommonBean<T> tPostCommonBean) throws Exception {

                        if (tPostCommonBean.getCode() == Constans.Mvp.NET_SUCCESS) {
                            if (tPostCommonBean.getDesc() != null && tPostCommonBean.getDesc().contains("个订单已被绑定，不可作废！")) {
                                return Observable.error(new Exception(tPostCommonBean.getDesc()));
                            }
                            Logger.json(new Gson().toJson(tPostCommonBean));
                            return createData(tPostCommonBean.getData());
                        } else if (tPostCommonBean.getCode() == 302) {
                            return Observable.error(new Exception(tPostCommonBean.getDesc() + Constans.Mvp.ERROR302));
                        } else if (tPostCommonBean.getCode() == 990008) {
                            return Observable.error(new Exception("登录信息过期"));
                        } else if (!TextUtils.isEmpty(tPostCommonBean.getDesc())) {
                            Logger.e("*" + tPostCommonBean.getDesc() + "==" + tPostCommonBean.getCode());
                            return Observable.error(new Exception(tPostCommonBean.getDesc()));
                        } else {
                            return Observable.error(new Exception("*" + "服务器返回error"));
                        }
                    }
                });
            }
        };
    }

    public static <T> Observable<T> createData(final T t) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> e) throws Exception {
                try {
                    e.onNext(t);
                    e.onComplete();
                } catch (Exception var3) {
                    e.onError(var3);
                }
            }
        });


    }

    /**
     * 替换背压(rxjava2特性 暂时不知道干什么的)
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<T, T> toMain() {
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(Flowable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

}
