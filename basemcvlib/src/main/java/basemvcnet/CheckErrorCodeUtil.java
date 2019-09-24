package basemvcnet;

import android.text.TextUtils;

/**
 * Created by zhaoj on 2019/5/18.
 */

public class CheckErrorCodeUtil {

        private static CheckErrorCodeUtil checkErrorCodeUtil;

        public static CheckErrorCodeUtil getInstance() {
            if (checkErrorCodeUtil == null) {  //第一层校验
                synchronized (CheckErrorCodeUtil.class) {
                    if (checkErrorCodeUtil == null) {  //第二层校验
                        checkErrorCodeUtil = new CheckErrorCodeUtil();
                    }
                }
            }
            return checkErrorCodeUtil;
        }

    public  String getErrorCodeMsg(String stutusCode) {

        if (!TextUtils.isEmpty(stutusCode)) {
            switch (stutusCode) {
                case "201":
                    stutusCode = "无数据返回";
                    break;
                case "300":
                    stutusCode = "调用失败";
                    break;
                case "301":
                    stutusCode = "用户名密码错误";
                    break;
                case "302":
                    stutusCode = "已绑定其他设备";
                    break;
                case "303":
                    stutusCode = "您的设备已被其他用户绑定";
                    break;
                case "304":
                    stutusCode = "您无权登录移动设备";
                    break;
                case "305":
                    stutusCode = "原密码不正确";
                    break;
                case "306":
                    stutusCode = "系统维护中";
                    break;
                default:
                    stutusCode = "未知错误";
                    break;
            }
        }
        return stutusCode;
    }

}
