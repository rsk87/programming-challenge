/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.repository.impl;

import de.exxcellent.challenge.domain.IFootballRepository;
import de.exxcellent.challenge.domain.exception.FootballDomainException;
import de.exxcellent.challenge.domain.model.FootballTeam;
import java.util.List;

/**
 * CSV file repository implementation
 * @author c.kaddatz
 */
public class FootballFileRepositoryImpl implements IFootballRepository {

    /**
     * 
     * @return
     * @throws FootballDomainException 
     */
    @Override
    public List<FootballTeam> findAllFootballData() throws FootballDomainException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
