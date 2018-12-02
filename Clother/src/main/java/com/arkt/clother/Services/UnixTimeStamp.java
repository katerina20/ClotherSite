package com.arkt.clother.Services;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Service
public class UnixTimeStamp {

    public static String unixTimeStampToTime(double unixTimeStamp){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        date.setTime((long)unixTimeStamp*1000);
        return dateFormat.format(date);
    }

    public static String unixTimeStampToDayOfWeek(double unixTimeStamp) {
        DateFormat dateFormat = new SimpleDateFormat("EEE", Locale.US);
        Date date = new Date();
        date.setTime((long)unixTimeStamp*1000);
        return dateFormat.format(date);
    }

    public static String unixTimeStampToCurrentlyDate(double unixTimeStamp){
        DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM", Locale.US);
        Date date = new Date();
        date.setTime((long)unixTimeStamp*1000);
        return dateFormat.format(date);
    }
}
