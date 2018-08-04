/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.domain.weather;

import de.exxcellent.challenge.domain.weather.model.DailyWeather;
import de.exxcellent.challenge.repository.exception.WeatherRepositoryException;
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
     * @throws de.exxcellent.challenge.repository.exception.WeatherRepositoryException 
     */
    public List<DailyWeather> findAllWeatherData() throws WeatherRepositoryException;
}
