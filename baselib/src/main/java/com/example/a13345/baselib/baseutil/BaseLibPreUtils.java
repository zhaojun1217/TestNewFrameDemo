package com.example.a13345.baselib.baseutil;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.lang.reflect.ParameterizedType;

public class BaseLibPreUtils extends PreUtils {

    /**
     * 保存对象流
     */
    public static <T extends Object> void saveEntityInfo(Context context, T t, String saveKey) {
        putString(context, saveKey, "");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(t);
            String data = new String(Base64.encode(baos.toByteArray(), 0));
            //            data = java.net.URLEncoder.encode(data, "UTF-8");
            boolean b = putString(context, saveKey, data);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取对象流
     */
    public static <T extends Object> T getEntityInfo(Context context, String getKey) {
        ParameterizedType ptype = (ParameterizedType) context.getClass().getGenericSuperclass();
        Class clazz = (Class<T>) ptype.getActualTypeArguments()[0];
        T result = null;
        try {
            result = (T) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        String productBase64 = getString(context, getKey, "");
        byte[] base64 = Base64.decode(productBase64.getBytes(), 0);
        if (TextUtils.isEmpty(productBase64)) {
            return result;
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(base64);
        ObjectInputStream bis = null;
        try {
            bis = new ObjectInputStream(bais);
            result = (T) bis.readObject();
            bis.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

}
