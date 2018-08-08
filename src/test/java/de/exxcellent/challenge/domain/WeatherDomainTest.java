/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.domain;

import de.exxcellent.challenge.domain.exception.WeatherDomainException;
import de.exxcellent.challenge.domain.impl.WeatherDomainServiceImpl;
import de.exxcellent.challenge.domain.model.DailyWeather;
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
    public void init() throws WeatherDomainException {
        weatherDomainService = new WeatherDomainServiceImpl();
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
        DailyWeather expectedResult = createDailyWeather("14",61,59);
        List<DailyWeather> actualList = new ArrayList<>();
        actualList.add(createDailyWeather("20",58,32));
        actualList.add(createDailyWeather("2",60,30));
        actualList.add(expectedResult);
        
        DailyWeather actualResult = weatherDomainService.getDayWithSmallestTempSpread(actualList);
        Assert.assertEquals(expectedResult.getDay(),actualResult.getDay());
        Assert.assertEquals(expectedResult.getMaxTemperature(), actualResult.getMaxTemperature());
        Assert.assertEquals(expectedResult.getMinTemperature(), actualResult.getMinTemperature());
    }
    
    @Test(expected = WeatherDomainException.class)
    public void testGetDayWithSmallestTempSpreadEmptyList() throws WeatherDomainException {
        weatherDomainService.getDayWithSmallestTempSpread(new ArrayList<>());
    }
}
