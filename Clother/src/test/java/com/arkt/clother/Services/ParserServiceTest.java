package com.arkt.clother.Services;

import com.arkt.clother.Model.City.CityModel;
import com.arkt.clother.Model.DarkSkyWeather;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Type;

import static org.junit.Assert.*;

public class ParserServiceTest {

    private RequestService requestService;

    private double lat = 46.4717;
    private double lng = 30.7198;
    private String cityName = "London";

    @Test
    public void getWeather() {
        DarkSkyWeather darkSkyWeather;
        try {
            requestService = new RequestService();
            String jsonLine = requestService.createRequest(String.valueOf(lat), String.valueOf(lng));

            Gson gson = new Gson();
            Type mType = new TypeToken<DarkSkyWeather>(){}.getType();
            darkSkyWeather = gson.fromJson(jsonLine, mType);

        } catch (IOException e) {
            System.out.println("Exception: " + e);
            darkSkyWeather = null;
        }

        assertNotNull(darkSkyWeather);
    }

    @Test
    public void getGeocodingFormCityName() {
        CityModel cityModel;

        try {
            requestService = new RequestService();
            String jsonLine = requestService.createRequest(cityName);

            Gson gson = new Gson();
            Type mType = new TypeToken<CityModel>(){}.getType();
            cityModel = gson.fromJson(jsonLine, mType);

        } catch (IOException e) {
            System.out.println("Exception: " + e);
            cityModel = null;
        }

        assertNotNull(cityModel);
    }

    @Test
    public void getCityNameByCoordinates() {
        String placeName;

        try {
            requestService = new RequestService();
            String jsonLine = requestService.createRequestToGetCityNameByCoordinates(String.valueOf(lat), String.valueOf(lng));

            Gson gson = new Gson();
            Type mType = new TypeToken<CityModel>(){}.getType();
            CityModel cityModel = gson.fromJson(jsonLine, mType);

            placeName = cityModel.getFeatures().get(0).getPlaceName();

        } catch (IOException e) {
            System.out.println("Exception: " + e);
            placeName = null;
        }

        assertNotNull(placeName);
    }
}