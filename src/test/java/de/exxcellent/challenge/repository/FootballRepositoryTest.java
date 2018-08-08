/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.repository;

import de.exxcellent.challenge.domain.IFootballRepository;
import de.exxcellent.challenge.domain.exception.FootballException;
import de.exxcellent.challenge.domain.model.FootballTeam;
import de.exxcellent.challenge.repository.impl.FootballFileRepositoryImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author c.kaddatz
 */
public class FootballRepositoryTest {
    
    private static final String FOOTBALL_CSV_FILE_NAME = "de/exxcellent/challenge/football.csv";
    private static final String CSV_DELIMITER = ",";
    
    private IFootballRepository footballRepository;
    private List<FootballTeam> expectedFootballResultList;
    
    @Before
    public void init() throws FootballException {
        footballRepository = new FootballFileRepositoryImpl(FOOTBALL_CSV_FILE_NAME);
        
        //prepare a randomly test
        expectedFootballResultList = new ArrayList<>(
                Arrays.asList(
                        new FootballTeam("Manchester United",87,45),
                        new FootballTeam("Middlesbrough",35,47),
                        new FootballTeam("Ipswich",41,64)));
    }
    
    @Test
    public void testFileRepositoryFindAllFootballData() throws FootballException {
        List<FootballTeam> actualFootballList = footballRepository.findAllFootballData();
        Assert.assertNotNull(actualFootballList);
        Assert.assertTrue(actualFootballList.size()==20);
        
        //do check expected result
        expectedFootballResultList.forEach(expectedFootballTeam -> {
            actualFootballList.forEach(actualFootballTeam -> {
                if(actualFootballTeam.getTeam().equals(expectedFootballTeam.getTeam())) {
                    Assert.assertEquals(expectedFootballTeam.getTeam(), actualFootballTeam.getTeam());
                    Assert.assertEquals(expectedFootballTeam.getGoals(), actualFootballTeam.getGoals());
                    Assert.assertEquals(expectedFootballTeam.getGoalsAllowed(), actualFootballTeam.getGoalsAllowed());
                    Assert.assertEquals(expectedFootballTeam.getAbsoluteGoalDifference(), actualFootballTeam.getAbsoluteGoalDifference());
                }
            });
        });
    }
    
    @Test(expected = FootballException.class)
    public void testFileRepositoryFileIsNull() throws FootballException {
        footballRepository =  new FootballFileRepositoryImpl(null);
    }
    
    @Test(expected = FootballException.class)
    public void testFileRepositoryFileNotFound() throws FootballException {
        final String FOOTBALL_CSV_WRONG_FILE_NAME = "de/exxcellent/challenge/test.csv";
        footballRepository =  new FootballFileRepositoryImpl(FOOTBALL_CSV_WRONG_FILE_NAME);
        testFileRepositoryFindAllFootballData();
    }
    
    @Test
    public void testFileRepositoryOptionalParameter() throws FootballException {
        IFootballRepository expectedFootballRepository = new FootballFileRepositoryImpl(FOOTBALL_CSV_FILE_NAME, CSV_DELIMITER);
        
        //test delimiter as parameter value
        footballRepository = new FootballFileRepositoryImpl(FOOTBALL_CSV_FILE_NAME, CSV_DELIMITER);
        Assert.assertEquals(expectedFootballRepository, footballRepository);
        
        //test delimiter as default value
        footballRepository = new FootballFileRepositoryImpl(FOOTBALL_CSV_FILE_NAME);
        Assert.assertEquals(expectedFootballRepository, footballRepository);
    }
    
    @Test(expected = FootballException.class)
    public void testFileRepositorWrongFileDelimiter() throws FootballException {
        final String WRONG_CSV_DELIMITER = ";";
        footballRepository = new FootballFileRepositoryImpl(FOOTBALL_CSV_FILE_NAME, WRONG_CSV_DELIMITER);
        testFileRepositoryFindAllFootballData();
    }
}
