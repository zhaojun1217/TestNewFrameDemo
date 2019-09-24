package basemvcpage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.a13345.baselib.basepage.BaseActivity;
import com.example.a13345.basemvclib.R;

/**
 * Created by zhaoj on 2019/5/16.
 */

public abstract class BaseMvcActivity extends BaseActivity {

    private LinearLayout llBaseMvcAct;
    private View mView;

    @Override
    protected void initView() {
        super.initView();
        setAtyCenterTitle("BaseMvcActivity", false, false);
        llBaseMvcAct = findViewById(R.id.llBaseMvcAct);
        llBaseMvcAct.removeAllViews();
        mView = LayoutInflater.from(this).inflate(getPageLayout(), null);
        llBaseMvcAct.addView(mView);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mView.setLayoutParams(lp);

        initPageView();
        initPageEvent();
        initPageData();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_base_mvc;
    }

    protected abstract int getPageLayout();

    protected abstract void initPageView();

    protected abstract void initPageEvent();

    protected abstract void initPageData();

    protected void setClickListener(View.OnClickListener clickListener, View... views) {
        for (View view : views) {
            view.setOnClickListener(clickListener);
        }
    }
}
