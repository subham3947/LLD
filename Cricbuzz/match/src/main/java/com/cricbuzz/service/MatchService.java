package com.cricbuzz.service;

import java.util.Map;

import com.cricbuzz.entity.ScoreBoard;
import com.cricbuzz.entity.Team;

public interface MatchService {

    //public List<Player> createTeam(String player);

    

    public void inningsHandler(ScoreBoard scoreBoard, String teamName);
    
    public void  ballByBallUpdate(String ball);

    public void displayScoreBoard();

    public void matchFinishUpdate(Map<Team ,Integer> teamScore);
    
}
