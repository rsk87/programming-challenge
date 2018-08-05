/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.service.impl;

import de.exxcellent.challenge.domain.weather.IWeatherDomainService;
import de.exxcellent.challenge.domain.weather.IWeatherRepository;
import de.exxcellent.challenge.domain.weather.impl.WeatherDomainServiceImpl;
import de.exxcellent.challenge.repository.exception.WeatherRepositoryException;
import de.exxcellent.challenge.service.IWeatherService;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            weatherRepository.findAllWeatherData();
        } catch (WeatherRepositoryException ex) {
            Logger.getLogger(WeatherServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
