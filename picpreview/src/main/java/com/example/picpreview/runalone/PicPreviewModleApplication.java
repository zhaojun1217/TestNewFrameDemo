package com.example.picpreview.runalone;

import com.example.a13345.baselib.app.BaseApplication;
import com.luojilab.component.componentlib.router.Router;

import org.github.jimu.msg.EventManager;

/**
 * Created by zhaoj on 2019/7/18.
 */

public class PicPreviewModleApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        EventManager.init(this);
        //        如果isRegisterCompoAuto为false，则需要通过反射加载组件 com.example.testmodleone.testmodleonelike
        Router.registerComponent("com.example.picpreview.picpreviewlike.PicPreviewAppLike");
    }
}
