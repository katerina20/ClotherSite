package com.arkt.clother.Services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeService {

    public static String unixTimeStampToTime(double unixTimeStamp){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        date.setTime((long)unixTimeStamp*1000);
        return dateFormat.format(date);
    }


    public static String unixTimeStampToDayOfWeek(double unixTimeStamp) {

        if(unixTimeStamp < 0){
            return "not unix";
        }
        DateFormat dateFormat = new SimpleDateFormat("EEE", Locale.US);
        Date date = new Date();
        date.setTime((long)unixTimeStamp*1000);
        return dateFormat.format(date);
    }

    private void convert (DateFormat dateFormat){


    }



}
