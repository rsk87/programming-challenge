/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.repository;

import de.exxcellent.challenge.domain.weather.IWeatherRepository;
import de.exxcellent.challenge.domain.weather.exception.WeatherDomainException;
import de.exxcellent.challenge.domain.weather.model.DailyWeather;
import de.exxcellent.challenge.repository.exception.WeatherRepositoryException;
import de.exxcellent.challenge.repository.impl.WeatherFileRepositoryImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author c.kaddatz
 */
public class WeatherRepositoryTest {
    
    private static final String WEATHER_CSV_FILE_NAME = "de/exxcellent/challenge/weather.csv";
    private static final String CSV_DELIMITER = ",";
    
    private IWeatherRepository weatherRepository;
    private List<DailyWeather> expectedWeatherResultList;
    
    @Before
    public void init() throws WeatherRepositoryException, WeatherDomainException {
        weatherRepository = new WeatherFileRepositoryImpl(WEATHER_CSV_FILE_NAME);
        
        //prepare a randomly test
        expectedWeatherResultList = new ArrayList<>(
                Arrays.asList(
                        new DailyWeather("3",77,55),
                        new DailyWeather("15",64,55),
                        new DailyWeather("28",84,68)));
    }
    
    @Test //TODO Exception handling
    public void testFileRepositoryFindAllWeatherData() throws WeatherRepositoryException {
        List<DailyWeather> actualWeatherList = weatherRepository.findAllWeatherData();
        Assert.assertNotNull(actualWeatherList);
        Assert.assertTrue(actualWeatherList.size()==30);
        
        //do check expected result
        expectedWeatherResultList.forEach(expectedWeather -> {
            actualWeatherList.forEach(actualWeather -> {
                if(actualWeather.getDay().equals(expectedWeather.getDay())) {
                    Assert.assertEquals(expectedWeather.getDay(), actualWeather.getDay());
                    Assert.assertEquals(expectedWeather.getMaxTemperature(), actualWeather.getMaxTemperature());
                    Assert.assertEquals(expectedWeather.getMinTemperature(), actualWeather.getMinTemperature());
                    Assert.assertEquals(expectedWeather.getTemperatureSpread(), actualWeather.getTemperatureSpread());
                }
            });
        });
    }
    
    @Test(expected = WeatherRepositoryException.class)
    public void testFileRepositoryFileIsNull() throws WeatherRepositoryException {
        weatherRepository =  new WeatherFileRepositoryImpl(null);
    }
    
    @Test(expected = WeatherRepositoryException.class)
    public void testFileRepositoryFileNotFound() throws WeatherRepositoryException {
        final String WEATHER_CSV_WRONG_FILE_NAME = "de/exxcellent/challenge/test.csv";
        weatherRepository =  new WeatherFileRepositoryImpl(WEATHER_CSV_WRONG_FILE_NAME);
        testFileRepositoryFindAllWeatherData();
    }
    
    @Test
    public void testFileRepositoryOptionalParameter() throws WeatherRepositoryException {
        IWeatherRepository expectedWeatherRepository = new WeatherFileRepositoryImpl(WEATHER_CSV_FILE_NAME, CSV_DELIMITER);
        
        //test delimiter as parameter value
        weatherRepository = new WeatherFileRepositoryImpl(WEATHER_CSV_FILE_NAME, CSV_DELIMITER);
        Assert.assertEquals(expectedWeatherRepository, weatherRepository);
        
        //test delimiter as default value
        weatherRepository = new WeatherFileRepositoryImpl(WEATHER_CSV_FILE_NAME);
        Assert.assertEquals(expectedWeatherRepository, weatherRepository);
    }
    
    @Test(expected = WeatherRepositoryException.class)
    public void testFileRepositorWrongFileDelimiter() throws WeatherRepositoryException {
        final String WRONG_CSV_DELIMITER = ";";
        weatherRepository = new WeatherFileRepositoryImpl(WEATHER_CSV_FILE_NAME, WRONG_CSV_DELIMITER);
        testFileRepositoryFindAllWeatherData();
    }
}
