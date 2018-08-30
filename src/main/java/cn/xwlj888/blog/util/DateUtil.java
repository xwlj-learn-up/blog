package cn.xwlj888.blog.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author
 * @create 2018-08-24 11:51
 **/
public class DateUtil {
    /**
     * 日期转换类
     */
    public static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat();

    /**
     * 日期格式：yyyy-MM-dd
     */
    public final static String DATE_HORIZONTAL_FORMAT = "yyyy-MM-dd";

    /**
     * 日期格式：yyyy-MM-dd HH:mm:ss
     */
    public final static String DATETIME_HORIZONTAL_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式：yyyy-MM-dd HH mm ss
     */
    public final static String DATETIME_HORIZONTAL_FORMAT_2 = "yyyy-MM-dd HH mm ss";

    /**
     * 日期格式：yyyy-MM-dd HH:mm:ss.SSS
     */
    public final static String DATETIME_HORIZONTAL_MS_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 日期格式：yyyy-MM-dd HH:mm:ssSSS
     */
    public final static String DATETIME_HORIZONTAL_MS_FORMAT_1 = "yyyy-MM-dd HH:mm:ssSSS";

    /**
     * 日期格式：yyyyMMdd
     */
    public final static String DATE_TIGHT_FORMAT = "yyyyMMdd";

    /**
     * 日期格式：yyyyMMddHHmmss
     */
    public final static String DATETIME_TIGHT_FORMAT = "yyyyMMddHHmmss";

    /**
     * 日期格式(中文)：yyyy年MM月dd日
     */
    public final static String DATE_CN_FORMAT = "yyyy年MM月dd日";

    /**
     * 日期格式(中文)：yyyy年MM月dd日 HH时mm分ss秒
     */
    public final static String DATETIME_CN_FORMAT = "yyyy年MM月dd日 HH时mm分ss秒";

    /**
     * 日期格式(中文)：yyyy年MM月dd日 HH:mm:ss
     */
    public final static String DATETIME_CN_FORMAT_2 = "yyyy年MM月dd日 HH:mm:ss";

    /**
     *
     */
    public final static String TYPE_DATE = "date";

    /**
     *
     */
    public final static String TYPE_DATETIME = "datetime";

    /**
     * 日期格式(斜线)：yyyy/MM/dd
     */
    public final static String DATE_OBLIQUE_FORMAT = "yyyy/MM/dd";

    /**
     * 日期格式(斜线)：yyyy/MM/dd HH:mm:ss
     */
    public final static String DATETIME_OBLIQUE_FORMAT = "yyyy/MM/dd HH:mm:ss";

    /**
     * 日期格式(斜线)：yyyy/MM/dd HH:mm:ss.SSS
     */
    public final static String DATETIME_OBLIQUE_MS_FORMAT = "yyyy/MM/dd HH:mm:ss.SSS";

    /**
     * 日期格式(斜线)：yyyy/MM/dd HH:mm:ssSSS
     */
    public final static String DATETIME_OBLIQUE_MS_FORMAT_2 = "yyyy/MM/dd HH:mm:ssSSS";

    /**
     * 时间格式：HH:mm:ss
     */
    public final static String TIME_FORMAT = "HH:mm:ss";

    /**
     * 时间格式：HHmmss
     */
    public final static String TIME_FORMAT_TIGHT = "HHmmss";

    /**
     * 日期格式--年月：yyyy-MM
     */
    public final static String YYYY_MM = "yyyy-MM";

    /**
     * 日期格式--年份：yyyy
     */
    public final static String YYYY = "yyyy";

    /**
     * 日期格式--月份：MM
     */
    public final static String MM = "MM";

    /**
     * 日期格式--日：dd
     */
    public final static String DD = "dd";


    /**
     * 转换Timestamp对象为指定日期格式的式字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String formatTimestamp(Date date, String format) {
        if (date == null) {
            return "";
        }
        SIMPLE_DATE_FORMAT.applyPattern(format);
        return SIMPLE_DATE_FORMAT.format(date);
    }

    public static String getDate() {
        return DateUtil.formatTimestamp(new Date(), DateUtil.DATETIME_HORIZONTAL_FORMAT);
    }

    /**
     * 日期格式(中文)：yyyy年MM月dd日 HH时mm分ss秒
     */
    public static String getZH_Date() {
        return DateUtil.formatTimestamp(new Date(), DateUtil.DATETIME_CN_FORMAT);
    }
    //时间工具类计算总时间
    public static String friendDuration(long ms) {
        short ss = 1000;
        int mi = ss * 60;
        int hh = mi * 60;
        int dd = hh * 24;
        long day = ms / (long) dd;
        long hour = (ms - day * (long) dd) / (long) hh;
        long minute = (ms - day * (long) dd - hour * (long) hh) / (long) mi;
        long second = (ms - day * (long) dd - hour * (long) hh - minute * (long) mi) / (long) ss;
        long milliSecond = ms - day * (long) dd - hour * (long) hh - minute * (long) mi - second * (long) ss;
        StringBuilder str = new StringBuilder();
        if (day > 0L) {
            str.append(day).append("天,");
        }
        if (hour > 0L) {
            str.append(hour).append("时");
        }
        if (minute > 0L) {
            str.append(minute).append("分");
        }
        if (second > 0L) {
            str.append(second).append("秒");
        }
        if (milliSecond > 0L) {
            str.append(milliSecond).append("毫秒");
        }
        if (str.length() > 0) {
            str = str.deleteCharAt(str.length() - 1);
        }
        return str.toString();
    }
}
