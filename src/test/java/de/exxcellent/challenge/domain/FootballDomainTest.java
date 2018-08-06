/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.domain;

import de.exxcellent.challenge.domain.exception.FootballDomainException;
import de.exxcellent.challenge.domain.impl.FootballDomainServiceImpl;
import de.exxcellent.challenge.domain.model.FootballTeam;
import de.exxcellent.challenge.repository.impl.FootballFileRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author c.kaddatz
 */
public class FootballDomainTest {
    
    private static final String FOOTBALL_CSV_FILE_NAME = "de/exxcellent/challenge/football.csv";
    
    private IFootballDomainService footballDomainService;
    private FootballTeam footballTeam;
    
    @Before
    public void init() throws FootballDomainException {
        footballDomainService = new FootballDomainServiceImpl(new FootballFileRepositoryImpl(FOOTBALL_CSV_FILE_NAME));
    }
    
    private FootballTeam createFootballTeam(String team, Integer goals, Integer goalsAllowed) throws FootballDomainException {
        return new FootballTeam(team,goals,goalsAllowed);
    }
    
    @Test
    public void testBaseConstruction() throws FootballDomainException {
        footballTeam = createFootballTeam("Eintracht Frankfurt",58,32);
        Assert.assertEquals("Eintracht Frankfurt", footballTeam.getTeam());
        Assert.assertEquals(new Integer(58), footballTeam.getGoals());
        Assert.assertEquals(new Integer(32), footballTeam.getGoalsAllowed());
    }
    
    @Test(expected = FootballDomainException.class)
    public void testGoalsValueIsNull() throws FootballDomainException {
        footballTeam = createFootballTeam("Eintracht Frankfurt",null,15);
    }
    
    @Test(expected = FootballDomainException.class)
    public void testGoalsAllowedValueIsNull() throws FootballDomainException {
        footballTeam = createFootballTeam("Eintracht Frankfurt",30,null);
    }
    
    @Test(expected = FootballDomainException.class)
    public void testTeamIsNull() throws FootballDomainException {
        footballTeam = createFootballTeam(null,30,15);
    }
    
    @Test
    public void testGetTeamWithSmallestGoalDistance() throws FootballDomainException {
        FootballTeam expectedResult = createFootballTeam("Aston_Villa",46,47);
        Assert.assertEquals(expectedResult.getTeam(), footballDomainService.getTeamWithSmallestGoalDistance().getTeam());
        Assert.assertEquals(expectedResult.getGoals(), footballDomainService.getTeamWithSmallestGoalDistance().getGoals());
        Assert.assertEquals(expectedResult.getGoalsAllowed(), footballDomainService.getTeamWithSmallestGoalDistance().getGoalsAllowed());
    }
    
    @Test(expected = FootballDomainException.class)
    public void testGetTeamWithSmallestGoalDistanceEmptyList() throws FootballDomainException {
        //wrong file
        footballDomainService = new FootballDomainServiceImpl(new FootballFileRepositoryImpl("test"));
        footballDomainService.getTeamWithSmallestGoalDistance();
    }
}
