package basemvcnet;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.a13345.baselib.app.BaseApplication;

/**
 * Created by zhaoj on 2019/5/17.
 */

public class VolleySingleton {

    private static VolleySingleton volleySingleton;
    private RequestQueue mRquestQueue;

    //构造私有化
    private VolleySingleton() {
        mRquestQueue = Volley.newRequestQueue(BaseApplication.getInstance());
    }
    public static VolleySingleton getInstance() {
        if (volleySingleton == null) {
            synchronized (VolleySingleton.class) {
                if (volleySingleton == null) {
                    volleySingleton = new VolleySingleton();
                }
            }
        }
        return volleySingleton;
    }

    //获得requestqueue的方法
    public RequestQueue getRquestQueue() {
        return mRquestQueue;
    }

    public <T> void addRequest(Request<T> request) {
        mRquestQueue.add(request);
    }

}
