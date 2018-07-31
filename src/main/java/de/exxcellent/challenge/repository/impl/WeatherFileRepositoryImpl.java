/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.repository.impl;

import de.exxcellent.challenge.domain.weather.IWeatherRepository;
import de.exxcellent.challenge.domain.weather.model.DailyWeather;
import java.util.List;

/**
 *
 * @author c.kaddatz
 */
public class WeatherFileRepositoryImpl implements IWeatherRepository {

    private String fileName;
    private String encodingFormat;
    private String delimiter;

    public WeatherFileRepositoryImpl(String pFileName, String pEncodingFormat, String pDelimiter) {
        this.fileName = pFileName;
        this.encodingFormat = pEncodingFormat;
        this.delimiter = pDelimiter;
    }
    
    @Override
    public List<DailyWeather> findAllWeatherData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
