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
import de.exxcellent.challenge.service.IWeatherApplicationService;

/**
 *
 * @author c.kaddatz
 */
public class WeatherApplicationServiceImpl implements IWeatherApplicationService {

    private IWeatherRepository weatherRepository;
    private IWeatherDomainService weatherDomainService;

    public WeatherApplicationServiceImpl(IWeatherRepository pWeatherRepository) {
        this.weatherRepository = pWeatherRepository;
        this.weatherDomainService = new WeatherDomainServiceImpl(weatherRepository);
    }

    /**
     * 
     * @return day with the smallest temperature as string
     * @throws WeatherDomainException 
     */
    @Override
    public String getDayWithSmallestTempSpread() throws WeatherDomainException {
        return weatherDomainService.getDayWithSmallestTempSpread().getDay();
    }
}
