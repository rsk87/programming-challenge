/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.domain.exception;

/**
 *
 * @author c.kaddatz
 */
public class FootballException extends Exception {
    
    /**
     * Constructs a new FootballDomainException instance and set's the
     * exception message given as parameter
     *
     * @param message
     */
    public FootballException(String message)
    {
        super(message);
    }

    /**
     * Constructs a new FootballDomainException instance and set's the
     * exception message given as parameter and additional throwable cause
     *
     * @param message
     * @param cause
     */
    public FootballException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
}
