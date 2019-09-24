package basemvcinterface;

import test.HomeTitleBean;
import test.RaidersHeadBean;
import test.SampleBean;

/**
 * Created by zhaoj on 2019/5/18.
 */

public interface ResultInfoInterface {

    void getHomeTitleSuccess(HomeTitleBean mHomeTitleBean);

    void getSampleInfoSuccess(SampleBean mSampleBean);

    void getRaidersInfoSuccess(RaidersHeadBean mRaidersHeadBean);

    void showError(String msg);
}
