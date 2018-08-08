/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.repository.impl;

import de.exxcellent.challenge.domain.IWeatherRepository;
import de.exxcellent.challenge.domain.exception.WeatherDomainException;
import de.exxcellent.challenge.domain.model.DailyWeather;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * CSV file repository implementation
 * @author c.kaddatz
 */
public class WeatherFileRepositoryImpl extends BaseFileRepository implements IWeatherRepository {

    private static final String COLUMN_DAY = "Day";
    private static final String COLUMN_MXT = "MxT";
    private static final String COLUMN_MNT = "MnT";

    /**
     * @param pFileName csv file name
     * @throws de.exxcellent.challenge.domain.exception.WeatherDomainException
     */
    public WeatherFileRepositoryImpl(String pFileName) throws WeatherDomainException {
        
        super(pFileName, null);
        
        if(pFileName == null) {
            throw new WeatherDomainException("WeatherFileRepository parameter 'filename' is null");
        }
    }
    
    /**
     * @param pFileName csv file name
     * @param pDelimiter csv delimiter (optional)
     * @throws de.exxcellent.challenge.domain.exception.WeatherDomainException
     */
    public WeatherFileRepositoryImpl(String pFileName, String pDelimiter) throws WeatherDomainException {
        
        super(pFileName, pDelimiter);
        
        if(pFileName == null) {
            throw new WeatherDomainException("WeatherFileRepository parameter 'filename' is null");
        }
    }
    
    /**
     * Read daily weather csv file and mapping the data to domain model
     * @return a list from mapped daily weather data
     * @throws de.exxcellent.challenge.domain.exception.WeatherDomainException
     */
    @Override
    public List<DailyWeather> findAllWeatherData() throws WeatherDomainException {
        List<DailyWeather> result = new ArrayList<>();
        
        URL fileUrl = getFileUrl();
        if(fileUrl == null) {
            throw new WeatherDomainException("File with name " + fileName + " not found");
        }

        try {
            
            if(!isDelimiterExisting(fileUrl)) {
                throw new WeatherDomainException("File with name " + fileName + " not contains delimiter '" + delimiter + "'");
            }
            
            readCSVFile(fileUrl, Arrays.asList(COLUMN_DAY,COLUMN_MXT,COLUMN_MNT))
                .forEach(line -> {
                try {
                    result.add(new DailyWeather(line.get(COLUMN_DAY),Integer.parseInt(line.get(COLUMN_MXT)),Integer.parseInt(line.get(COLUMN_MNT))));
                //better solution -> addional mapping class
                } catch (WeatherDomainException ex) {
                    throw new IllegalArgumentException(ex.getMessage(),ex);
                }
            });
            
        } catch (URISyntaxException | IOException ex) {
            throw new WeatherDomainException("Error while reading file with name " + fileName, ex);
        }        
        return result;
    }
    
    /**
     * necessary for test equality of objects...
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.fileName);
        hash = 23 * hash + Objects.hashCode(this.delimiter);
        return hash;
    }

    /**
     * necessary for test equality of objects...
     * @return 
     */
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
        return Objects.equals(this.delimiter, other.delimiter);
    }
}
