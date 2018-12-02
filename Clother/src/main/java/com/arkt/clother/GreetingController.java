package com.arkt.clother;

import com.arkt.clother.Model.DarkSkyWeather;
import com.arkt.clother.Services.ParserService;
import com.arkt.clother.Services.Request;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.lang.reflect.Type;

@Controller
public class GreetingController {

    private DarkSkyWeather darkSkyWeather;
    private ParserService parserService;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/hi")
    public String hi(Model m) throws IOException {

        parserService = new ParserService();
        darkSkyWeather = parserService.getWeather(String.valueOf(46.353805), String.valueOf(29.981576));

        System.out.println(darkSkyWeather.getCurrently().getTemperature());

        return "greeting";
    }
}
