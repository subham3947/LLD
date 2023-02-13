package com.cricbuzz.entity;

import java.util.Map;

public class ScoreBoard {

    
    //int numberOfOvers;
    int currentScore;
    int target;
    Team team;
    int numberOfOvers;
    int numberOfPlayers;
    Map<Team, Integer> teamScore;

    public Map<Team,Integer> getTeamScore() {
        return this.teamScore;
    }

    public void setTeamScore(Map<Team,Integer> teamScore) {
        this.teamScore = teamScore;
    }

    

    public int getCurrentScore() {
        return this.currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int getTarget() {
        return this.target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public Team getTeam() {
        return this.team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    
    public int getNumberOfOvers() {
        return this.numberOfOvers;
    }

    public void setNumberOfOvers(int numberOfOvers) {
        this.numberOfOvers = numberOfOvers;
    }

    public int getNumberOfPlayers() {
        return this.numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    // public ScoreBoard( int currentScore, int target, Team team,  Map<Team, Integer> teamScore) {
        
    //     this.currentScore = currentScore;
    //     this.target = target;
    //     this.team = team;
    //     this.teamScore = teamScore;
    // }

    public ScoreBoard() {
    }

    public ScoreBoard(Map<Team, Integer> teamScore) {
        this.teamScore = teamScore;
    }
}
