/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.domain.weather;

import de.exxcellent.challenge.domain.weather.exception.WeatherDomainException;
import de.exxcellent.challenge.domain.weather.impl.WeatherDomainServiceImpl;
import de.exxcellent.challenge.domain.weather.model.DailyWeather;
import de.exxcellent.challenge.repository.impl.WeatherFileRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author c.kaddatz
 */
public class WeatherDomainTest {
    
    private static final String WEATHER_CSV_FILE_NAME = "de/exxcellent/challenge/weather.csv";
    
    private IWeatherDomainService weatherDomainService;
    private DailyWeather dailyWeather;
    
    @Before
    public void init() throws WeatherDomainException {
        weatherDomainService = new WeatherDomainServiceImpl(new WeatherFileRepositoryImpl(WEATHER_CSV_FILE_NAME));
    }
    
    private DailyWeather createDailyWeather(String day, Integer mxt, Integer min) throws WeatherDomainException {
        return new DailyWeather(day,mxt,min);
    }
    
    @Test
    public void testBaseConstruction() throws WeatherDomainException {
        dailyWeather = createDailyWeather("15",30,15);
        Assert.assertEquals("15", dailyWeather.getDay());
        Assert.assertEquals(new Integer(30), dailyWeather.getMaxTemperature());
        Assert.assertEquals(new Integer(15), dailyWeather.getMinTemperature());
        Assert.assertEquals(new Integer(15), dailyWeather.getTemperatureSpread());
    }
        
    @Test(expected = WeatherDomainException.class)
    public void testMinValueGreaterThenMaxValue() throws WeatherDomainException {
        dailyWeather = createDailyWeather("17",15,30);
    }
    
    @Test(expected = WeatherDomainException.class)
    public void testMaxValueIsNull() throws WeatherDomainException {
        dailyWeather = createDailyWeather("17",null,15);
    }
    
    @Test(expected = WeatherDomainException.class)
    public void testMinValueIsNull() throws WeatherDomainException {
        dailyWeather = createDailyWeather("17",30,null);
    }
    
    @Test(expected = WeatherDomainException.class)
    public void testDayIsNull() throws WeatherDomainException {
        dailyWeather = createDailyWeather(null,30,15);
    }
    
    @Test
    public void testDayWithSmallestTempSpread() throws WeatherDomainException {
        DailyWeather expectedResult = new DailyWeather("14",61,59);
        Assert.assertEquals(expectedResult.getDay(), weatherDomainService.getDayWithSmallestTempSpread().getDay());
        Assert.assertEquals(expectedResult.getMaxTemperature(), weatherDomainService.getDayWithSmallestTempSpread().getMaxTemperature());
        Assert.assertEquals(expectedResult.getMinTemperature(), weatherDomainService.getDayWithSmallestTempSpread().getMinTemperature());
    }
    
    @Test(expected = WeatherDomainException.class)
    public void testGetDayWithSmallestTempSpreadEmptyList() throws WeatherDomainException {
        //wrong file
        weatherDomainService = new WeatherDomainServiceImpl(new WeatherFileRepositoryImpl("test"));
        weatherDomainService.getDayWithSmallestTempSpread();
    }
}
