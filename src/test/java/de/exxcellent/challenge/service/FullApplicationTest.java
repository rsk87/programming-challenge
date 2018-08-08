/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.service;

import de.exxcellent.challenge.domain.exception.FootballException;
import de.exxcellent.challenge.domain.exception.WeatherException;
import de.exxcellent.challenge.repository.impl.FootballFileRepositoryImpl;
import de.exxcellent.challenge.repository.impl.WeatherFileRepositoryImpl;
import de.exxcellent.challenge.service.impl.FootballApplicationServiceImpl;
import de.exxcellent.challenge.service.impl.WeatherApplicationServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author c.kaddatz
 */
public class FullApplicationTest {
    
    private IWeatherApplicationService weatherService;
    private IFootballApplicationService footballService;
    
    private String expectedResult;
    
    @Before
    public void init() throws WeatherException, FootballException {
        final String WEATHER_CSV_FILE_NAME = "de/exxcellent/challenge/weather.csv";
        final String FOOTBALL_CSV_FILE_NAME = "de/exxcellent/challenge/football.csv";
        final String DEFAULT_CSV_DELIMITER = ",";
        weatherService = new WeatherApplicationServiceImpl(new WeatherFileRepositoryImpl(WEATHER_CSV_FILE_NAME, DEFAULT_CSV_DELIMITER));
        footballService = new FootballApplicationServiceImpl(new FootballFileRepositoryImpl(FOOTBALL_CSV_FILE_NAME, DEFAULT_CSV_DELIMITER));
    }
    
    @Test
    public void testDayWithSmallestTempSpread() throws WeatherException {
        expectedResult = "14";
        Assert.assertEquals(expectedResult, weatherService.getDayWithSmallestTempSpread()); 
    }
    
    @Test
    public void testTeamWithSmallestGoalDistance() throws FootballException {
        expectedResult = "Aston_Villa";
        Assert.assertEquals(expectedResult, footballService.getTeamWithSmallestGoalDistance()); 
    }
}
