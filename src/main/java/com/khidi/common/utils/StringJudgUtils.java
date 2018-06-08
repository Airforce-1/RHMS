package com.khidi.common.utils;

/**
 * Created by admin on 2017/12/26.
 */
public class StringJudgUtils {
    //只能输入字母和数字（用于编号）
    public static boolean isLetterOrDigit(String str) {
        String regex = "^[a-zA-Z0-9]+$";
        return str.matches(regex);
    }

    //智能输入整数和最多六位小数（用于经纬度）
    public static boolean isIntegerOrDecimal(String str) {
        String regex = "^[0-9]+\\.{0,1}[0-9]{0,6}$";
        return str.matches(regex);
    }

    //只能输入最多三位整数和最多两位小数（用于百分比）
    public static boolean isPercent(String str) {
        String regex = "^\\d{1,3}(?:\\.\\d{1,2})?$";
        return str.matches(regex);
    }


}
