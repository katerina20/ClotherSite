package com.arkt.clother.Controllers;

import com.arkt.clother.Model.Currently.Currently;
import com.arkt.clother.Model.Daily.Daily;
import com.arkt.clother.Model.Hourly.Hourly;
import com.arkt.clother.Services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Main {

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public String main(Model model) {

        Double latitude = 46.353805;
        Double longitude = 29.981576;

        Currently currently = weatherService.getCurrentlyWeather(latitude, longitude);
        Hourly hourly = weatherService.getHourlyWeaher(latitude, longitude);
        Daily daily = weatherService.getDailyWeather(latitude, longitude);

        model.addAttribute("currently", currently);
        model.addAttribute("hourly", hourly);
        model.addAttribute("daily", daily);

        return "main";
    }
}
