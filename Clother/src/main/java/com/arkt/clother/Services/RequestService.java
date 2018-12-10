package com.arkt.clother.Services;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class RequestService {

    private static final String API_KEY = "dfc4a3914ba24e771fd68f9f45d30bfb";
    private static final String TOKEN = "pk.eyJ1IjoiYXJ0aHVyd2hpdGUiLCJhIjoiY2pwaXNzNXZlMDg1NDNxcXJ3YXl1aTNwYiJ9.tEHxf2O4iGmYZTIP1JUYiA";

    private URL url;
    private HttpURLConnection connection;


    public String createRequest (String lat, String lng) throws IOException {
        String link = "https://api.darksky.net/forecast/" + API_KEY + "/" + lat + "," + lng + "?exclude=alerts,flags&units=auto";

        url = new URL(link);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        InputStream input = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        input.close();

        return response.toString();
    }

    public String createRequest (String cityName) throws IOException {
        String link = "https://api.mapbox.com/geocoding/v5/mapbox.places/" + cityName + ".json?access_token=" + TOKEN;

        url = new URL(link);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        InputStream input = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        input.close();

        return response.toString();
    }

}
