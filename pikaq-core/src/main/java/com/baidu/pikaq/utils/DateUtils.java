package com.baidu.pikaq.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.time.FastDateFormat;

/**
 * 日期格式化utils
 *
 * @author liaoqiqi
 * @version 2014-8-20
 */
public final class DateUtils {

    public static final int SECOND = 1;
    public static final int MINUTE = 2;
    public static final int HOUR = 3;
    public static final int DAY = 4;
    public static final int MILLI_FACTOR = 1000;
    public static final FastDateFormat ISO_DATETIME_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

    /**
     * 系统里默认的日期格式
     */
    public static final String DEFAULT_TIME_FORMAT = "yyyyMMddHHmmss";

    /**
     * 按照给定格式返回代表日期的字符串
     *
     * @param pDate  Date
     * @param format String 日期格式
     *
     * @return String 代表日期的字符串
     */
    public static String formatDate(Date pDate, String format) {

        if (pDate == null) {
            pDate = new Date();
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(pDate);
    }

}
