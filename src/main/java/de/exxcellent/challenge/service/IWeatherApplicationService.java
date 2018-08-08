/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.service;

import de.exxcellent.challenge.domain.exception.WeatherException;

/**
 *
 * @author c.kaddatz
 */
public interface IWeatherApplicationService {

    /**
     * 
     * @return day with smallest temperature as string 
     * @throws de.exxcellent.challenge.domain.exception.WeatherException 
     */
    public String getDayWithSmallestTempSpread() throws WeatherException;
}
