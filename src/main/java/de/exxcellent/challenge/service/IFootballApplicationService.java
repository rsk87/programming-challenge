/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.service;

import de.exxcellent.challenge.domain.exception.FootballDomainException;

/**
 *
 * @author c.kaddatz
 */
public interface IFootballApplicationService {

    /**
     * 
     * @return football team with the smallest goal distance as string
     * @throws FootballDomainException 
     */
    public String getTeamWithSmallestGoalDistance() throws FootballDomainException;
}
