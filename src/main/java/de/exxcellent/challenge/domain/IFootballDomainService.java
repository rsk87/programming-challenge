/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.domain;

import de.exxcellent.challenge.domain.exception.FootballDomainException;
import de.exxcellent.challenge.domain.model.FootballTeam;

/**
 *
 * @author c.kaddatz
 */
public interface IFootballDomainService {
    
    /**
     * Returns the football team object with the smallest goal distance
     * @return 
     * @throws de.exxcellent.challenge.domain.exception.FootballDomainException 
     */
    public FootballTeam getTeamWithSmallestGoalDistance() throws FootballDomainException;
}
