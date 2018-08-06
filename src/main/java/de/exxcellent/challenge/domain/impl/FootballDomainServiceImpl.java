/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.domain.impl;

import de.exxcellent.challenge.domain.IFootballDomainService;
import de.exxcellent.challenge.domain.IFootballRepository;
import de.exxcellent.challenge.domain.exception.FootballDomainException;
import de.exxcellent.challenge.domain.model.FootballTeam;
import java.util.List;

/**
 *
 * @author c.kaddatz
 */
public class FootballDomainServiceImpl implements IFootballDomainService {

    private IFootballRepository footballRepository;

    public FootballDomainServiceImpl(IFootballRepository pFootballRepository) {
        this.footballRepository = pFootballRepository;
    }

    /**
     * 
     * @return the footbal team object with the smallest goal distance
     * @throws FootballDomainException 
     */
    @Override
    public FootballTeam getTeamWithSmallestGoalDistance() throws FootballDomainException {
        List<FootballTeam> footballTeamList = footballRepository.findAllFootballData();
        
        if(footballTeamList == null || footballTeamList.isEmpty()) {
            throw new FootballDomainException("The given list of football teams is null or empty");
        }
        
        //sort by absoluteGoalDifference to get the object with the absolute, smallest goal difference
        footballTeamList.sort(
                (footballTeam1, footballTeam2) -> 
                        footballTeam1.getAbsoluteGoalDifference().compareTo(footballTeam2.getAbsoluteGoalDifference()));     
        return footballTeamList.get(0);
    }
}
