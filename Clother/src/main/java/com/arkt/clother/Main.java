package com.arkt.clother;

import com.arkt.clother.Model.DarkSkyWeather;
import com.arkt.clother.Services.ParserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class Main {

    private DarkSkyWeather darkSkyWeather;
    private ParserService parserService;

    @GetMapping
    public String main(Model model) {

        return "main";
    }

    @GetMapping("/hi")
    public String hi(Model m) throws IOException {

        parserService = new ParserService();
        darkSkyWeather = parserService.getWeather(String.valueOf(46.353805), String.valueOf(29.981576));

        System.out.println(darkSkyWeather.getCurrently().getTemperature());

        return "main";
    }
}
