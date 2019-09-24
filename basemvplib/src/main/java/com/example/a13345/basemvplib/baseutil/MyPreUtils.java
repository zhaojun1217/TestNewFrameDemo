package com.example.a13345.basemvplib.baseutil;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;

import com.example.a13345.baselib.basebean.EmptyBean;
import com.example.a13345.baselib.baseutil.PreUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.lang.reflect.ParameterizedType;

public class MyPreUtils extends PreUtils {

    private static final String APP_SAVE_FILE = "app_save_file";
    private static final String SAVE_TIME_STEP = "save_time_step";
    private static final String SAVE_TOKEN = "SAVE_TOKEN";
    private static final String SAVE_EMPLOYEE_ID = "save_employee_id";
    public static final String LOGIN_SAVE_FILE = "login_save_file";
    public static final String LOGIN_ACCOUNT = "login_account";
    private static final String SAVE_UN_UPLOAD_MEMBER = "save_un_upload_member";

    private static final String IGNORE_TIME = "ignore_time";

    /**
     * 保存忽略更新时间
     */
    public static void saveIgnoreTime(Context context, long value) {
        putLong(context, IGNORE_TIME, value);
    }

    /**
     * 获取忽略更新时间
     */
    public static long getIgnoreTime(Context context) {
        return getLong(context, IGNORE_TIME, 0);
    }

    /**
     * 保存时间戳
     */
    public static void saveTimeStep(Context context, int value) {
        putInt(context, SAVE_TIME_STEP, value);
    }

    /**
     * 获取时间戳
     */
    public static int getTimeStep(Context context) {
        return getInt(context, SAVE_TIME_STEP, 0);
    }

    /**
     * 获取token
     */
    public static String getToken(Context context) {
        return getString(context, SAVE_TOKEN, "");
    }

    /**
     * 保存token
     */
    public static void saveToken(Context context, String token) {
        putString(context, SAVE_TOKEN, token);
    }

    /**
     * 保存name
     */
    public static String getLoginName(Context context) {
        return getString(context, LOGIN_ACCOUNT, "");
    }

    /**
     * 保存name
     */
    public static void saveLoginName(Context context, String name) {
        putString(context, LOGIN_ACCOUNT, name);
    }

    public static void exitApp(Context context) {
        remove(context, LOGIN_SAVE_FILE);
        remove(context, LOGIN_ACCOUNT);
        //        DataResourceCache.get().setLoginResBean(null);
    }
}
