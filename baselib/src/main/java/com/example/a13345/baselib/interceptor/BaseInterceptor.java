//package com.example.a13345.baselib.interceptor;
//
//import android.content.Context;
//import android.util.Log;
//
//import com.alibaba.android.arouter.facade.Postcard;
//import com.alibaba.android.arouter.facade.annotation.Interceptor;
//import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
//import com.alibaba.android.arouter.facade.template.IInterceptor;
//import com.example.a13345.baselib.app.Constans;
//
///**
// * Created by zhaoj on 2019/5/14.
// */
//@Interceptor(priority = 10) // 拦截器优先级 越小越先执行 不可设置相同优先级
//public class BaseInterceptor implements IInterceptor {
//    @Override
//    public void process(Postcard postcard, InterceptorCallback callback) {
//        String name = Thread.currentThread().getName();
//        Log.i(Constans.Tag.BASE_LIB_TAG, "BaseInterceptor 拦截器开始执行  :  线程名称　：" + name);
//        //        if (postcard.getPath().equals(Constans.ACTIVITY_URL_MAIN)) {
//        Log.i(Constans.Tag.BASE_LIB_TAG, BaseInterceptor.class.getName() + " 进行了拦截处理! ");
//        //        }
//        callback.onContinue(postcard);
//    }
//
//    @Override
//    public void init(Context context) {
//        Log.i(Constans.Tag.BASE_LIB_TAG, "BaseInterceptor 拦截器init : 初始化拦截器");
//    }
//}
