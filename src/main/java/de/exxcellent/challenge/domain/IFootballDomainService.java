/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.domain;

import de.exxcellent.challenge.domain.exception.FootballException;
import de.exxcellent.challenge.domain.model.FootballTeam;
import java.util.List;

/**
 *
 * @author c.kaddatz
 */
public interface IFootballDomainService {
    
    /**
     * Returns the football team object with the smallest goal distance
     * @param footballTeamList
     * @return 
     * @throws de.exxcellent.challenge.domain.exception.FootballException 
     */
    public FootballTeam getTeamWithSmallestGoalDistance(List<FootballTeam> footballTeamList) throws FootballException;
}
