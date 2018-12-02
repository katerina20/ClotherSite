package com.arkt.clother.Controllers;

import com.arkt.clother.Model.Currently.Currently;
import com.arkt.clother.Model.Daily.DataForWeek;
import com.arkt.clother.Model.DarkSkyWeather;
import com.arkt.clother.Model.Hourly.DataForDay;
import com.arkt.clother.Services.ParserService;
import com.arkt.clother.Services.UnixTimeStamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class Main {

    @Autowired
    UnixTimeStamp unixTimeStamp;

    private ParserService parserService;
    private DarkSkyWeather darkSkyWeather;

    @GetMapping
    public String main(Model model) {

        Double latitude = 46.353805;
        Double longitude = 29.981576;

        parserService = new ParserService();
        darkSkyWeather = parserService.getWeather(String.valueOf(latitude), String.valueOf(longitude));

        Currently currently = darkSkyWeather.getCurrently();
        List<DataForDay> hourlies = darkSkyWeather.getHourly().getDataHourlyList();
        List<DataForWeek> daily = darkSkyWeather.getDaily().getDataHourlyList();

        model.addAttribute("currentlyTime", UnixTimeStamp.unixTimeStampToCurrentlyDate(currently.getTime()));
        model.addAttribute("currently", currently);
        model.addAttribute("hourlies", hourlies);
        model.addAttribute("daily", daily);

        return "main";
    }
}
