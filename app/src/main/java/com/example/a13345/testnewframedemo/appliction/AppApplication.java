package com.example.a13345.testnewframedemo.appliction;

import com.example.a13345.baselib.app.BaseApplication;
import com.example.a13345.testnewframedemo.AppComponentEventManager;
import com.luojilab.component.componentlib.log.ILogger;
import com.luojilab.component.componentlib.router.Router;
import com.luojilab.component.componentlib.router.ui.UIRouter;

import org.github.jimu.msg.EventManager;

/**
 * Created by zhaoj on 2019/5/22.
 */

public class AppApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        ILogger.logger.setDefaultTag("JIMU");
        UIRouter.enableDebug();
        EventManager.init(this);
        UIRouter.getInstance().registerUI("app");
        // 如果 isRegisterCompoAuto 为false，则需要通过反射加载组件
        Router.registerComponent("com.example.testmodleone.testmodleonelike.TestModleOneAppLike");
        Router.registerComponent("com.example.picpreview.picpreviewlike.PicPreviewAppLike");

        Router.getInstance().addService(AppComponentEventManager.class.getSimpleName(),
                EventManager.create(AppComponentEventManager.class));

        // 初始化arouter
//        ARouter.init(this);
    }
}
