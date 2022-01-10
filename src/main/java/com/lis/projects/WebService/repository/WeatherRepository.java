package com.lis.projects.WebService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lis.projects.WebService.domain.Weather;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.sql.Date;

/**
 * An interface that extends the {@link JpaRepository} interface
 * for access to the data source and work with it
 * @author LastFoxTrail
 * @version 1.0
 */
@Repository
public interface WeatherRepository extends JpaRepository<Weather, Date> {
    Optional<Weather> findByWeatherDate(Date date);
}