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
public class FragmentTwo extends BaseMvcFragment {

    private TextView tvFragmentTwoText;

    @Override
    protected int getPageLayout() {
        return R.layout.fragment_two;
    }

    @Override
    protected void initPageView() {
        tvFragmentTwoText = bindView(R.id.tvFragmentTwoText);
    }

    @Override
    protected void initPageEvent() {

    }

    @Override
    protected void initPageData() {

    }

    public void refreshData(SampleBean mSampleBean) {
        tvFragmentTwoText.setText(new Gson().toJson(mSampleBean));
    }
}
