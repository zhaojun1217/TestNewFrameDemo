package com.example.a13345.basemvplib.basenet;


import io.reactivex.functions.Consumer;

public class SuccessConsumer<T> implements Consumer<T> {

    private Consumer<? super T> onNext;

    public SuccessConsumer(Consumer<? super T> onNext) {
        this.onNext = onNext;
    }

    @Override
    public void accept(T t) throws Exception {
        onNext.accept(t);
    }
}
