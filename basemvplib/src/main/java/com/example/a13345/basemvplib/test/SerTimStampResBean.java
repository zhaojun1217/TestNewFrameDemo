package com.example.a13345.basemvplib.test;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by $zhao on 2018/12/3.
 */

public class SerTimStampResBean implements Serializable {

    @SerializedName("NServTimeStamp")
    int timeTimeStamp;

    public int getTimeTimeStamp() {
        return timeTimeStamp;
    }

    public void setTimeTimeStamp(int timeTimeStamp) {
        this.timeTimeStamp = timeTimeStamp;
    }
}
