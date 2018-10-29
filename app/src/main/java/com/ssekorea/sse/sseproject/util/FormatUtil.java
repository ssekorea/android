package com.ssekorea.sse.sseproject.util;

public class FormatUtil {
    private FormatUtil() {

    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    // yyyyMMdd 인지 확인
    public static boolean isBirthdayFormat(String str) {
        if (str == null) {
            return false;
        }
        if (!isNumeric(str))
            return false;
        if (str.length() != 8) {
            return false;
        }
        int year = Integer.valueOf(str.substring(0, 4));
        int month = Integer.valueOf(str.substring(4, 6));
        int day = Integer.valueOf(str.substring(6, 8));

        if (year<1900 || year>2100)return false;
        if (month<1 || month>12)return false;
        if (day<1 || day>31)return false;
        return true;
    }
}
