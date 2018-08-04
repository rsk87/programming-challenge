/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.domain.weather.exception;

/**
 *
 * @author c.kaddatz
 */
public class WeatherDomainException extends Exception {
    
    /**
     * Constructs a new WeatherDomainServiceException instance and set's the
     * exception message given as parameter
     *
     * @param message
     */
    public WeatherDomainException(String message)
    {
        super(message);
    }

    /**
     * Constructs a new WeatherDomainServiceException instance and set's the
     * exception message given as parameter and additional throwable cause
     *
     * @param message
     * @param cause
     */
    public WeatherDomainException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
}
