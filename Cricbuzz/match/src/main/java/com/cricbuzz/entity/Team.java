package com.cricbuzz.entity;

import java.util.List;

public class Team {

    public Team(String name, int totalScore, int totalWickets, List<Player> players, double oversPlayed, int[] playersOnStrike) {
        this.name = name;
        this.totalScore = totalScore;
        this.totalWickets = totalWickets;
        this.players = players;
        this.oversPlayed = oversPlayed;
        this.playersOnStrike = playersOnStrike;
    }

    String name;
    int totalScore;
    int totalWickets;
    List<Player> players;  // P1 P2 P3 P4 P5
    //List<Over> overs;
    double oversPlayed;
    int[] playersOnStrike = new int[2]; //{4,1}
    

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalScore() {
        return this.totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getTotalWickets() {
        return this.totalWickets;
    }

    public void setTotalWickets(int totalWickets) {
        this.totalWickets = totalWickets;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    // public List<Over> getOvers() {
    //     return this.overs;
    // }

    // public void setOvers(List<Over> overs) {
    //     this.overs = overs;
    // }

    public int[] getPlayersOnStrike() {
        return this.playersOnStrike;
    }

    public void setPlayersOnStrike(int[] playersOnStrike) {
        this.playersOnStrike = playersOnStrike;
    }

    public double getOversPlayed() {
        return this.oversPlayed;
    }

    public void setOversPlayed(double oversPlayed) {
        this.oversPlayed = oversPlayed;
    }
}
