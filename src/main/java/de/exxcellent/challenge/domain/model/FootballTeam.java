/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge.domain.model;

/**
 *
 * @author c.kaddatz
 */
public class FootballTeam {
    
    private String team;
    private Integer goals;
    private Integer goalsAllowed;

    public FootballTeam(String team, Integer goals, Integer goalsAllowed) {
        this.team = team;
        this.goals = goals;
        this.goalsAllowed = goalsAllowed;
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
}
