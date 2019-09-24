package com.example.a13345.basemvplib.basemvpbean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by $zhao on 2018/12/3.
 */

public class PostCommonBean<T> {

    @SerializedName("Code")
    private int code;
    @SerializedName("Desc")
    private String desc;
    @SerializedName("Data")
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
