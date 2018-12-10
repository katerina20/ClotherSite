package com.arkt.clother.Controllers;

import com.arkt.clother.Model.Currently.Currently;
import com.arkt.clother.Model.Daily.DataForWeek;
import com.arkt.clother.Model.DarkSkyWeather;
import com.arkt.clother.Model.Hourly.DataForDay;
import com.arkt.clother.Services.ParserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class SearchController {

    private ParserService parserService;
    private DarkSkyWeather darkSkyWeather;

    @GetMapping("{city}")
    public String search(Model model, @PathVariable String city) {

        city.toString();




        Double latitude = 46.4288699298;
        Double longitude = 30.7232187;

        parserService = new ParserService();
        darkSkyWeather = parserService.getWeather(String.valueOf(latitude), String.valueOf(longitude));

        Currently currently = darkSkyWeather.getCurrently();
        List<DataForDay> hourlies = darkSkyWeather.getHourly().getDataHourlyList();
        List<DataForWeek> daily = darkSkyWeather.getDaily().getDataHourlyList();

        model.addAttribute("currently", currently);
        model.addAttribute("hourlies", hourlies);
        model.addAttribute("daily", daily);
        return "main";
    }
}
