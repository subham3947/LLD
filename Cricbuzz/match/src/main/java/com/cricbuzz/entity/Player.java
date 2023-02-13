package com.cricbuzz.entity;

public class Player {

    public Player(String name,int score, int ballsFaced, int numberOfFours, int numberOfSixes) {
        this.name = name;
        this.score = score;
        this.ballsFaced = ballsFaced;
        this.numberOfFours = numberOfFours;
        this.numberOfSixes = numberOfSixes;
    }

    String name;
    int score;
    int ballsFaced;
    int numberOfFours;
    int numberOfSixes;
    

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getBallsFaced() {
        return this.ballsFaced;
    }

    public void setBallsFaced(int ballsFaced) {
        this.ballsFaced = ballsFaced;
    }

    public int getNumberOfFours() {
        return this.numberOfFours;
    }

    public void setNumberOfFours(int numberOfFours) {
        this.numberOfFours = numberOfFours;
    }

    public int getNumberOfSixes() {
        return this.numberOfSixes;
    }

    public void setNumberOfSixes(int numberOfSixes) {
        this.numberOfSixes = numberOfSixes;
    }
}
