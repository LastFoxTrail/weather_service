package com.lis.projects.WebService.service.impl;

import com.lis.projects.WebService.exception.DomainNotFoundException;
import com.lis.projects.WebService.exception.DatabaseUpdateException;
import com.lis.projects.WebService.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.lis.projects.WebService.exception.ParseException;
import com.lis.projects.WebService.service.WeatherService;
import com.lis.projects.WebService.domain.Weather;
import com.lis.projects.WebService.parser.Parser;
import org.springframework.stereotype.Service;
import java.sql.Date;

/**
 * Service layer that implements business logic of the application
 * Implements {@link WeatherService}
 * @author LastFoxTrail
 * @version 1.0
 */
@Service
public class WeatherServiceImpl implements WeatherService {
    private final WeatherRepository WEATHER_REPOSITORY;
    private final Parser YANDEX_PARSER;

    @Autowired
    public WeatherServiceImpl(WeatherRepository WEATHER_REPOSITORY, Parser YANDEX_PARSER) {
        this.WEATHER_REPOSITORY = WEATHER_REPOSITORY;
        this.YANDEX_PARSER = YANDEX_PARSER;
    }

    /**
     * Method that searches for a weather object by the passed date
     * @param date current date
     * @return weather object
     * @throws DomainNotFoundException - thrown if the weather object is not found in the database
     * @throws ParseException - thrown when the data parser does not work correctly
     */
    @Override
    public Weather findByDate(Date date) throws DomainNotFoundException, ParseException {

        try {
            return WEATHER_REPOSITORY
                    .findByWeatherDate(date)
                    .orElseThrow(() -> new DomainNotFoundException("Domain was not found"));

        } catch (DomainNotFoundException ex) {
            String temperature = YANDEX_PARSER.parseData();

            return create(
                    new Weather(date, temperature)
            );
        }
    }

    /**
     * Method that creates a new object in the database
     * @param weather - object to add to the database
     * @return created object
     * @throws DatabaseUpdateException - thrown on error adding an object to the database
     */
    public Weather create(Weather weather) throws DatabaseUpdateException {

        if (weather == null) {
            throw new DatabaseUpdateException("invalid request data");
        }

        return WEATHER_REPOSITORY.save(weather);
    }
}
