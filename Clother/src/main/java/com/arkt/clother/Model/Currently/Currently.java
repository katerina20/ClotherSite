package com.arkt.clother.Model.Currently;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Currently implements Serializable {

    private double time;
    private String summary;
    private String icon;
    private double precipProbability;
    private double temperature;
    private double apparentTemperature;
    private double humidity;
    private double pressure;
    private double windSpeed;

    public Currently(double time, String summary, String icon, double precipProbability, double temperature, double apparentTemperature, double humidity, double pressure, double windSpeed) {
        this.time = time;
        this.summary = summary;
        this.icon = icon;
        this.precipProbability = precipProbability;
        this.temperature = temperature;
        this.apparentTemperature = apparentTemperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
    }

    public String getTime() {
        DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM", Locale.US);
        Date date = new Date();
        date.setTime((long)time*1000);
        return dateFormat.format(date);
    }

    public String getSummary() {
        return summary;
    }

    public String getIcon() {
        return icon;
    }

    public int getPrecipProbability() {
        return (int)precipProbability;
    }

    public int getTemperature() {
        return (int)temperature;
    }

    public int getApparentTemperature() {
        return (int)apparentTemperature;
    }

    public int getHumidity() {
        humidity *= 100;
        return (int)humidity;
    }

    public int getPressure() {
        return (int)pressure;
    }

    public int getWindSpeed() {
        return (int)windSpeed;
    }
}
