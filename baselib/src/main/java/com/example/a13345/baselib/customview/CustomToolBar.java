package com.example.a13345.baselib.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a13345.baselib.R;
import com.example.a13345.baselib.baseutil.ScreenUtil;

/**
 * Created by $zhao on 2018/11/13.
 */

public class CustomToolBar extends LinearLayout {

    private Context mContext;
    private View view;
    private LinearLayout llToolBar, llLayout;
    private LayoutInflater mLayoutInflater;
    private ImageView imgBack;
    private TextView tvCenterTitle;

    public CustomToolBar(Context context) {
        super(context);
        this.mContext = context;
    }

    public CustomToolBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;

        initView();
    }

    private void initView() {
        mLayoutInflater = LayoutInflater.from(mContext);
        view = mLayoutInflater.inflate(R.layout.custom_toolbar_layout, null);
        llToolBar = view.findViewById(R.id.llToolBar);
        llLayout = view.findViewById(R.id.llLayout);
        imgBack = view.findViewById(R.id.imgBack);
        tvCenterTitle = view.findViewById(R.id.tvCenterTitle);

        LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        llToolBar.setLayoutParams(lp);
        ViewGroup.LayoutParams layoutParams = llLayout.getLayoutParams();
        layoutParams.height = ScreenUtil.getStatusBarHeight(mContext);
        layoutParams.width = ScreenUtil.getScreenWidth(mContext);
        llLayout.setLayoutParams(layoutParams);
        addView(view);
    }

    public void setImgBackOnClick(final ImageBackOnClick mImageBackOnClick) {
        imgBack.setVisibility(VISIBLE);
        imgBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mImageBackOnClick.imageBackCallBack();
            }
        });
    }

    public void setCenterTitle(String title){
        tvCenterTitle.setText(title);
    }

    public interface ImageBackOnClick {
        void imageBackCallBack();
    }

}
