/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.domain.weather.model;

import de.exxcellent.challenge.domain.weather.exception.WeatherDomainException;

/**
 *
 * @author c.kaddatz
 */
public class DailyWeather {
    
    private String day;
    private Integer maxTemperature;
    private Integer minTemperature;
    private Integer temperatureSpread;

    public DailyWeather(String pDay, Integer pMaxTemperature, Integer pMminTemperature) throws WeatherDomainException {
        this.day = pDay;
        this.maxTemperature = pMaxTemperature;
        this.minTemperature = pMminTemperature;
        this.temperatureSpread = this.maxTemperature - this.minTemperature;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Integer maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public Integer getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Integer minTemperature) {
        this.minTemperature = minTemperature;
    }

    public Integer getTemperatureSpread() {
        if(temperatureSpread == null) {
            temperatureSpread = this.maxTemperature - this.minTemperature;
        }
        return temperatureSpread;
    }

    public void setTemperatureSpread(Integer temperatureSpread) {
        this.temperatureSpread = temperatureSpread;
    }
}
