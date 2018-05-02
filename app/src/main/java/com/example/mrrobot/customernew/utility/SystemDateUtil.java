package com.example.mrrobot.customernew.utility;

import java.util.Date;

/**
 * Created by Mr Robot on 11/15/2017.
 */

public class SystemDateUtil {
    public static String DATE_TIME_FORMAT = "MM/dd/yyyy HH:mm:ss";

    public static long GET_DAY_BETWEEN(Date dateStart, Date dateTo){
        long diff = dateTo.getTime() - dateStart.getTime();

        long diffDays = diff / (24 * 60 * 60 * 1000);
        return diffDays;
    }

    public static long GET_HOUR_BETWEEN(Date dateStart, Date dateTo){
        long diff = dateTo.getTime() - dateStart.getTime();

        long diffHours = diff / (60 * 60 * 1000);
        return diffHours;
    }

    public static long GET_MIN_BETWEEN(Date dateStart, Date dateTo){
        long diff = dateTo.getTime() - dateStart.getTime();

        long diffMinutes = diff / (60 * 1000);
        return diffMinutes;
    }

    public static long GET_SEC_BETWEEN(Date dateStart, Date dateTo){
        long diff = dateTo.getTime() - dateStart.getTime();

        long diffSeconds = diff / 1000;
        return diffSeconds;
    }
}
