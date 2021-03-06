/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.service.impl;

import de.exxcellent.challenge.domain.IFootballDomainService;
import de.exxcellent.challenge.domain.IFootballRepository;
import de.exxcellent.challenge.domain.exception.FootballException;
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
        this.footballDomainService = new FootballDomainServiceImpl();
    }

    /**
     * 
     * @return football team with the smallest goal distance as string
     * @throws FootballException 
     */
    @Override
    public String getTeamWithSmallestGoalDistance() throws FootballException {
        return footballDomainService.getTeamWithSmallestGoalDistance(
                footballRepository.findAllFootballData()).getTeam();
    }
}
