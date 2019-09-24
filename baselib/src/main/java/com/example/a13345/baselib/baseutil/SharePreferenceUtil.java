package com.example.a13345.baselib.baseutil;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * 本地数据存储工具类
 * Created by zhaoj on 16/5/4.
 */
public class SharePreferenceUtil {

    public static String getPrefString(Context context, String name, String key, String defaultValue) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.getString(key, defaultValue);
    }

    public static void setPrefString(Context context, String name, String key, String defaultValue) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        sp.edit().putString(key, defaultValue).commit();
    }

    public static boolean getPrefBoolean(Context context, String name, String key, boolean defaultValue) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defaultValue);
    }

    public static boolean hasKey(Context context, String name, final String key) {
        return context.getSharedPreferences(name, Context.MODE_PRIVATE).contains(key);  //.contains通过名称查看该首选项是否存在
    }


    public static void setPrefBoolean(Context context, String name, final String key,
                                      final boolean value) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).commit();
    }


    public static void setPrefInt(Context context, String name, final String key,
                                  final int value) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        sp.edit().putInt(key, value).commit();
    }

    public static int getPrefInt(Context context, String name, final String key,
                                 final int defaultValue) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.getInt(key, defaultValue);
    }

    public static void setPrefFloat(Context context, String name, final String key,
                                    final float value) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        sp.edit().putFloat(key, value).commit();
    }

    public static float getPrefFloat(Context context, String name, final String key,
                                     final float defaultValue) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.getFloat(key, defaultValue);
    }


    public static void setSettingLong(Context context, String name, String key, long value) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        sp.edit().putLong(key, value).commit();  //获取编辑器,键入信息
    }

    public static long getPrefLong(Context context, String name, String key, long defaultValue) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.getLong(key, defaultValue);
    }

    public static void clearPreference(Context context, String name) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
    }

}
