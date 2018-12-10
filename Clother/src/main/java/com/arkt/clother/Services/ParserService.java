package com.arkt.clother.Services;

import com.arkt.clother.Model.DarkSkyWeather;
import com.arkt.clother.Model.MapboxGeocoding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;

@Service
public class ParserService {

    private RequestService requestService;
    private DarkSkyWeather darkSkyWeather;
    private MapboxGeocoding mapboxGeocoding;


    public DarkSkyWeather getWeather (String lat, String lng) {

        try {
            requestService = new RequestService();
            String jsonLine = requestService.createRequest(lat, lng);

            Gson gson = new Gson();
            Type mType = new TypeToken<DarkSkyWeather>(){}.getType();
            darkSkyWeather = gson.fromJson(jsonLine, mType);

            return darkSkyWeather;

        } catch (IOException e) {
            System.out.println("Exception: " + e);
            return null;
        }
    }

    public MapboxGeocoding getGeocodingFormCityName (String cityName) {

        try {
            requestService = new RequestService();
            String jsonLine = requestService.createRequest(cityName);

            Gson gson = new Gson();
            Type mType = new TypeToken<MapboxGeocoding>(){}.getType();
            mapboxGeocoding = gson.fromJson(jsonLine, mType);

            return mapboxGeocoding;

        } catch (IOException e) {
            System.out.println("Exception: " + e);
            return null;
        }
    }
}
