package com.arkt.clother.Services;

import com.arkt.clother.Model.City.CityModel;
import com.arkt.clother.Model.DarkSkyWeather;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;

@Service
public class ParserService {

    private RequestService requestService;
    private DarkSkyWeather darkSkyWeather;
    private CityModel cityModel;


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

    public CityModel getGeocodingFormCityName (String cityName) {

        try {
            requestService = new RequestService();
            String jsonLine = requestService.createRequest(cityName);

            Gson gson = new Gson();
            Type mType = new TypeToken<CityModel>(){}.getType();
            cityModel = gson.fromJson(jsonLine, mType);

            return cityModel;

        } catch (IOException e) {
            System.out.println("Exception: " + e);
            return null;
        }
    }

    public String getCityNameByCoordinates (String latitude, String longitude) {
        try {
            requestService = new RequestService();
            String jsonLine = requestService.createRequestToGetCityNameByCoordinates(latitude, longitude);

            Gson gson = new Gson();
            Type mType = new TypeToken<CityModel>(){}.getType();
            cityModel = gson.fromJson(jsonLine, mType);

            return cityModel.getFeatures().get(0).getPlaceName();

        } catch (IOException e) {
            System.out.println("Exception: " + e);
            return null;
        }
    }
}
