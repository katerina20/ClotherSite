package com.arkt.clother.Model.Hourly;

import java.io.Serializable;
import java.util.List;

public class Hourly implements Serializable {

    private String summary;
    private List<DataForDay> data;

    public Hourly(List<DataForDay> data) {
        this.data = data;
    }

    public List<DataForDay> getDataHourlyList() {
        return data;
    }

    public String getSummary() {
        return summary;
    }
}
