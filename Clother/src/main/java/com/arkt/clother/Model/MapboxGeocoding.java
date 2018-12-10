package com.arkt.clother.Model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MapboxGeocoding implements Serializable {

    private double latitude;
    private double longitude;
    private String cityName;

    public MapboxGeocoding() {}

    public Map<String, Double> getCoordinates() {
        Map<String, Double> map = new HashMap<>();
        map.put("latitude", this.latitude);
        map.put("longitude", this.longitude);

        return map;
    }

    public String getCityName() {
        return cityName;
    }
}
