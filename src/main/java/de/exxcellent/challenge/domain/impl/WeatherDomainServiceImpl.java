/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.domain.impl;

import de.exxcellent.challenge.domain.IWeatherDomainService;
import de.exxcellent.challenge.domain.IWeatherRepository;
import de.exxcellent.challenge.domain.exception.WeatherDomainException;
import de.exxcellent.challenge.domain.model.DailyWeather;
import java.util.List;

/**
 *
 * @author c.kaddatz
 */
public class WeatherDomainServiceImpl implements IWeatherDomainService {

    private IWeatherRepository weatherRepository;

    public WeatherDomainServiceImpl(IWeatherRepository pWeatherRepository) {
        this.weatherRepository = pWeatherRepository;
    }
    
    /**
     * 
     * @return
     * @throws WeatherDomainException 
     */
    @Override
    public DailyWeather getDayWithSmallestTempSpread() throws WeatherDomainException {
        
        List<DailyWeather> dailyWeatherList = weatherRepository.findAllWeatherData();
        
        if(dailyWeatherList == null || dailyWeatherList.isEmpty()) {
            throw new WeatherDomainException("The given list of daily weather is null or empty");
        }
        
        //sort by temperatureSpread to get the object with the smallest temperatureSpread
        dailyWeatherList.sort(
                (dailyWeather1, dailyWeather2) -> 
                        dailyWeather1.getTemperatureSpread().compareTo(dailyWeather2.getTemperatureSpread()));
        return dailyWeatherList.get(0);
    }
}
