/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.domain.model;

import de.exxcellent.challenge.domain.exception.WeatherDomainException;

/**
 *
 * @author c.kaddatz
 */
public class DailyWeather {
    
    private String day;
    private Integer maxTemperature;
    private Integer minTemperature;
    private Integer temperatureSpread;

    public DailyWeather(String pDay, Integer pMaxTemperature, Integer pMinTemperature) throws WeatherDomainException {
        
        if(pDay == null) {
            throw new WeatherDomainException("Daily weather parameter 'day' is null");
        }
        
        if(pMaxTemperature == null) {
            throw new WeatherDomainException("Daily weather parameter 'max temperature' is null");
        }
        
        if(pMinTemperature == null) {
            throw new WeatherDomainException("Daily weather parameter 'min temeperature' is null");
        }
        
        if(pMinTemperature > pMaxTemperature) {
            throw new WeatherDomainException("Daily weather parameter 'min temeperature' is greater then parameter 'max temperature'");
        }
        
        this.day = pDay;
        this.maxTemperature = pMaxTemperature;
        this.minTemperature = pMinTemperature;
        //compute temperature spread... 
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
