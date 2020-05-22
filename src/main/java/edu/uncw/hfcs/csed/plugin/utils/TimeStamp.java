package edu.uncw.hfcs.csed.plugin.utils;

import java.text.SimpleDateFormat;

public class TimeStamp {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy HH:mm:ss");

    public static String capture() {
        return sdf.format(System.currentTimeMillis());
    }

    public static String captureNew(String pattern) {
        return new SimpleDateFormat(pattern).format(System.currentTimeMillis());
    }

    public static String format(long time) {
        return sdf.format(time);
    }

    public static String formatNew(String pattern, long time) {
        return new SimpleDateFormat(pattern).format(time);
    }
}
