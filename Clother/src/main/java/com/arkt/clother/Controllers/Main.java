package com.arkt.clother.Controllers;

import com.arkt.clother.Model.Currently.Currently;
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

        Currently currently = weatherService.getCurrentlyWeather(46.353805, 29.981576);
        System.out.println(currently.getTemperature());

        return "main";
    }
}
