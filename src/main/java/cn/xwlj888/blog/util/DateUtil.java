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
}
