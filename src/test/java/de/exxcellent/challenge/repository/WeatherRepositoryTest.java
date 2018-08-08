/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.repository;

import de.exxcellent.challenge.domain.IWeatherRepository;
import de.exxcellent.challenge.domain.exception.WeatherException;
import de.exxcellent.challenge.domain.model.DailyWeather;
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
    public void init() throws WeatherException {
        weatherRepository = new WeatherFileRepositoryImpl(WEATHER_CSV_FILE_NAME);
        
        //prepare a randomly test
        expectedWeatherResultList = new ArrayList<>(
                Arrays.asList(
                        new DailyWeather("3",77,55),
                        new DailyWeather("15",64,55),
                        new DailyWeather("28",84,68)));
    }
    
    @Test //TODO Exception handling
    public void testFileRepositoryFindAllWeatherData() throws WeatherException {
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
    
    @Test(expected = WeatherException.class)
    public void testFileRepositoryFileIsNull() throws WeatherException {
        weatherRepository =  new WeatherFileRepositoryImpl(null);
    }
    
    @Test(expected = WeatherException.class)
    public void testFileRepositoryFileNotFound() throws WeatherException {
        final String WEATHER_CSV_WRONG_FILE_NAME = "de/exxcellent/challenge/test.csv";
        weatherRepository =  new WeatherFileRepositoryImpl(WEATHER_CSV_WRONG_FILE_NAME);
        testFileRepositoryFindAllWeatherData();
    }
    
    @Test
    public void testFileRepositoryOptionalParameter() throws WeatherException {
        IWeatherRepository expectedWeatherRepository = new WeatherFileRepositoryImpl(WEATHER_CSV_FILE_NAME, CSV_DELIMITER);
        
        //test delimiter as parameter value
        weatherRepository = new WeatherFileRepositoryImpl(WEATHER_CSV_FILE_NAME, CSV_DELIMITER);
        Assert.assertEquals(expectedWeatherRepository, weatherRepository);
        
        //test delimiter as default value
        weatherRepository = new WeatherFileRepositoryImpl(WEATHER_CSV_FILE_NAME);
        Assert.assertEquals(expectedWeatherRepository, weatherRepository);
    }
    
    @Test(expected = WeatherException.class)
    public void testFileRepositorWrongFileDelimiter() throws WeatherException {
        final String WRONG_CSV_DELIMITER = ";";
        weatherRepository = new WeatherFileRepositoryImpl(WEATHER_CSV_FILE_NAME, WRONG_CSV_DELIMITER);
        testFileRepositoryFindAllWeatherData();
    }
}
