package com.example.picpreview.picpreviewlike;

import com.example.componentservice.picpreviewcomp.PicPreviewService;
import com.example.picpreview.serviceimpl.PicPreviewServiceImpl;
import com.luojilab.component.componentlib.applicationlike.IApplicationLike;
import com.luojilab.component.componentlib.applicationlike.RegisterCompManual;
import com.luojilab.component.componentlib.router.Router;
import com.luojilab.component.componentlib.router.ui.UIRouter;

/**
 * Created by zhaoj on 2019/7/18.
 */
@RegisterCompManual
public class PicPreviewAppLike implements IApplicationLike {
    Router router = Router.getInstance();
    UIRouter uiRouter = UIRouter.getInstance();

    @Override
    public void onCreate() {
        router.addService(PicPreviewService.class.getSimpleName(), new PicPreviewServiceImpl());
        uiRouter.registerUI("picpreview");
    }

    @Override
    public void onStop() {
        router.removeService(PicPreviewService.class.getSimpleName());
        uiRouter.unregisterUI("picpreview");
    }
}
