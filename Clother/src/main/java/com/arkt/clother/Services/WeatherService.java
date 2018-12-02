package com.arkt.clother.Services;

import com.arkt.clother.Model.Currently.Currently;
import com.arkt.clother.Model.Daily.Daily;
import com.arkt.clother.Model.DarkSkyWeather;
import com.arkt.clother.Model.Hourly.Hourly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Autowired
    ParserService parserService;


    public Currently getCurrentlyWeather(Double latitude, Double longitude) {
        return getDarkSkyWeatherObject(latitude, longitude).getCurrently();
    }

    public Hourly getHourlyWeaher(Double latitude, Double longitude) {
        return getDarkSkyWeatherObject(latitude, longitude).getHourly();
    }

    public Daily getDailyWeather(Double latitude, Double longitude) {
        return getDarkSkyWeatherObject(latitude, longitude).getDaily();
    }

    private DarkSkyWeather getDarkSkyWeatherObject(Double latitude, Double longitude) {
        parserService = new ParserService();

        return parserService.getWeather(String.valueOf(latitude), String.valueOf(longitude));
    }
}
