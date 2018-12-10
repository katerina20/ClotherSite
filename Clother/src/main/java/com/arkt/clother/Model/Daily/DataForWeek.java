package com.arkt.clother.Model.Daily;

import com.arkt.clother.Services.TimeService;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DataForWeek implements Serializable {

    private double time;
    private String icon;
    private double sunriseTime;
    private double sunsetTime;
    private double temperatureHigh;
    private double temperatureLow;
    private double precipProbability;

    public DataForWeek(double time, String icon, double sunriseTime, double sunsetTime, double temperatureHigh, double temperatureLow, double precipProbability) {
        this.time = time;
        this.icon = icon;
        this.sunriseTime = sunriseTime;
        this.sunsetTime = sunsetTime;
        this.temperatureHigh = temperatureHigh;
        this.temperatureLow = temperatureLow;
        this.precipProbability = precipProbability;
    }

    public String getTime() {
        return TimeService.unixTimeStampToDayOfWeek(this.time);
    }

    public String getIcon() {
        return icon;
    }

    public String getSunriseTime() {
        return TimeService.unixTimeStampToTime(this.sunriseTime);
    }

    public String getSunsetTime() {
        return TimeService.unixTimeStampToTime(this.sunsetTime);
    }

    public int getTemperatureHigh() {
        return (int)temperatureHigh;
    }

    public int getTemperatureLow() {
        return (int)temperatureLow;
    }

    public double getPrecipProbability() {
        return precipProbability;
    }
}
