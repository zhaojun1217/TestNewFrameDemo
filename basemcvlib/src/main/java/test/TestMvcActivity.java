package test;

import android.support.v4.app.Fragment;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.a13345.baselib.customview.CustomBottomTab;
import com.example.a13345.baselib.customview.NoScrollViewPager;
import com.example.a13345.basemvclib.R;
import com.google.gson.Gson;

import basemvcinterface.ResultInfoInterface;
import basemvcnet.CheckErrorCodeUtil;
import basemvcnet.CommonResult;
import basemvcnet.GsonRequestUtil;
import basemvcnet.VolleySingleton;
import basemvcpage.BaseMvcActivity;

import java.util.ArrayList;

import basemvcinterface.GetInfoInterface;

/**
 * Created by zhaoj on 2019/5/16.
 */
public class TestMvcActivity extends BaseMvcActivity implements ResultInfoInterface {

    private NoScrollViewPager nsvp;
    private CustomBottomTab cbtBottom;
    private ArrayList<Fragment> fragments;
    private AdapterOfMain adapterOfMain;
    private FragmentOne mFragmentOne;
    private FragmentTwo mFragmentTwo;
    private FragmentThree mFragmentThree;

    @Override
    protected int getPageLayout() {
        return R.layout.activity_mvc_test;
    }

    @Override
    protected void initResource() {
        super.initResource();
        fragments = new ArrayList<>();
        mFragmentOne = new FragmentOne();
        mFragmentTwo = new FragmentTwo();
        mFragmentThree = new FragmentThree();
        fragments.add(mFragmentOne);
        fragments.add(mFragmentTwo);
        fragments.add(mFragmentThree);
        adapterOfMain = new AdapterOfMain(getSupportFragmentManager(), fragments);
    }

    @Override
    protected void initPageView() {
        nsvp = bindView(R.id.nsvp);
        cbtBottom = bindView(R.id.cbtBottom);
        nsvp.setAdapter(adapterOfMain);
        nsvp.setOffscreenPageLimit(2);
    }

    @Override
    protected void initPageEvent() {
        cbtBottom.setCustomBottomTabOnClick(new CustomBottomTab.CustomBottomTabOnClick() {
            @Override
            public void customBottomTabCallBack(int index, String btnName) {
                nsvp.setCurrentItem(index);
                setAtyCenterTitle(btnName, true, false);
            }
        });
    }

    @Override
    protected void initPageData() {

    }

    public void getOneFragmentInfo(String unitCode, String url) {
        switch (url) {
            case "第一个url请求":
                VolleySingleton.getInstance().addRequest(new GsonRequestUtil().getHomeTitle(this));
                showTimingLoading(3333);
                break;
            case "第二个url请求":
                VolleySingleton.getInstance().addRequest(new GsonRequestUtil().getSampleInfo(this));
                break;
            case "第三个url请求":
                VolleySingleton.getInstance().addRequest(new GsonRequestUtil().getRaidersInfo(this));
                break;
        }
    }

    public void getTwoFragmentInfo(String unitCode, String url) {
        switch (url) {
            case "第一个url请求":

                break;
            case "第二个url请求":

                break;
            case "第三个url请求":

                break;
        }
    }

    public void getThreeFragmentInfo(String unitCode, String url) {
        switch (url) {
            case "第一个url请求":

                break;
            case "第二个url请求":

                break;
            case "第三个url请求":

                break;
        }
    }

    @Override
    public void getHomeTitleSuccess(HomeTitleBean mHomeTitleBean) {
        CheckErrorCodeUtil.getInstance().getErrorCodeMsg(String.valueOf(mHomeTitleBean.getCode()));
        Log.i("TAG", "getHomeTitleSuccess: " + new Gson().toJson(mHomeTitleBean));
        mFragmentOne.refreshData(mHomeTitleBean);
    }

    @Override
    public void getSampleInfoSuccess(SampleBean mSampleBean) {
        Log.i("TAG", "getSampleInfoSuccess: " + new Gson().toJson(mSampleBean));
        mFragmentTwo.refreshData(mSampleBean);
    }

    @Override
    public void getRaidersInfoSuccess(RaidersHeadBean mRaidersHeadBean) {
        Log.i("TAG", "getRaidersInfoSuccess: " + new Gson().toJson(mRaidersHeadBean));
        mFragmentThree.refreshData(mRaidersHeadBean);
    }

    @Override
    public void showError(String msg) {
        Log.i("TAG", "showError: " + msg);
    }
}
