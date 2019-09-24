package com.example.commbean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by zhaoj on 2019/7/19.
 */

public class PreviewImgBean implements Serializable{

    @SerializedName("name")
    private String name;
    @SerializedName("picurls")
    private ArrayList<String> picurls;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getPicurls() {
        return picurls;
    }

    public void setPicurls(ArrayList<String> picurls) {
        this.picurls = picurls;
    }
}
