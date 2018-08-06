/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.domain;

import de.exxcellent.challenge.domain.exception.FootballDomainException;
import de.exxcellent.challenge.domain.model.FootballTeam;
import java.util.List;

/**
 *
 * @author c.kaddatz
 */
public interface IFootballRepository {
    
    /**
     * TODO perhaps it will be better to change return object type to special repository entity model
     * at the domain service it can be coverted to domain model
     * it has more flexibility
     * @return list of found football team objects 
     * @throws de.exxcellent.challenge.domain.exception.FootballDomainException 
     */
    public List<FootballTeam> findAllFootballData() throws FootballDomainException;
}
