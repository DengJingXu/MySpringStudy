package com.dengjingxu.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: dengjingxu
 * @date: 2020/5/2
 * @description: com.dengjingxu.utils
 * @version: 1.0
 */

/**
 * 自定义类型转换器String转Date对应下面泛型Converter<S,T>位置
 */
public class StringToDate implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        Date parse=null;
        try {
            parse= df.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("字符串转Date出错");
        }
        return parse;
    }
}
