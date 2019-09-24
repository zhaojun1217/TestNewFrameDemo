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
public class FragmentThree extends BaseMvcFragment {

    private TextView tvFragmentThreeText;

    @Override
    protected int getPageLayout() {
        return R.layout.fragment_three;
    }

    @Override
    protected void initPageView() {
        tvFragmentThreeText = bindView(R.id.tvFragmentThreeText);
    }

    @Override
    protected void initPageEvent() {

    }

    @Override
    protected void initPageData() {

    }

    public void refreshData(RaidersHeadBean mRaidersHeadBean) {
        tvFragmentThreeText.setText(new Gson().toJson(mRaidersHeadBean));
    }
}
