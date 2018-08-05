/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.domain.weather.impl;

import de.exxcellent.challenge.domain.weather.IWeatherDomainService;
import de.exxcellent.challenge.domain.weather.IWeatherRepository;
import de.exxcellent.challenge.domain.weather.exception.WeatherDomainException;
import de.exxcellent.challenge.domain.weather.model.DailyWeather;
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
    
    @Override
    public DailyWeather getDayWithSmallestTempSpread() throws WeatherDomainException {
        
        List<DailyWeather> dailyWeatherList = weatherRepository.findAllWeatherData();
        
        if(dailyWeatherList == null || dailyWeatherList.isEmpty()) {
            throw new WeatherDomainException("The given list of daily weather is null or empty");
        }
        
        dailyWeatherList.sort(
                (dailyWeather1, dailyWeather2) -> 
                        dailyWeather1.getTemperatureSpread().compareTo(dailyWeather2.getTemperatureSpread()));
        //dailyWeatherList.forEach((DailyWeather value) -> System.out.println(value.getDay()));
        //System.out.println("Day: " + dailyWeatherList.get(0).getDay());
        return dailyWeatherList.get(0);
    }
}
