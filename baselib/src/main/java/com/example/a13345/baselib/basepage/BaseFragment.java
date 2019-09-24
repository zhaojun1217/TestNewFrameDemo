package com.example.a13345.baselib.basepage;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.a13345.baselib.R;
import com.example.a13345.baselib.baseutil.StatusBarUtil;
import com.example.a13345.baselib.customview.CustomToolBar;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import io.reactivex.disposables.Disposable;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by zhaoj on 2019/5/14.
 */

public abstract class BaseFragment extends SupportFragment {
    private final String TAG = getClass().getSimpleName();

    private View baseView;
    private View childView;
    protected Context mContext;
    protected Disposable disposable;
    private CustomToolBar cusToolBar;
    private LinearLayout llBaseLayout;
    private boolean hasFetchData = false; // 标识已经触发过懒加载数据
    private boolean isViewPrepared = false; // 标识fragment视图已经初始化完毕

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context != null) {
            this.mContext = context;
        } else {
            this.mContext = getActivity();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        baseView = LayoutInflater.from(mContext).inflate(R.layout.view_basefragment, null);
        //        cusToolBar = baseView.findViewById(R.id.cusToolBar);
        llBaseLayout = baseView.findViewById(R.id.llBaseLayout);

        childView = LayoutInflater.from(mContext).inflate(getLayout(), null);
        llBaseLayout.addView(childView);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        childView.setLayoutParams(lp);

        //        setFrgCenterTitle("");
        initResource();
        initView(childView);
        initEvent();
        isViewPrepared = true;
        lazyFetchDataIfPrepared();
        return baseView;
    }


    protected abstract void initView(View contentView);

    protected void setFrgCenterTitle(String title) {
        cusToolBar.setVisibility(View.VISIBLE);
        cusToolBar.setCenterTitle(title);
    }

    /**
     * 用户可见fragment && 没有加载过数据 && 视图已经准备完毕
     */
    private void lazyFetchDataIfPrepared() {
        if (getUserVisibleHint() && !hasFetchData && isViewPrepared) {
            hasFetchData = true;
            lazyFetchData();
        }
    }

    /**
     * 懒加载的方式获取数据，仅在满足fragment可见和视图已经准备好的时候调用一次
     */
    protected void lazyFetchData() {
        Log.v(TAG, getClass().getName() + "------>lazyFetchData");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    protected abstract int getLayout();

    protected void initResource() {
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    protected void initEvent() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // view被销毁后，将可以重新触发数据懒加载，因为在viewpager下，fragment不会再次新建并走onCreate的生命周期流程，将从onCreateView开始
        hasFetchData = false;
        isViewPrepared = false;
        unsubscribe();
    }

    protected void unsubscribe() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }

    //简化findViewById 省去强转
    protected <T extends View> T bindView(int id) {
        return (T) childView.findViewById(id);
    }

    protected <T extends View> T bindView(View view, int id) {
        return (T) view.findViewById(id);
    }
}
