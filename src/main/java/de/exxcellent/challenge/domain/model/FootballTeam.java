/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.domain.model;

import de.exxcellent.challenge.domain.exception.FootballDomainException;

/**
 *
 * @author c.kaddatz
 */
public class FootballTeam {
    
    private String team;
    private Integer goals;
    private Integer goalsAllowed;
    private Long absoluteGoalDifference;

    public FootballTeam(String pTeam, Integer pGoals, Integer pGoalsAllowed) throws FootballDomainException {
        
        if(pTeam == null) {
            throw new FootballDomainException("Football team parameter 'team' is null");
        }
        
        if(pGoals == null) {
            throw new FootballDomainException("Football team parameter 'goals' is null");
        }
        
        if(pGoalsAllowed == null) {
            throw new FootballDomainException("Football team parameter 'goalsAllowed' is null");
        }
        
        this.team = pTeam;
        this.goals = pGoals;
        this.goalsAllowed = pGoalsAllowed;
        //absolute difference as unsigned long
        this.absoluteGoalDifference = Integer.toUnsignedLong(goals - goalsAllowed); 
    }
    
    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getGoalsAllowed() {
        return goalsAllowed;
    }

    public void setGoalsAllowed(Integer goalsAllowed) {
        this.goalsAllowed = goalsAllowed;
    }

    public Long getAbsoluteGoalDifference() {
        return absoluteGoalDifference;
    }

    public void setAbsoluteGoalDifference(Long absoluteGoalDifference) {
        this.absoluteGoalDifference = absoluteGoalDifference;
    }
}
