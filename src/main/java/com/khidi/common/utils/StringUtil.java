package com.khidi.common.utils;

import com.qiniu.util.StringUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Shudewei on 2017/11/17.
 */
public class StringUtil {
    //根据传入LIST生成适合oracle适合查询的字符串,  'aaaaa','bbbb'
    public static String joinList(Collection list,String sep){
        String resutlString = StringUtils.join(list, sep);
        return resutlString;
    }


    //根据传入的字符创按，统计个数
    public static int getCount(String s){
        if(s == null){
            return 0;
        }else{
            int i = 0;
            for(int j=0;j<s.length();j++ ){
                char c=s.charAt(j);
                if(c == ','){
                    i++;
                }
            }
            return i+1;
        }
    }


    public static String joinList4sql(Collection list,String sep){
        StringBuilder resutlString = new StringBuilder();

        resutlString = resutlString.append("'").append(StringUtils.join(list, sep)).append("'");
        return resutlString.toString();
    }
    public static void main(String args[]){
        List<String> list = new ArrayList<>();
        list.add("aaaaaaaa");
        list.add("bbbbbbbbb");
        System.out.println(joinList(list,","));
    }


    /**
     *
     * @param string
     * @return
     */
    public static List<String> arrays2List(String string){
        if(isEmpty(string)){
           return new ArrayList();
        }else{
            String a []  = string.split(",");
            List<String>  list = new ArrayList();
            for(int i=0;i<a.length;i++){
                list.add(a[i]);
            }
            return list;
        }
    }

    //删除list中重复的string
    public static List<String> removeDuplicate(List<String> stringList){
        for ( int i = 0 ; i < stringList.size() - 1 ; i ++ ) {
            for ( int j = stringList.size() - 1 ; j > i; j -- ) {
                if (stringList.get(j).equals(stringList.get(i))) {
                    stringList.remove(j);
                }
            }
        }
        return stringList;
    }


    /**
     * 检查字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return null == str ? true : ("".equals(str.trim()) ? true : (str
                .length() <= 0 ? true : false));
    }

    /**
     * 检查字符串是否不为空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 检查字符串是否相同
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isEqual(String str1, String str2) {
        return null == str1 ? (str2 == null ? true : false) : (str1
                .equals(str2) ? true : false);
    }

    /**
     * 检查字符串是否不相同
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isNotEqual(String str1, String str2) {
        return !isEqual(str1, str2);
    }

    /**
     * 检查字符串是否满足指定正则
     *
     * @param str
     * @param regex
     * @return
     */
    public static boolean isMatch(String str, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);

        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 类型转换从String转向Date 格式由String类型的strFromat定义；默认格式为yyyy-MM-dd
     *
     * @param oldString 时间字符串
     * @param strFromat 格式化
     * @return newDate 日期
     */
    public static Date toDate(String oldString, String strFromat) {
        try {
            if (null == strFromat) {
                strFromat = "yyyy-MM-dd";
            }
            SimpleDateFormat bartDateFormat = new SimpleDateFormat(strFromat);
            Date newDate = null;
            if ((null != oldString) && (!oldString.equals(""))) {
                newDate = bartDateFormat.parse(oldString);
            }
            return newDate;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将字符器转成整数，如果转换出错，返回空
     *
     * @param
     * @return
     */
    public static Integer toInt(String numString) {

        try {
            return Integer.parseInt(numString);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将字符串转换成所需要的格式  12,12,12 转  '12','12','12'
     *
     * @param
     * @param format 需要转换的格式标志 "'"
     * @return
     */
    public static String changeFormat(String strs, String format) {
        if (isEmpty(strs)) {
            return "";
        } else {
            //如果format格式不存在，则直接返回当前字符串
            if (isEmpty(format)) {
                return strs;
            }
            //如果存在则转换需要格式
            String tempStrs = "";
            String[] StrGroup = strs.split(",");
            for (int i = 0; i < StrGroup.length; i++) {
                String str = StrGroup[i];
                if (StringUtil.isNotEmpty(str) && str.startsWith(format) && str.endsWith(format)) {
                    tempStrs += str + ",";
                } else if (StringUtil.isNotEmpty(str)) {
                    tempStrs += format + StrGroup[i] + format + ",";
                }
            }
            return tempStrs.substring(0, tempStrs.length() - 1);
        }
    }

    /**
     * 将数值类型转换成字符串类型 如 1 ，长度 转成4 将转成 0001
     *
     * @param i
     * @param length
     * @return
     */
    public static String changeIntToString(Integer i, Integer length) {
        if (i == null) {
            return null;
        }
        String str = String.valueOf(i);
        if (length <= str.length()) {
            return str;
        }
        int count = length - str.length();
        for (int j = 0; j < count; j++) {
            str = "0" + str;
        }
        return str;
    }

    /**
     * 对象格式化
     * 格式参考 java.util.Formatter / SimpleDateFormat
     *
     * @param
     * @param format
     * @return
     */
    public static String format(String format, Object object) {
        if (object == null) return "";
        if (format == null || format.isEmpty()) return object.toString();
        if (object instanceof java.math.BigDecimal) object = Double.parseDouble(object.toString());
        return object instanceof Date ? new SimpleDateFormat(format).format(object) : String.format(format, object);
    }

    /**
     * 保留有效数字
     *
     * @param
     * @param object
     * @return
     */
    public static String formatValid(int valid, Object object) {
        if (object == null) return "";
        object = Double.parseDouble(object.toString());
        String value = String.format("%1." + (valid - 1) + "e", object);
        String[] arr = value.split("e+");
        Double val = Double.parseDouble(arr[0]) * Math.pow(10, Integer.parseInt(arr[1]));
        return val >= 100 ? String.format("%.0f", val) : val >= 10 ? String.format("%.1f", val) : String.format("%.2f", val);
    }

    /**
     * 做加法后按格式输出
     *
     * @param format
     * @param
     * @return
     */
    public static String addFormat(String format, Object... objects) {
        if (objects.length < 1) return "";
        BigDecimal total = new BigDecimal("0");
        for (Object object : objects) {
            if (object != null) {
                total = total.add(new BigDecimal(object.toString()));
            }
        }
        return format(format, total);
    }

    /**
     * 判断一个字符串是否是数字
     *
     * @param numberStr
     * @return
     */
    public static boolean isNumeric(String numberStr) {
        try {
            Double.parseDouble(numberStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * 生成set方法名字段，传入 myName，输出 setMyName
     *反射生成set方法名的时候可以用到
     */
    public static String createSetFunctionName(String parm){
        return "set"+parm.substring(0,1).toUpperCase()+parm.substring(1);
    }


    /**
     *
     *比较传入的三个数，返回最大值
     */
    public static String getMax(int a,int b,int c){
        int max;
        if(a>=b){
            max = a;
        }else{
            max = b;
        }
        if(max<c){
            max = c;
        }
        return String.valueOf(max);
    }

}
