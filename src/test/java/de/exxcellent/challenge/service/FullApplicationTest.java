/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.service;

import de.exxcellent.challenge.repository.impl.WeatherFileRepositoryImpl;
import de.exxcellent.challenge.service.impl.WeatherServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author c.kaddatz
 */
public class FullApplicationTest {
    
    private IWeatherService weatherService;
    
    private String expectedResult;
    
    @Before
    public void init() {
        final String WEATHER_CSV_FILE_NAME = "de/exxcellent/challenge/weather.csv";
        final String DEFAULT_ENCODING_FORMAT = "UTF-8";
        final String DEFAULT_CSV_DELIMITER = ",";
        weatherService = new WeatherServiceImpl(new WeatherFileRepositoryImpl(WEATHER_CSV_FILE_NAME, DEFAULT_ENCODING_FORMAT, DEFAULT_CSV_DELIMITER));
        expectedResult = "14";
    }
    
    @Test
    public void testDayWithSmallestTempSpread() {
        Assert.assertEquals("test", expectedResult, weatherService.getDayWithSmallestTempSpread()); 
    } 
}
