package com.lis.projects.WebService.parser.impl;

import com.lis.projects.WebService.exception.ParseException;
import com.lis.projects.WebService.parser.Parser;
import org.springframework.stereotype.Component;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.URLConnection;
import java.io.IOException;
import java.net.URL;

/**
 * Parser class for finding the current weather on the yandex.ru web page
 * @author LastFoxTrail
 * @version 1.0
 * {@link Parser}
 */
@Component
public class YandexParser implements Parser {
    private StringBuilder foundData;

    @Override
    public String parseData() {
        return getTemperature();
    }

    /**
     * Method that implements access to the yandex.ru website and parsing its data
     * @return current temperature
     * @throws ParseException - occurs in the event of an error in data processing by the parser
     */
    public String getTemperature() throws  ParseException {

        try {
            URL websiteUrl = new URL("https://yandex.ru/");
            URLConnection urlConnection = websiteUrl.openConnection();
            foundData = new StringBuilder();

            try (BufferedReader inputStream = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                String inputLine;

                while ((inputLine = inputStream.readLine()) != null) {
                    foundData.append(inputLine);
                }
            }

        } catch (IOException e) {
            throw new ParseException("Parse error");
        }

        String foundTemperature = foundData.toString();
        int start = foundTemperature.indexOf("weather__icon");

        if (start == -1) {
            throw new ParseException("Parse error");
        }

        int open = foundTemperature.indexOf("weather__temp", start);
        int close = foundTemperature.indexOf("<", open);

        return foundTemperature.substring(open+15, close);
    }
}
