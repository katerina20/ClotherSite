package com.arkt.clother.Services;

import com.arkt.clother.Model.DarkSkyWeather;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;

@Service
public class ParserService {

    private RequestService requestService = new RequestService();


    public DarkSkyWeather getWeather (String lat, String lng) {

        try {
            String jsonLine = requestService.createRequest(lat, lng);

            Gson gson = new Gson();
            Type mType = new TypeToken<DarkSkyWeather>(){}.getType();

            return gson.fromJson(jsonLine, mType);

        } catch (IOException e) {
            System.out.println("Exception: " + e);
            return null;
        }
    }
}
