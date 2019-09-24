package test;

import android.annotation.SuppressLint;
import android.widget.TextView;

import com.example.a13345.basemvclib.R;
import com.google.gson.Gson;

import basemvcpage.BaseMvcFragment;

/**
 * Created by zhaoj on 2019/5/16.
 */

@SuppressLint("ValidFragment")
public class FragmentOne extends BaseMvcFragment {

    private TextView tvFragmentOneText;

    @Override
    protected int getPageLayout() {
        return R.layout.fragment_one;
    }

    @Override
    protected void initPageView() {
        tvFragmentOneText = bindView(R.id.tvFragmentOneText);
    }

    @Override
    protected void initPageEvent() {

    }

    @Override
    protected void lazyFetchData() {
        super.lazyFetchData();
        ((TestMvcActivity) getActivity()).getOneFragmentInfo("", "第一个url请求");
        ((TestMvcActivity) getActivity()).getOneFragmentInfo("", "第二个url请求");
        ((TestMvcActivity) getActivity()).getOneFragmentInfo("", "第三个url请求");
    }

    @Override
    protected void initPageData() {

    }

    public void refreshData(HomeTitleBean mHomeTitleBean) {
        tvFragmentOneText.setText(new Gson().toJson(mHomeTitleBean));
    }
}
