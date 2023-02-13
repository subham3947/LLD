package com.cricbuzz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.cricbuzz.entity.Player;
import com.cricbuzz.entity.ScoreBoard;
import com.cricbuzz.entity.Team;
import com.cricbuzz.service.MatchService;
import com.cricbuzz.service.MathServiceImpl;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
        
        Map<Team, Integer> teamScore = new LinkedHashMap<>();
        ScoreBoard scoreBoard = new ScoreBoard(teamScore);
        MatchService matchService = new MathServiceImpl(scoreBoard);
        matchService.inningsHandler(scoreBoard, "TeamA");
        matchService.inningsHandler(scoreBoard, "TeamB");
        matchService.matchFinishUpdate(teamScore);


    }
}
