package com.ganshenml.imbeddedscrolllistviewapp.utils;

public class StringUtils {

    public static boolean isEmpty(String s) {
        return s == null || "".equals(s.trim()) || "null".equals(s.trim().toLowerCase());
    }

    public static boolean isNotEmpty(String s) {
        if (s == null || "".equals(s.trim()) || "null".equals(s.trim().toLowerCase())) {
            return false;
        }
        return true;
    }
}
