/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.service.impl;

import de.exxcellent.challenge.domain.IFootballDomainService;
import de.exxcellent.challenge.domain.IFootballRepository;
import de.exxcellent.challenge.domain.exception.FootballDomainException;
import de.exxcellent.challenge.domain.impl.FootballDomainServiceImpl;
import de.exxcellent.challenge.service.IFootballApplicationService;

/**
 *
 * @author c.kaddatz
 */
public class FootballApplicationServiceImpl implements IFootballApplicationService {

    private IFootballRepository footballRepository;
    private IFootballDomainService footballDomainService;

    public FootballApplicationServiceImpl(IFootballRepository pFootballRepository) {
        this.footballRepository = pFootballRepository;
        this.footballDomainService = new FootballDomainServiceImpl(footballRepository);
    }

    /**
     * 
     * @return football team with the smallest goal distance as string
     * @throws FootballDomainException 
     */
    @Override
    public String getTeamWithSmallestGoalDistance() throws FootballDomainException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
