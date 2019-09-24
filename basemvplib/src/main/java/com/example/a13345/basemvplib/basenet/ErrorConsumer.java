package com.example.a13345.basemvplib.basenet;

import android.util.Log;

import io.reactivex.functions.Consumer;

import static android.content.ContentValues.TAG;

/**
 * Created by $zhao on 2018/11/23.
 */

public class ErrorConsumer<T> implements Consumer<T> {
    private Consumer<T> onError;

    public ErrorConsumer(Consumer<T> error) {
        this.onError = error;
    }

    @Override
    public void accept(T e) throws Exception {
        try {
            if (((Throwable) e).getMessage().contains("504")) {
                onError.accept((T) new MyNetErrorException("网络错误"));
            } else if (((Throwable) e).getMessage().contains("must call proceed() exactly once")) {
                onError.accept((T) new MyNetErrorException("网络错误"));
            } else {
                onError.accept(e);
            }
        } catch (Exception e1) {
            Log.e(TAG, "e1:" + e1);
        }
    }
}
