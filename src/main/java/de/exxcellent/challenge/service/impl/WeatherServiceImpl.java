/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.service.impl;

import de.exxcellent.challenge.domain.IWeatherDomainService;
import de.exxcellent.challenge.domain.IWeatherRepository;
import de.exxcellent.challenge.domain.exception.WeatherDomainException;
import de.exxcellent.challenge.domain.impl.WeatherDomainServiceImpl;
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
    public String getDayWithSmallestTempSpread() throws WeatherDomainException {
        return weatherDomainService.getDayWithSmallestTempSpread().getDay();
    }
}
