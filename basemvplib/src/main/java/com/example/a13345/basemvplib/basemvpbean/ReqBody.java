package com.example.a13345.basemvplib.basemvpbean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by $zhao on 2018/12/3.
 */

public class ReqBody {

    @SerializedName("AppVer")
    public String appVer = "1.0";
    //当前时间戳
    @SerializedName("TimeStamp")
    public int timeStamp;
    //当前客户端语言
    @SerializedName("Lang")
    public String lang = "zh";
    //设备名称
    @SerializedName("DeviceName")
    private String deviceName;
    //设备类型
    @SerializedName("DeviceType")
    public String deviceType = "android";
    //登录token
    @SerializedName("Token")
    public String token;
    //会员ID
    @SerializedName("Uid")
    public long uid;
    //登记应用的AppKey
    @SerializedName("AppKey")
    public String appKey = "JFFApp";
    //根据AppKey AppSecret Data TimeStamp MD5计算出的签名
    @SerializedName("Sign")
    public String sign;
    // "Data":"根据API确定的json数据"
    @SerializedName("Data")
    public String data;

    public String getAppVer() {
        return appVer;
    }

    public void setAppVer(String appVer) {
        this.appVer = appVer;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }


    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ReqBody{" +
                "appVer='" + appVer + '\'' +
                ", timeStamp=" + timeStamp +
                ", lang='" + lang + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", token='" + token + '\'' +
                ", uid=" + uid +
                ", appKey='" + appKey + '\'' +
                ", sign='" + sign + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
