/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.repository.impl;

import de.exxcellent.challenge.domain.IFootballRepository;
import de.exxcellent.challenge.domain.exception.FootballException;
import de.exxcellent.challenge.domain.model.FootballTeam;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * CSV file repository implementation
 * @author c.kaddatz
 */
public class FootballFileRepositoryImpl extends BaseFileRepository implements IFootballRepository {
    
    private static final String COLUMN_TEAM = "Team";
    private static final String COLUMN_GOALS = "Goals";
    private static final String COLUMN_GOALS_ALLOWED = "Goals Allowed";
    
    /**
     * @param pFileName csv file name
     * @throws de.exxcellent.challenge.domain.exception.FootballException
     */
    public FootballFileRepositoryImpl(String pFileName) throws FootballException {
        
        super(pFileName, null);
        
        if(pFileName == null) {
            throw new FootballException("FootballFileRepository parameter 'filename' is null");
        }
    }
    
    /**
     * @param pFileName csv file name
     * @param pDelimiter csv delimiter (optional)
     * @throws de.exxcellent.challenge.domain.exception.FootballException
     */
    public FootballFileRepositoryImpl(String pFileName, String pDelimiter) throws FootballException {
        
        super(pFileName, pDelimiter);
        
        if(pFileName == null) {
            throw new FootballException("FootballFileRepository parameter 'filename' is null");
        }
    }

    /**
     * Read football team csv file and mapping the data to domain model
     * @return a list from mapped football team data
     * @throws FootballException 
     */
    @Override
    public List<FootballTeam> findAllFootballData() throws FootballException {
        List<FootballTeam> result = new ArrayList<>();
        
        URL fileUrl = getFileUrl();
        if(fileUrl == null) {
            throw new FootballException("File with name " + fileName + " not found");
        }

        try {
            
            if(!isDelimiterExisting(fileUrl)) {
                throw new FootballException("File with name " + fileName + " not contains delimiter '" + delimiter + "'");
            }
            
            readCSVFile(fileUrl, Arrays.asList(COLUMN_TEAM,COLUMN_GOALS,COLUMN_GOALS_ALLOWED))
                .forEach(line -> {
                try {
                    result.add(new FootballTeam(line.get(COLUMN_TEAM),Integer.parseInt(line.get(COLUMN_GOALS)),Integer.parseInt(line.get(COLUMN_GOALS_ALLOWED))));
                //find better solution -> addional mapping class
                } catch (FootballException ex) {
                    throw new IllegalArgumentException(ex.getMessage(),ex);
                }
            });
            
        } catch (URISyntaxException | IOException ex) {
            throw new FootballException("Error while reading file with name " + fileName, ex);
        }        
        return result;
    }
        
    /**
     * necessary for test equality of objects...
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.fileName);
        hash = 23 * hash + Objects.hashCode(this.delimiter);
        return hash;
    }
    
    /**
     * necessary for test equality of objects...
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FootballFileRepositoryImpl other = (FootballFileRepositoryImpl) obj;
        if (!Objects.equals(this.fileName, other.fileName)) {
            return false;
        }
        return Objects.equals(this.delimiter, other.delimiter);
    }
}
