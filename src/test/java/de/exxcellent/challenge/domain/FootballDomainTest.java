/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.domain;

import de.exxcellent.challenge.domain.exception.FootballDomainException;
import de.exxcellent.challenge.domain.impl.FootballDomainServiceImpl;
import de.exxcellent.challenge.domain.model.FootballTeam;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author c.kaddatz
 */
public class FootballDomainTest {
    
    private IFootballDomainService footballDomainService;
    private FootballTeam footballTeam;
    
    @Before
    public void init() throws FootballDomainException {
        footballDomainService = new FootballDomainServiceImpl();
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
        FootballTeam expectedResult = createFootballTeam("FC Bayern München",46,47);
        
        List<FootballTeam> actualList = new ArrayList<>();
        actualList.add(createFootballTeam("Eintracht Frankfurt",58,32));
        actualList.add(createFootballTeam("Darmstadt 98",30,60));
        actualList.add(expectedResult);
        
        FootballTeam actualResult = footballDomainService.getTeamWithSmallestGoalDistance(actualList);
        Assert.assertEquals(expectedResult.getTeam(), actualResult.getTeam());
        Assert.assertEquals(expectedResult.getGoals(), actualResult.getGoals());
        Assert.assertEquals(expectedResult.getGoalsAllowed(), actualResult.getGoalsAllowed());
    }
    
    @Test(expected = FootballDomainException.class)
    public void testGetTeamWithSmallestGoalDistanceEmptyList() throws FootballDomainException {
        footballDomainService.getTeamWithSmallestGoalDistance(new ArrayList<>());
    }
}
