package com.arkt.clother.Services;

import com.arkt.clother.Model.DarkSkyWeather;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Type;

import static org.junit.Assert.*;

public class ParserServiceTest {

    private double lat = 46.4717;
    private double lng = 30.7198;

    @Test
    public void getWeather() {
        DarkSkyWeather darkSkyWeather;
        try {
            RequestService requestService = new RequestService();
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
}