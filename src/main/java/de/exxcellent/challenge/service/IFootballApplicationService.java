/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.service;

import de.exxcellent.challenge.domain.exception.FootballException;

/**
 *
 * @author c.kaddatz
 */
public interface IFootballApplicationService {

    /**
     * 
     * @return football team with the smallest goal distance as string
     * @throws FootballException 
     */
    public String getTeamWithSmallestGoalDistance() throws FootballException;
}
