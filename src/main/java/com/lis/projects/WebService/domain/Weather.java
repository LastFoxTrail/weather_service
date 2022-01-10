package com.lis.projects.WebService.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import java.sql.Date;

/**
 * POJO class, associated with database table
 * @author LastFoxTrail
 * @version 1.0
 */
@Entity
@Table(name = "weather_history")
public class Weather {
    @Id
    @Column(name = "weather_date")
    private Date weatherDate;

    @Column(name = "weather_value")
    private String weatherValue;

    public Weather() {
    }

    public Weather(Date weatherDate, String weatherValue) {
        this.weatherDate = weatherDate;
        this.weatherValue = weatherValue;
    }

    public Date getWeatherDate() {
        return weatherDate;
    }

    public void setWeatherDate(Date weatherDate) {
        this.weatherDate = weatherDate;
    }

    public String getWeatherValue() {
        return weatherValue;
    }

    public void setWeatherValue(String weatherValue) {
        this.weatherValue = weatherValue;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "weatherDate=" + weatherDate +
                ", weatherValue='" + weatherValue + '\'' +
                '}';
    }
}
