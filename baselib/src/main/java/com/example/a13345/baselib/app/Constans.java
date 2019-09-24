package com.example.a13345.baselib.app;


import java.io.File;

/**
 * Created by $zhao on 2018/8/25.
 */

public class Constans {

    public static String APPID = "e0eae5eecfca222f0dacd09a647c7b83";

    /**
     * 主题代码号
     */
    public static class Theme {
        public static String THEMECODE = DefaultValue.THEMEWHITE;
    }

    /**
     * 默认值
     */
    public static class DefaultValue {
        public static final String ERROR = "ERROR";
        public static boolean ISLOGIN = false;
        //绿色主题代码
        public final static String THEMEGREED = "0";
        //白色色主题代码
        public final static String THEMEWHITE = "1";
        //深邃蓝色主题代码
        public final static String THEMEDARKBLUE = "2";
        //软键盘焦点
        public final static String SOFTINPUTONFOCUS = "setShowSoftInputOnFocus";
        //删除手势密码
        public final static String DEL = "del";
        //修改手势密码
        public final static String MOD = "mod";
    }

    /**
     * 本地存储使用的Key
     */
    public final static class SharedPherenceKey {
        //存放主题文件Key
        public final static String THEME = "theme";
        //主题代码Key
        public final static String THEMECODE = "themecode";
        public final static String CANREFRESHKEY = "CANREFRESH";
        public final static String SHAREDPERENCEUSERNAME = "userInfo";
        public final static String REFRESHTIMEKEY = "REFRESHTIME";

        public final static String PWDMD5KEY = "PWDMD5";
        public final static String USERNAMEKEY = "USERNAME";
        public final static String ISLOGOUT = "ISLOGOUT";

        public final static String TOKEN = "TOKEN";
        // 登录模式-密码或手势
        public final static String LOGINMODE = "loginMode";
        // 登录模式-密码
        public final static String LOGINMODE_PASS = "pass";
        // 登录模式-手势
        public final static String LOGINMODE_HEND = "hend";
        // 是否为第一次登录
        public final static String ISFIRSTLOGIN = "isFirstLogin";
    }


    /**
     * interceptor拦截器
     */
    public final static class Interceptor {
        public static final String INTERCEPTOR = "/base/app/Interceptor";
    }

    /**
     * URL
     */
    public final static class Url {
        public static final String ACTIVITY_URL_TESTACTIVITY = "/base/app/TestActivity";
        public static final String ACTIVITY_URL_TEST2ACTIVITY = "/base/app/Test2Activity";
    }

    /**
     * TAG
     */
    public final static class Tag {
        public static final String BASE_LIB_TAG = "BASE_LIB_APP";
    }

    /**
     * MVP
     */
    public final static class Mvp {

        public static final String PATH_DATA = BaseApplication.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
        public static final String PATH_CACHE = PATH_DATA + File.separator + "NetCache";


        public static final int NET_SUCCESS = 0;
        public static final String EXIT_APP = "exit_app";
        public static final String APP_KEY = "JFFApp";
        public static final String APP_SECRET = "a323f9b6-1f04-420e-adb9-b06d142c5e63";
        public static final String PHONE_NUMBER = "phonenum";
        public static final String ERROR302 = "ERROR302";
    }

}
