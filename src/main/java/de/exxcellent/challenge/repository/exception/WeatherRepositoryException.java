/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.repository.exception;

/**
 * Exception handling of the weather repository
 * @author c.kaddatz
 */
public class WeatherRepositoryException extends Exception {
    
    /**
     * Constructs a new WeatherRepositoryException instance and set's the
     * exception message given as parameter
     *
     * @param message
     */
    public WeatherRepositoryException(String message)
    {
        super(message);
    }

    /**
     * Constructs a new WeatherRepositoryException instance and set's the
     * exception message given as parameter and additional throwable cause
     *
     * @param message
     * @param cause
     */
    public WeatherRepositoryException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
