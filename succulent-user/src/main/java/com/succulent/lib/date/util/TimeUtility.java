package com.succulent.lib.date.util;

//import com.saibeiyou.lib.date.TimeUnit;

public class TimeUtility {

    /**
     * 获取当前时间戳
     * @param timeUnit  时间戳的时间单位
     * @param radix 获取的时间戳结果转为多少进制
     * @return 时间戳
     */
    public static String getCurrentTimestamp(TimeUnit timeUnit, int radix) {
        if (timeUnit == TimeUnit.S) {
            return Long.toString(System.currentTimeMillis() / 1000, radix);
        } else {
            return Long.toString(System.currentTimeMillis(), radix);
        }
    }

    /// 获取当前时间戳（单位：秒）
    public static int getCurrentTimestampSecond() {
        return Integer.parseInt(TimeUtility.getCurrentTimestamp(TimeUnit.S, 10));
    }

    /// 获取当前时间戳（单位：毫秒）
    public static long getCurrentTimestampMilliSecond() {
        return System.currentTimeMillis();
    }

}
