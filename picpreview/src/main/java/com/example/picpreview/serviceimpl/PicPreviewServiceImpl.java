package com.example.picpreview.serviceimpl;

import android.support.v4.app.Fragment;

import com.example.componentservice.picpreviewcomp.PicPreviewService;

/**
 * Created by zhaoj on 2019/7/18.
 */

public class PicPreviewServiceImpl implements PicPreviewService {
    @Override
    public Fragment getTest2Fragment() {
        return new Fragment();
    }
}
