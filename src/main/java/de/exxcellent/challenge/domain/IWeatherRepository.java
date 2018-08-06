/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.domain;

import de.exxcellent.challenge.domain.exception.WeatherDomainException;
import de.exxcellent.challenge.domain.model.DailyWeather;
import java.util.List;

/**
 *
 * @author c.kaddatz
 */
public interface IWeatherRepository {
    
    /**
     * TODO perhaps it will be better to change return object type to special repository entity model
     * at the domain service it can be coverted to domain model
     * it has more flexibility
     * @return list of found daily weather objects 
     * @throws de.exxcellent.challenge.domain.exception.WeatherDomainException 
     */
    public List<DailyWeather> findAllWeatherData() throws WeatherDomainException;
}
