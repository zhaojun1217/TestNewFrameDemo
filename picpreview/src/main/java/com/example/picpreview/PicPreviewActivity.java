package com.example.picpreview;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a13345.baselib.baseutil.ScreenUtil;
import com.example.a13345.basemvplib.basepage.BaseMvpActivity;
import com.example.commbean.PreviewImgBean;
import com.luojilab.component.componentlib.service.AutowiredService;
import com.luojilab.component.componentlib.service.JsonService;
import com.luojilab.router.facade.annotation.Autowired;
import com.luojilab.router.facade.annotation.RouteNode;

import java.util.ArrayList;
import java.util.List;

@RouteNode(path = "/picPreviewActivity", desc = "预览图片的页面")
public class PicPreviewActivity extends BaseMvpActivity {

    @Autowired
    PreviewImgBean previewImgBean;

    private ImageView imgBack;
    private ViewPager vpBigImg;
    private TextView tvImgCount;
    private LinearLayout llToolBar;
    private RelativeLayout toolbarLeftbutton, rlToolBar;
    private ArrayList<String> testPicList = new ArrayList<>();

    @Override
    protected void initView() {
        super.initView();
        setAtyCenterTitle("", false, false);
        llToolBar = findViewById(R.id.llToolBar);
        rlToolBar = findViewById(R.id.rlToolBar);
        toolbarLeftbutton = findViewById(R.id.toolbar_leftbutton);
        imgBack = findViewById(R.id.imgBack);
        tvImgCount = findViewById(R.id.tvImgCount);
        vpBigImg = findViewById(R.id.vpBigImg);
        ScreenUtil.setSelfToolbar(this, rlToolBar, 50);

        testPicList.addAll(previewImgBean.getPicurls());

        tvImgCount.setText(1 + "/" + testPicList.size());
        //        vpBigImg.setCurrentItem(0, true);
        // 自动装载 项目执行build，会生成apt文件，具体可在build目录下面查看 同时还会在根目录生成UIRouterTable文件夹，里面会列出每个组件向外提供的路由表
        AutowiredService.Factory.getSingletonImpl().autowire(this);
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        toolbarLeftbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressedSupport();
            }
        });
        vpBigImg.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return testPicList == null ? 0 : testPicList.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                ZoomImageView imageView = new ZoomImageView(PicPreviewActivity.this);
                //                ImageView imageView = new ImageView(PicPreviewActivity.this);
                Glide.with(PicPreviewActivity.this).load(testPicList.get(position)).placeholder(R.mipmap.loading).into(imageView);
                container.addView(imageView);
                return imageView;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                // container.removeView(list.get(position));
            }
        });
        vpBigImg.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tvImgCount.setText((position + 1) + "/" + testPicList.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_pic_preview;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void showError(String msg) {

    }
}
