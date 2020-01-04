package com.itqf.erp.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 飞鸟
 * @date 2019/7/11 - 9:31
 */
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
        try {
            return sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
