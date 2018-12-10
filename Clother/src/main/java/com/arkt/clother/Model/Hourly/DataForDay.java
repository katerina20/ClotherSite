package com.arkt.clother.Model.Hourly;

import com.arkt.clother.Services.TimeService;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataForDay implements Serializable {

    private double time;
    private String icon;
    private double temperature;
    private double apparentTemperature;
    private double precipProbability;

    public DataForDay(double time, String icon, double temperature, double apparentTemperature, double precipProbability) {
        this.time = time;
        this.icon = icon;
        this.temperature = temperature;
        this.apparentTemperature = apparentTemperature;
        this.precipProbability = precipProbability;
    }

    public String getTime() {

        return TimeService.unixTimeStampToTime(this.time);
    }

    public String getIcon() {
        return icon;
    }

    public int getTemperature() {
        return (int)temperature;
    }

    public int getApparentTemperature() {
        return (int)apparentTemperature;
    }


    public double getPrecipProbability() {
        return precipProbability;
    }
}
