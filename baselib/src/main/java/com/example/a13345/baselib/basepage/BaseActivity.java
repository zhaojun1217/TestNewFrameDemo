package com.example.a13345.baselib.basepage;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

//import com.alibaba.android.arouter.launcher.ARouter;
import com.example.a13345.baselib.R;
import com.example.a13345.baselib.baseutil.ScreenUtil;
import com.example.a13345.baselib.customview.CustomToolBar;
import com.example.a13345.baselib.customview.LoadingDialog;
import com.luojilab.component.componentlib.service.AutowiredService;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Created by zhaoj on 2019/5/13.
 */

public abstract class BaseActivity extends BaseThemeActivity {

    private CustomToolBar cusToolBar;
    private LinearLayout llBaseLayout;
    private View mView;
    private LoadingDialog mLoadingDialog;
    protected Activity mContext;


    @Override
    protected void initData() {
        init();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        // 依赖注入 使用自动装载功能
        AutowiredService.Factory.getSingletonImpl().autowire(this);
//        ARouter.getInstance().inject(mContext);
        cusToolBar = this.findViewById(R.id.cusToolBar);
        ScreenUtil.setSelfToolbar(this, cusToolBar, 50);
        llBaseLayout = this.findViewById(R.id.llBaseLayout);

        llBaseLayout.removeAllViews();
        mView = LayoutInflater.from(this).inflate(getLayout(), null);
        llBaseLayout.addView(mView);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mView.setLayoutParams(lp);
        initResource();
        initView();
        initData();
        initEvent();
        mLoadingDialog = new LoadingDialog(mContext);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void init() {
        setTransLucentStatus(true);
    }

    private void setTransLucentStatus(boolean on) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) { // sdk版本小于4.4版本 没有沉浸式布局
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            if (on) {
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            win.setAttributes(winParams);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.view_base;
    }

    protected void initResource() {
    }

    protected abstract int getLayout();

    protected void initView() {
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    protected void initEvent() {
    }

    /**
     * 设置页面标题栏
     */
    protected void setAtyCenterTitle(String title, boolean showTitle, boolean showImgBack) {
        if (showTitle) {
            cusToolBar.setVisibility(View.VISIBLE);
            cusToolBar.setCenterTitle(title);
            setImgBack(showImgBack);
        } else {
            cusToolBar.setVisibility(View.GONE);
        }
    }

    /**
     * 设置返回键
     */
    protected void setImgBack(boolean showLeftBack) {
        if (showLeftBack) {
            cusToolBar.setImgBackOnClick(new CustomToolBar.ImageBackOnClick() {
                @Override
                public void imageBackCallBack() {
                    onBackPressedSupport();
                }
            });
        }
    }

    /**
     * 显示loading
     */
    protected void showLoading() {
        if (mLoadingDialog != null) {
            mLoadingDialog.show();
        }
    }

    /**
     * 定时loading
     */
    protected void showTimingLoading(final long timing) {
        if (mLoadingDialog != null) {
            mLoadingDialog.show();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(timing);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (mLoadingDialog != null) {
                                mLoadingDialog.dismiss();
                            }
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 隐藏loading
     */
    protected void dismLoading() {
        if (mLoadingDialog != null) {
            mLoadingDialog.dismiss();
        }
    }

    //简化findViewById 省去强转
    protected <T extends View> T bindView(int id) {
        return (T) findViewById(id);
    }

}
