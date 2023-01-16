package com.hxgfk.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
    /**
     * Get date time
     * @return String
     */
    public static String getDateTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        return formatter.format(new Date(System.currentTimeMillis()));
    }
}
