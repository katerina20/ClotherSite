package com.arkt.clother.Controllers;

import com.arkt.clother.Model.City.CoordData;
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

    @GetMapping("/")
    public String main(Model model) {
        return "redirect:/Odessa,Ukraine";
    }

    @GetMapping("{city}")
    public String search(Model model, @PathVariable String city) {

        parserService = new ParserService();

        List<CoordData> list = parserService.getGeocodingFormCityName(city).getFeatures();
        if (list.isEmpty()) {
            return "redirect:/Odessa,Ukraine";
        }

        List<Double> coordinates = parserService.getGeocodingFormCityName(city).getFeatures().get(0).getCenter();

        Double latitude = coordinates.get(1);
        Double longitude = coordinates.get(0);

        darkSkyWeather = parserService.getWeather(String.valueOf(latitude), String.valueOf(longitude));

        Currently currently = darkSkyWeather.getCurrently();
        List<DataForDay> hourlies = darkSkyWeather.getHourly().getDataHourlyList();
        List<DataForWeek> daily = darkSkyWeather.getDaily().getDataHourlyList();

        city = city.replaceAll(",.*", "");
        city = city.replaceAll("_", " ");
        model.addAttribute("cityName", city);
        model.addAttribute("currently", currently);
        model.addAttribute("hourlies", hourlies);
        model.addAttribute("daily", daily);
        model.addAttribute("iconMan", getIconManString(currently.getApparentTemperature()));
        model.addAttribute("daySummary", darkSkyWeather.getHourly().getSummary());

        return "main";
    }

    private String getIconManString (int t){

        if (t >= 25){
            return "firstType";
        }
        else if (t >= 20){
            return "secondType";
        }
        else if (t >= 15){
            return "thirdType";
        }
        else if (t >= 5){
            return "forthType";
        }
        else if (t >= -50){
            return "fifthType";
        }
        return "firstType";
    }
}
