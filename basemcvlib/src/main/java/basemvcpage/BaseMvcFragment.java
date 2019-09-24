package basemvcpage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.a13345.baselib.basepage.BaseFragment;
import com.example.a13345.basemvclib.R;

/**
 * Created by zhaoj on 2019/5/16.
 */

public abstract class BaseMvcFragment extends BaseFragment {

    private LinearLayout llBaseMvcFrg;
    private View mView;


    @Override
    protected void initView(View contentView) {
        llBaseMvcFrg = contentView.findViewById(R.id.llBaseMvcFrg);
        llBaseMvcFrg.removeAllViews();
        mView = LayoutInflater.from(mContext).inflate(getPageLayout(), null);
        llBaseMvcFrg.addView(mView);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mView.setLayoutParams(lp);

        initPageView();
        initPageEvent();
        initPageData();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_base_mvc;
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
