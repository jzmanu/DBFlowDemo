package com.ciotea.dbflowdemo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateUtil.java
 * @author jzman
 * create at 2018/4/17 0017 13:34
 */
public class DateUtil {
    public static final String DATETIME_FORMAT_DEFAULT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_DEFAULT = "yyyy-MM-dd";
    public static final String TIME_FORMAT_DEFAULT = "HH:mm:ss";

    public static String getDate(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }
}
