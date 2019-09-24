package basemvcnet;


import com.android.volley.Response;
import com.android.volley.VolleyError;

import test.HomeTitleBean;
import test.RaidersHeadBean;
import test.SampleBean;
import test.TestMvcActivity;


/**
 * Created by zhaoj on 2019/5/17.
 */

public class GsonRequestUtil {

    public GsonRequest getHomeTitle(final TestMvcActivity testMvcActivity) {
        return new GsonRequest<HomeTitleBean>(HomeTitleBean.class, "http://api.liwushuo.com/v2/channels/preset?gender=1&generation=1", new Response.Listener<HomeTitleBean>() {
            @Override
            public void onResponse(HomeTitleBean response) {
                testMvcActivity.getHomeTitleSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                testMvcActivity.showError(error.getMessage());
            }
        });
    }

    public GsonRequest getSampleInfo(final TestMvcActivity testMvcActivity) {
        return new GsonRequest<SampleBean>(SampleBean.class, "http://api.liwushuo.com/v2/item_categories/tree", new Response.Listener<SampleBean>() {
            @Override
            public void onResponse(SampleBean response) {
                testMvcActivity.getSampleInfoSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                testMvcActivity.showError(error.getMessage());
            }
        });
    }

    public GsonRequest getRaidersInfo(final TestMvcActivity testMvcActivity) {
        return new GsonRequest<RaidersHeadBean>(RaidersHeadBean.class, "http://api.liwushuo.com/v2/columns?limit=20&offset=0", new Response.Listener<RaidersHeadBean>() {
            @Override
            public void onResponse(RaidersHeadBean response) {
                testMvcActivity.getRaidersInfoSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                testMvcActivity.showError(error.getMessage());
            }
        });
    }
}
