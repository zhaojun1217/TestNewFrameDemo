package com.example.a13345.baselib.customview;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.a13345.baselib.R;

/**
 * Created by zhaoj on 2019/5/14.
 */

public class LoadingDialog extends ProgressDialog {

    public LoadingDialog(Context context) {
        super(context);
        // 点击提示框外面是否取消提示框
        setCanceledOnTouchOutside(false);
        // 点击返回键是否取消提示框
        setCancelable(false);
        setIndeterminate(true);
        getWindow().setBackgroundDrawableResource(R.color.transform);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading);
        ImageView imageView = findViewById(R.id.loading_image);
        imageView.setBackgroundResource(R.drawable.loading_animation);
        // 通过ImageView对象拿到背景显示的AnimationDrawable
        final AnimationDrawable mAnimation = (AnimationDrawable) imageView.getBackground();
        imageView.post(new Runnable() {
            @Override
            public void run() {
                mAnimation.start();
            }
        });
    }
}
