package com.ssekorea.sse.sseproject.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
    private DateUtil(){

    }
    public static String getCurrentDateTime(){
        Calendar calendar = Calendar.getInstance();
        java.util.Date date = calendar.getTime();
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
    }
}
