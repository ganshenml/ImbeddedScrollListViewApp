package com.ganshenml.imbeddedscrolllistviewapp.utils;

import java.util.List;

public class ListUtils {

    public static boolean isEmpty(List list) {
        if (list == null || list.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNotEmpty(List list) {
        if (list == null || list.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

}
