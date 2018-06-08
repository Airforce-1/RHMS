package com.khidi.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期处理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年12月21日 下午12:53:33
 */
public class DateUtils {
	/** 时间格式(yyyy-MM-dd) */
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String format(Date date, String pattern) {
        if(date != null){
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    public static Date stringToDate(String strDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_PATTERN);
            return sdf.parse(strDate);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Date stringToDate(String strDate, String pattern) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(strDate);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    public static String plusOneMonth(String strDate) {
       Date date = stringToDate(strDate,"yyyy-MM");
       Calendar cal = new GregorianCalendar();
       cal.setTime(date);
       cal.add(cal.MONTH, 1);
       return format(cal.getTime(),"yyyy-MM");
	}


    /**
     * str="/Date(1487053489965+0800)/"转化为时间
     * @param
     * @return
     */

    public static Date json2Date(String jsonStr){
        jsonStr=jsonStr.replace("/Date(","").replace(")/","");
        String time = jsonStr.substring(0,jsonStr.length()-5);
        Date date = new Date(Long.parseLong(time));
        SimpleDateFormat format = new SimpleDateFormat(DATE_TIME_PATTERN);
        return stringToDate(format.format(date));
    }
}
