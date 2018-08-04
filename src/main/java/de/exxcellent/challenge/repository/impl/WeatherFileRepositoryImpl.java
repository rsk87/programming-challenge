/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.repository.impl;

import de.exxcellent.challenge.domain.weather.IWeatherRepository;
import de.exxcellent.challenge.domain.weather.model.DailyWeather;
import de.exxcellent.challenge.repository.exception.WeatherRepositoryException;
import java.util.List;

/**
 * CSV file repository implementation
 * @author c.kaddatz
 */
public class WeatherFileRepositoryImpl implements IWeatherRepository {
    
    private String fileName;
    private String encodingFormat;
    private String delimiter;

    /**
     * @param pFileName csv file name
     * @throws de.exxcellent.challenge.repository.exception.WeatherRepositoryException
     */
    public WeatherFileRepositoryImpl(String pFileName) throws WeatherRepositoryException {
      
        this.fileName = pFileName;
        this.encodingFormat = null;
        this.delimiter = null;
    }
    
    /**
     * @param pFileName csv file name
     * @param pEncodingFormat data encoding format (optional)
     * @param pDelimiter csv delimiter (optional)
     * @throws de.exxcellent.challenge.repository.exception.WeatherRepositoryException
     */
    public WeatherFileRepositoryImpl(String pFileName, String pEncodingFormat, String pDelimiter) throws WeatherRepositoryException {
        
        this.fileName = pFileName;
        this.encodingFormat = pEncodingFormat;
        this.delimiter = pDelimiter;
    }
    
    /**
     * Read a csv file and mapping the data to domain model
     * @return a list from mapped daily weather data
     */
    @Override
    public List<DailyWeather> findAllWeatherData() throws WeatherRepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
