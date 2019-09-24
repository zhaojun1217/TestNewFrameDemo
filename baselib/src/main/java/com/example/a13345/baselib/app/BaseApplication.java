package com.example.a13345.baselib.app;

import android.app.Activity;
import android.app.Application;
import android.util.Log;


import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhaoj on 2019/5/14.
 */

public class BaseApplication extends Application {

    // ARouter 调试开关
    private boolean isDebugARouter = true;
    private static BaseApplication instance;
    private Set<Activity> allActivities;

    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
//        if (isDebugARouter) {
//            // 下面两行必须写在init之前,否则这些配置再init过程中将无效
//            ARouter.openLog(); // 打印日志
//            // 开启调试模式(如果再instantrun模式下运行,必须开启调试模式,线上版本需要关闭,否则有安全风险)
//            ARouter.openDebug();
//        }
//        // 官方建议推荐Application中初始化
//        ARouter.init(BaseApplication.this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
//        ARouter.getInstance().destroy();
//        Log.i(Constans.Tag.BASE_LIB_TAG, "关闭了ARouter");
    }

    /**
     * 录入activity
     *
     * @param act
     */
    public void registerActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(act);
    }

    /**
     * 取消录入activity
     *
     * @param act
     */
    public void unregisterActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    /**
     * 全退activity
     */
    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    if (act != null && !act.isFinishing())
                        act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

}
