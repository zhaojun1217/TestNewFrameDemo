package com.example.a13345.baselib.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.example.a13345.baselib.R;
import com.example.a13345.baselib.baseutil.ScreenUtil;


/**
 * Created by $zhao on 2018/11/14.
 */

public class CustomBottomTab extends LinearLayout {

    private View mView;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private RadioGroup rgBottomTabLayout;
    private AppCompatRadioButton acrbBtn1;
    private AppCompatRadioButton acrbBtn2;
    private AppCompatRadioButton acrbBtn3;
    private CustomBottomTabOnClick customBottomTabOnClick;

    public CustomBottomTab(Context context) {
        super(context);
        this.mContext = context;
    }

    public CustomBottomTab(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initView();
    }

    private void initView() {
        mLayoutInflater = LayoutInflater.from(mContext);
        mView = mLayoutInflater.inflate(R.layout.custom_bottom_tab, null);
        rgBottomTabLayout = mView.findViewById(R.id.rgBottomTabLayout);
        acrbBtn1 = mView.findViewById(R.id.acrbBtn1);
        acrbBtn2 = mView.findViewById(R.id.acrbBtn2);
        acrbBtn3 = mView.findViewById(R.id.acrbBtn3);
        acrbBtn1.setChecked(true);
        initLayout();
        addView(mView);
        initEvent();
    }

    private void initEvent() {
        rgBottomTabLayout.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (customBottomTabOnClick != null) {
                    if (i == R.id.acrbBtn1) {
                        customBottomTabOnClick.customBottomTabCallBack(0, acrbBtn1.getText().toString());
                    } else if (i == R.id.acrbBtn2) {
                        customBottomTabOnClick.customBottomTabCallBack(1, acrbBtn2.getText().toString());
                    } else if (i == R.id.acrbBtn3) {
                        customBottomTabOnClick.customBottomTabCallBack(2, acrbBtn3.getText().toString());
                    }
                }
            }
        });
    }

    private void initLayout() {
        ViewGroup.LayoutParams layoutParams = rgBottomTabLayout.getLayoutParams();
        layoutParams.height = ScreenUtil.dp2px(mContext, 66f);
        layoutParams.width = ScreenUtil.getScreenWidth(mContext);
        rgBottomTabLayout.setLayoutParams(layoutParams);
    }

    public void setCustomBottomTabOnClick(CustomBottomTabOnClick customBottomTabOnClick) {
        this.customBottomTabOnClick = customBottomTabOnClick;
    }

    public interface CustomBottomTabOnClick {
        void customBottomTabCallBack(int index, String btnName);
    }
}
