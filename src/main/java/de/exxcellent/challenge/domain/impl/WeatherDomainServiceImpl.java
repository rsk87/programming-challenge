/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.domain.impl;

import de.exxcellent.challenge.domain.IWeatherDomainService;
import de.exxcellent.challenge.domain.exception.WeatherException;
import de.exxcellent.challenge.domain.model.DailyWeather;
import java.util.List;

/**
 *
 * @author c.kaddatz
 */
public class WeatherDomainServiceImpl implements IWeatherDomainService {

    public WeatherDomainServiceImpl() {
    }
    
    /**
     * 
     * @return the daily weather object with the smallest temperature spread
     * @throws WeatherException 
     */
    @Override
    public DailyWeather getDayWithSmallestTempSpread(List<DailyWeather> dailyWeatherList) throws WeatherException {
        
        if(dailyWeatherList == null || dailyWeatherList.isEmpty()) {
            throw new WeatherException("The given list of daily weather is null or empty");
        }
        
        //sort by temperatureSpread to get the object with the smallest temperatureSpread
        dailyWeatherList.sort(
                (dailyWeather1, dailyWeather2) -> 
                        dailyWeather1.getTemperatureSpread().compareTo(dailyWeather2.getTemperatureSpread()));
        return dailyWeatherList.get(0);
    }
}
