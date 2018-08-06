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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
