package com.hollay.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hollay
 * @create 2021-01-27-18:03
 * @description 把字符串转换成日期
 */
public class StringToDateConverter implements Converter<String, Date> {

    /**
     * @param source 传入进来的字符串
     * @return
     */
    @Override
    public Date convert(String source) {
        // 判断
        if (source == null) {
            throw new RuntimeException("请传入数据");
        }
        //把字符串转换成日期
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(source);
        } catch (Exception e) {
            throw new RuntimeException("数据类型转换出现错误");
        }
    }
}
