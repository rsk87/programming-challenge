/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.domain.weather;

import de.exxcellent.challenge.domain.weather.exception.WeatherDomainException;
import de.exxcellent.challenge.domain.weather.model.DailyWeather;
import java.util.List;

/**
 *
 * @author c.kaddatz
 */
public interface IWeatherDomainService {
    
    /**
     * Returns the daily weather object with the smallest temperature spread from the given list
     * @param dailyWeatherList
     * @return 
     * @throws de.exxcellent.challenge.domain.weather.exception.WeatherDomainException 
     */
    public DailyWeather getDayWithSmallestTempSpread(List<DailyWeather> dailyWeatherList) throws WeatherDomainException ;
}
