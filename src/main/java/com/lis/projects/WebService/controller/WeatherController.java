package com.lis.projects.WebService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.lis.projects.WebService.service.WeatherService;
import com.lis.projects.WebService.domain.Weather;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.Calendar;
import java.sql.Date;

/**
 * Service endpoint (/weather) for finding today's weather
 * @author LastFoxTrail
 * @version 1.0
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService WEATHER_SERVICE;

    @Autowired
    public WeatherController(WeatherService WEATHER_SERVICE) {
        this.WEATHER_SERVICE = WEATHER_SERVICE;
    }

    @GetMapping
    public ResponseEntity<Weather> getTodayWeather() {

        try {
            Weather weather = WEATHER_SERVICE.findByDate(
                    new Date(Calendar.getInstance().getTime().getTime())
            );

            return new ResponseEntity<>(weather, HttpStatus.OK);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
