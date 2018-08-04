/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.service.impl;

import de.exxcellent.challenge.domain.weather.IWeatherDomainService;
import de.exxcellent.challenge.domain.weather.IWeatherRepository;
import de.exxcellent.challenge.domain.weather.impl.WeatherDomainServiceImpl;
import de.exxcellent.challenge.service.IWeatherService;

/**
 *
 * @author c.kaddatz
 */
public class WeatherServiceImpl implements IWeatherService {

    private IWeatherRepository weatherRepository;

    private IWeatherDomainService weatherDomainService;

    public WeatherServiceImpl(IWeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
        this.weatherDomainService = new WeatherDomainServiceImpl(weatherRepository);
    }

    @Override
    public String getDayWithSmallestTempSpread() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
