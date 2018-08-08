/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.domain.impl;

import de.exxcellent.challenge.domain.IFootballDomainService;
import de.exxcellent.challenge.domain.exception.FootballException;
import de.exxcellent.challenge.domain.model.FootballTeam;
import java.util.List;

/**
 *
 * @author c.kaddatz
 */
public class FootballDomainServiceImpl implements IFootballDomainService {

    /**
     * 
     * @return the footbal team object with the smallest goal distance
     * @throws FootballException 
     */
    @Override
    public FootballTeam getTeamWithSmallestGoalDistance(List<FootballTeam> footballTeamList) throws FootballException {
        
        if(footballTeamList == null || footballTeamList.isEmpty()) {
            throw new FootballException("The given list of football teams is null or empty");
        }
        
        //sort by absoluteGoalDifference to get the object with the absolute, smallest goal difference
        footballTeamList.sort(
                (footballTeam1, footballTeam2) -> 
                        footballTeam1.getAbsoluteGoalDifference().compareTo(footballTeam2.getAbsoluteGoalDifference()));     
        return footballTeamList.get(0);
    }
}
