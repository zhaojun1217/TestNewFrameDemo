package com.example.a13345.basemvplib.basenet;


import android.content.Context;
import android.text.TextUtils;

import com.example.a13345.baselib.app.Constans;
import com.example.a13345.basemvplib.basemvpbean.ReqBody;
import com.example.a13345.basemvplib.baseutil.MD5Utils;
import com.example.a13345.basemvplib.baseutil.MyPreUtils;
import com.example.a13345.basemvplib.test.RequestNetApi;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by $zhao on 2018/11/20.
 */

public class RetrofitHelper {

    // api
    private static RequestNetApi mRequestNetApi;
    // okhttp
    private static OkHttpClient okHttpClient = null;
    //converter转换器,方便做序列化反序列化对象的操作
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    // adapter 适配器工厂,接受返回的数据类型
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJava2CallAdapterFactory.create();


    public static RequestNetApi getRequestNetApi() {

        initHttpClient();

        if (mRequestNetApi == null) {

            Retrofit retrofit = new Retrofit.Builder()
                    .client(HttpClientHelper.getInstance().okHttpClient)
                    .baseUrl("http://106.14.200.76:3000/")
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();

            mRequestNetApi = retrofit.create(RequestNetApi.class);
        }
        return mRequestNetApi;
    }

    private static void initHttpClient() {
        if (okHttpClient == null) {
            HttpClientHelper.getInstance().initOkHttp();
        }
    }

    public static ReqBody createBody(Context context, String bodyData) {
        ReqBody reqBody = new ReqBody();
        int unixStamp = (int) (System.currentTimeMillis() / 1000);
        int timeStampDelta = unixStamp + MyPreUtils.getTimeStep(context);
        reqBody.setTimeStamp(timeStampDelta);
        //        if (DataResourceCache.get().getLoginResBean(context) != null) {
        //            String token = DataResourceCache.get().getLoginResBean(context).getToken();
        //            reqBody.setToken(TextUtils.isEmpty(token) ? "" : token);
        //            reqBody.setUid(DataResourceCache.get().getLoginResBean(context).getEntUserID());
        //        } else {
        reqBody.setToken("");
        reqBody.setUid(0);
        //        }
        String sign = Constans.Mvp.APP_KEY + timeStampDelta + bodyData + Constans.Mvp.APP_SECRET;
        reqBody.setSign(MD5Utils.Md5(sign));
        reqBody.setData(bodyData);
        Logger.json(new Gson().toJson(reqBody));
        return reqBody;
    }
}
