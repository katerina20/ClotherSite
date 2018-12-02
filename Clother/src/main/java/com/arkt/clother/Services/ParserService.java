package com.arkt.clother.Services;

import com.arkt.clother.Model.DarkSkyWeather;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;

public class ParserService {

    private DarkSkyWeather darkSkyWeather;

    public DarkSkyWeather getWeather (String lat, String lng) throws IOException {

        Request request = new Request();
        String jsonLine = request.createRequest(lat, lng);

        Gson gson = new Gson();
        Type mType = new TypeToken<DarkSkyWeather>(){}.getType();
        darkSkyWeather = gson.fromJson(jsonLine, mType);

        return darkSkyWeather;
    }




}
