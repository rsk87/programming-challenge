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
    public DailyWeather getDayWithSmallestTempSpread(List<DailyWeather> dailyWeatherList) throws WeatherDomainException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
