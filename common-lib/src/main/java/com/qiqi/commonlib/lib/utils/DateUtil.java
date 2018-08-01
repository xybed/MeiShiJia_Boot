package com.qiqi.commonlib.lib.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    /**
     * 获取系统时间，根据format的标准来格式化时间
     * @param format 需要让时间形成格式的format字符串
     * @return 时间字符串
     */
    public static String getTime(String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(new Date());
    }

    /**
     * 时间转化为聊天界面显示字符串，专用于im
     * @param timeStamp 单位为毫秒
     */
    public static String getChatTimeStr(long timeStamp) {
        if (timeStamp == 0) return "";
        Calendar inputTime = Calendar.getInstance();
        inputTime.setTimeInMillis(timeStamp);
        Date currenTimeZone = inputTime.getTime();
        Calendar calendar = Calendar.getInstance();
        if (calendar.before(inputTime)) {
            //当前时间在输入时间之前
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
            return sdf.format(currenTimeZone);
        }
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        if (calendar.before(inputTime)) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            return sdf.format(currenTimeZone);
        }
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        if (calendar.before(inputTime)) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            return "昨天" + sdf.format(currenTimeZone);
        } else {
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.set(Calendar.MONTH, Calendar.JANUARY);
            if (calendar.before(inputTime)) {
                SimpleDateFormat sdf = new SimpleDateFormat("M月d日 HH:mm");
                return sdf.format(currenTimeZone);
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
                return sdf.format(currenTimeZone);
            }
        }
    }

    /**
     * 日期转换，date转string
     * @param date 日期的date形式
     * @return 日期的string形式
     */
    public static String getTime(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }
}
