package com.lis.projects.WebService.service;

import com.lis.projects.WebService.exception.DatabaseUpdateException;
import com.lis.projects.WebService.exception.DomainNotFoundException;
import com.lis.projects.WebService.exception.ParseException;
import com.lis.projects.WebService.domain.Weather;
import java.sql.Date;

public interface WeatherService {
    Weather findByDate(Date date) throws DomainNotFoundException;
    Weather create(Weather weather) throws DatabaseUpdateException, ParseException;
}
