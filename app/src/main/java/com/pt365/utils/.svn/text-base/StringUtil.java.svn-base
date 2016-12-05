package com.pt365.utils;

/**
 * @author sunchaoran
 * @version 1.0
 * @Descripe
 * @date 2015/2/10
 */
public class StringUtil {
    public static boolean isNotEmpty(String str) {
        if(str == null) return  false;
        if(str.trim().equals("")) {
            return false;
        }
        return true;
    }

    public static boolean isEmpty(String str) {
        if(str == null) return  true;
        if(str.trim().equals("")) {
            return true;
        }
        return false;
    }

    public static String setPoint(String str, int strNum) {
        if(str != null) {
            if(str.length() <= strNum) {
                return str;
            }
            String temp = str.substring(0, strNum);
            temp = temp+"...";
            return temp;
        }
        return "";
    }
    public static String setText(String str, int strNum) {
        if(str != null) {
            if(str.length() <= strNum) {
                return str;
            }
            String temp = str.substring(0, strNum);
            return temp;
        }
        return "";
    }
}
