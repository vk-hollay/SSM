package com.hollay.ssmcase.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hollay
 * @create 2021-02-15-20:21
 * @description 日期和字符串的转换
 */
public class DateAndStringConversionUtils {

    /**
     * 日期转换成字符串
     * @param date
     * @param patt
     * @return
     */
    public static String dateToString(Date date, String patt) {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        return sdf.format(date);
    }

    public static Date stringToDate(String str, String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        return sdf.parse(str);
    }

}
