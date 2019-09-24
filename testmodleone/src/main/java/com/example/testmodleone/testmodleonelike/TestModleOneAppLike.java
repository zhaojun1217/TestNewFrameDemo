package com.example.testmodleone.testmodleonelike;

import com.example.componentservice.testonecomp.Test1Service;
import com.example.testmodleone.serviceimpl.TestModleOneServiceImpl;
import com.luojilab.component.componentlib.applicationlike.IApplicationLike;
import com.luojilab.component.componentlib.applicationlike.RegisterCompManual;
import com.luojilab.component.componentlib.router.Router;
import com.luojilab.component.componentlib.router.ui.UIRouter;

/**
 * Created by zhaoj on 2019/5/22.
 */

@RegisterCompManual
public class TestModleOneAppLike implements IApplicationLike {
    Router router = Router.getInstance();
    UIRouter uiRouter = UIRouter.getInstance();

    @Override
    public void onCreate() {
        router.addService(Test1Service.class.getSimpleName(), new TestModleOneServiceImpl());
        uiRouter.registerUI("testmodleone");
    }

    @Override
    public void onStop() {
        router.removeService(Test1Service.class.getSimpleName());
        uiRouter.unregisterUI("testmodleone");
    }
}
