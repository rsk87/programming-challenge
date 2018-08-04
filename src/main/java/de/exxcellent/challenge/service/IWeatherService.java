/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.service;

/**
 *
 * @author c.kaddatz
 */
public interface IWeatherService {

    /**
     * 
     * @return day with smallest temperature as string 
     */
    public String getDayWithSmallestTempSpread();
}
