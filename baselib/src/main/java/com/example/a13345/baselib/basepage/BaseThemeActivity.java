package com.example.a13345.baselib.basepage;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.a13345.baselib.R;
import com.example.a13345.baselib.app.Constans;
import com.example.a13345.baselib.baseutil.SharePreferenceUtil;
import com.example.a13345.baselib.baseutil.StatusBarUtil;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by zhaoj on 2019/5/13.
 */

public abstract class BaseThemeActivity extends SupportActivity {
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 主题
        Constans.Theme.THEMECODE = SharePreferenceUtil.getPrefString(
                this,
                Constans.SharedPherenceKey.THEME,
                Constans.SharedPherenceKey.THEMECODE,
                Constans.Theme.THEMECODE
        );

        // 根据选择的主题重新设置
        //        if (Constans.Theme.THEMECODE.equals(Constans.DefaultValue.THEMEGREED)) {
        setTheme(R.style.AppTheme_2);
        //        } else {
        //            setTheme(R.style.BaseAPPThemeWhite);
        //        }

        setContentView(getLayoutId());

        initData();

    }

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 得到布局文件
     */
    public abstract int getLayoutId();

    /**
     * android 重写getresources规避用户调整系统字体大小影响Android屏幕适配
     */
    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }
}
