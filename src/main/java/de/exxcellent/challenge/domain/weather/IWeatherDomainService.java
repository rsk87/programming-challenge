/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.domain.weather;

import de.exxcellent.challenge.domain.weather.model.DailyWeather;
import java.util.List;

/**
 *
 * @author c.kaddatz
 */
public interface IWeatherDomainService {
    
    public DailyWeather getDayWithSmallestTempSpread(List<DailyWeather> dailyWeatherList);
}
