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
import java.util.Objects;

/**
 * CSV file repository implementation
 * @author c.kaddatz
 */
public class WeatherFileRepositoryImpl implements IWeatherRepository {
    
    private static final String DEFAULT_ENCODING_FORMAT = "UTF-8";
    private static final String DEFAULT_CSV_DELIMITER = ",";
    
    private String fileName;
    private String encodingFormat;
    private String delimiter;

    /**
     * @param pFileName csv file name
     * @throws de.exxcellent.challenge.repository.exception.WeatherRepositoryException
     */
    public WeatherFileRepositoryImpl(String pFileName) throws WeatherRepositoryException {
      
        if(pFileName == null) {
            throw new WeatherRepositoryException("WeatherFileRepository parameter 'filename' is null");
        }
        
        this.fileName = pFileName;
        this.encodingFormat = DEFAULT_ENCODING_FORMAT;
        this.delimiter = DEFAULT_CSV_DELIMITER;
    }
    
    /**
     * @param pFileName csv file name
     * @param pEncodingFormat data encoding format (optional)
     * @param pDelimiter csv delimiter (optional)
     * @throws de.exxcellent.challenge.repository.exception.WeatherRepositoryException
     */
    public WeatherFileRepositoryImpl(String pFileName, String pEncodingFormat, String pDelimiter) throws WeatherRepositoryException {
        
        if(pFileName == null) {
            throw new WeatherRepositoryException("WeatherFileRepository parameter 'filename' is null");
        }
        
        this.fileName = pFileName;
        this.encodingFormat = DEFAULT_ENCODING_FORMAT;
        this.delimiter = DEFAULT_CSV_DELIMITER;
        
        if(pEncodingFormat != null) {
            this.encodingFormat = pEncodingFormat;
        }
        
        if(pDelimiter != null) {
            this.delimiter = pDelimiter;
        }
    }
    
    /**
     * Read a csv file and mapping the data to domain model
     * @return a list from mapped daily weather data
     */
    @Override
    public List<DailyWeather> findAllWeatherData() throws WeatherRepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.fileName);
        hash = 23 * hash + Objects.hashCode(this.encodingFormat);
        hash = 23 * hash + Objects.hashCode(this.delimiter);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final WeatherFileRepositoryImpl other = (WeatherFileRepositoryImpl) obj;
        if (!Objects.equals(this.fileName, other.fileName)) {
            return false;
        }
        if (!Objects.equals(this.encodingFormat, other.encodingFormat)) {
            return false;
        }
        return Objects.equals(this.delimiter, other.delimiter);
    }
    
    
    
}
