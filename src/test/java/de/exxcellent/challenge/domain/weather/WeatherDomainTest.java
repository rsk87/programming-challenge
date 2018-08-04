/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.domain.weather;

import de.exxcellent.challenge.domain.weather.exception.WeatherDomainException;
import de.exxcellent.challenge.domain.weather.impl.WeatherDomainServiceImpl;
import de.exxcellent.challenge.domain.weather.model.DailyWeather;
import de.exxcellent.challenge.repository.exception.WeatherRepositoryException;
import de.exxcellent.challenge.repository.impl.WeatherFileRepositoryImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author c.kaddatz
 */
public class WeatherDomainTest {
    
    private IWeatherDomainService weatherDomainService;
    private DailyWeather dailyWeather;
    
    @Before
    public void init() throws WeatherRepositoryException {
        weatherDomainService = new WeatherDomainServiceImpl(new WeatherFileRepositoryImpl(null,null,null));
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
    public void testDayWithSmallestTempSpread() throws WeatherDomainException, WeatherDomainException {
        DailyWeather expectedResult = new DailyWeather("15",20,20);
        List<DailyWeather> actualeList = new ArrayList<>();
        actualeList.add(new DailyWeather("15",34,20));
        actualeList.add(new DailyWeather("18",18,10));
        actualeList.add(new DailyWeather("20",20,20));
        actualeList.add(new DailyWeather("25",21,9));
        actualeList.add(new DailyWeather("12",30,25));
        Assert.assertEquals(expectedResult, weatherDomainService.getDayWithSmallestTempSpread(actualeList));
    }
    
    @Test(expected = WeatherDomainException.class)
    public void testGetDayWithSmallestTempSpreadEmptyList() throws WeatherDomainException {
        List<DailyWeather> actualeList = new ArrayList<>();
        weatherDomainService.getDayWithSmallestTempSpread(actualeList);
    }
}
