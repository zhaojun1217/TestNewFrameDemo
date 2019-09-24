package com.example.a13345.baselib.baseutil;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhaoj on 2019/5/14.
 */

public class TimeUtil {

    long startTime, endTime;
    boolean isDebug = true;

    public TimeUtil() {
        if (isDebug) {
            startTime = System.currentTimeMillis();
        }
    }

    public void showTime(String msg) {
        if (isDebug) {
            endTime = System.currentTimeMillis();
        }
    }

    /**
     * 根据指定格式,格式化数据
     */
    public static String formatTime(Date date, String targetFormat) {
        SimpleDateFormat formater = new SimpleDateFormat(targetFormat);
        return formater.format(date);
    }

    /**
     * 获取小时
     */
    public static String getHourTime(String dateStr) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        SimpleDateFormat formater2 = new SimpleDateFormat("HH:mm");
        Date convertDate = formatter.parse(dateStr);
        return formater2.format(convertDate);
    }

    /**
     * 根据传入的str时间,截取所取的年/月/日  Y M D
     */
    public static String getAppointTimeYMD(String appointTime, String YMD) {
        String result = "";
        Calendar calendar;
        if (!TextUtils.isEmpty(appointTime)) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date parse = format.parse(appointTime);
                calendar = Calendar.getInstance();
                calendar.setTime(parse);
                switch (YMD) {
                    case "Y":
                        result = String.valueOf(calendar.get(Calendar.YEAR));
                        break;
                    case "M":
                        result = String.valueOf(calendar.get(Calendar.MONTH) + 1);
                        break;
                    case "D":
                        result = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
                        break;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 把字符串转化成Date对象   dateStr 日期字符串  formatPattern 字符串的格式
     */
    public static Date stringToDate(String dateStr, String formatPattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(formatPattern);
        Date date = null;
        try {
            date = formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取当前时间 过去一年 一个月还是三个月
     */
    public static String getCurrentTimeYMDAgo(String whatTimeTypeAgo) {
        String resultTime = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();

        switch (whatTimeTypeAgo) {
            case "Y":
                //过去一年
                c.setTime(new Date());
                c.add(Calendar.YEAR, -1);
                Date y = c.getTime();
                String year = format.format(y);
                resultTime = year;
                break;
            case "M":
                //过去一月
                c.setTime(new Date());
                c.add(Calendar.MONTH, -1);
                Date m = c.getTime();
                String mon = format.format(m);
                resultTime = mon;
                break;
            case "3M":
                //过去三个月
                c.setTime(new Date());
                c.add(Calendar.MONTH, -3);
                Date m3 = c.getTime();
                String mon3 = format.format(m3);
                resultTime = mon3;
                break;
            case "W":
                //过去七天
                c.setTime(new Date());
                c.add(Calendar.DATE, -7);
                Date d = c.getTime();
                String day = format.format(d);
                resultTime = day;
                break;
            case "D":
                break;
            default:
                break;
        }
        return resultTime;
    }

    /**
     * 1上午  2下午  3傍晚
     */
    public static int formateTimeHH() {
        String time = formateNowTime_yyyy_MM_dd();
        String dayTime = time.split(" ")[1];
        int hour = Integer.parseInt(dayTime.split(":")[0]);
        if (hour >= 0 && hour < 12)
            return 1;
        else if (hour >= 12 && hour < 18)
            return 2;
        else if (hour >= 18 && hour <= 23)
            return 3;
        return 1;
    }

    /**
     * 是否是今天
     */
    public static boolean isToday(String date) {
        if (TextUtils.equals(formateNowTime_yyyy_MM_dd(), date)) {
            return true;
        }
        return false;
    }

    /**
     * 两天是否是同一天
     */
    public static boolean isTheSameDay(String time1, String time2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//24小时制
        Date date1 = new Date();
        Date date2 = new Date();
        try {
            date1 = sdf.parse(time1);
            date2 = sdf.parse(time2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if ((date2.getYear() - date1.getYear() == 0)) {
            if ((date2.getMonth() - date1.getMonth() == 0)) {
                int temp = date2.getDate() - date1.getDate();
                if (temp == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * 是否在昨天之前
     */
    public static boolean isYesterdayAgo(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//24小时制
        Date date1 = new Date();
        Date date2 = new Date();

        try {
            date1 = sdf.parse(date);
            date2 = sdf.parse(formateNowTime_yyyy_MM_dd());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date1.getYear() < date2.getYear()) {
            return true;
        } else if (date1.getYear() > date2.getYear()) {
            return false;
        } else {
            if (date1.getMonth() < date2.getMonth()) {
                return true;
            } else if (date1.getMonth() > date2.getMonth()) {
                return false;
            } else {
                if (date1.getDate() < date2.getDate()) {
                    return true;
                } else if (date1.getDate() > date2.getDate()) {
                    return false;
                } else {
                    return false;
                }
            }
        }
    }

    /**
     * date1是否是date2之前
     */
    public static boolean isAgo(String dateStr1, String dateStr2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//24小时制
        Date date1 = new Date();
        Date date2 = new Date();
        try {
            date1 = sdf.parse(dateStr1);
            date2 = sdf.parse(dateStr2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date1.getYear() < date2.getYear()) {
            return true;
        } else if (date1.getYear() > date2.getYear()) {
            return false;
        } else {
            if (date1.getMonth() < date2.getMonth()) {
                return true;
            } else if (date1.getMonth() > date2.getMonth()) {
                return false;
            } else {
                if (date1.getDate() < date2.getDate()) {
                    return true;
                } else if (date1.getDate() > date2.getDate()) {
                    return false;
                } else {
                    return false;
                }
            }
        }
    }
    public static String formateNowTime_MM_dd() {
        Calendar c1 = Calendar.getInstance();
        c1.setTimeInMillis(System.currentTimeMillis());
        SimpleDateFormat f1 = new SimpleDateFormat("MM-dd");
        return f1.format(c1.getTime());
    }

    public static String formateNowTime_yyyy_MM_dd() {
        Calendar c1 = Calendar.getInstance();
        c1.setTimeInMillis(System.currentTimeMillis());
        SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM-dd");
        return f1.format(c1.getTime());
    }

    public static String formateTomorrowTime_yyyy_MM_dd() {
        Calendar c1 = Calendar.getInstance();
        c1.setTimeInMillis(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM-dd");
        return f1.format(c1.getTime());
    }

    public static String formateTomorrowTime_yyyy_MM_dd_HH_mm_ss() {
        Calendar c1 = Calendar.getInstance();
        c1.setTimeInMillis(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return f1.format(c1.getTime());
    }

    public static String formateYesterdayTime_yyyy_MM_dd_HH_mm_ss() {
        Calendar c1 = Calendar.getInstance();
        c1.setTimeInMillis(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
        SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return f1.format(c1.getTime());
    }

}
