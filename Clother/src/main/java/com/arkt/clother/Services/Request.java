package com.arkt.clother.Services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Request {

    private URL url;
    private HttpURLConnection con;


    public Request() {

    }

    public String createRequest (String lat, String lng) throws IOException {

        String link = "https://api.darksky.net/forecast/dfc4a3914ba24e771fd68f9f45d30bfb/" + lat + "," + lng + "?exclude=alerts,flags&units=auto";

        url = new URL(link);
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        InputStream input = con.getInputStream();
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
