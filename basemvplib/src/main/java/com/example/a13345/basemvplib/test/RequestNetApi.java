package com.example.a13345.basemvplib.test;

import com.example.a13345.basemvplib.basemvpbean.PostCommonBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by $zhao on 2018/11/22.
 */

public interface RequestNetApi {

    @GET("GlobalConfig/ServTimeStamp")
    Observable<PostCommonBean<SerTimStampResBean>> getSTTime();

}
