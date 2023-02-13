package com.cricbuzz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import com.cricbuzz.entity.Player;
import com.cricbuzz.entity.ScoreBoard;
import com.cricbuzz.entity.Team;

public class MathServiceImpl implements MatchService{

    ScoreBoard scoreBoard;
    static int validBalls;
    static int innings = 1;
    

    public MathServiceImpl(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    @Override
    public void ballByBallUpdate(String ball) {
        
        Team currentTeam = scoreBoard.getTeam();
        if(isValidBall(ball)){
            validBalls++;
            updateOvers(currentTeam);
            if(!ball.equalsIgnoreCase("W")){
                //valid delivery
                scoreUpdate(ball, currentTeam);
            }else{
                //wicket
                wicketUpdate(currentTeam);
            }
            if(validBalls == 6 || (currentTeam.getTotalWickets()) == currentTeam.getTotalWickets() - 1){
                //over end or innings end
                overEndOrInningsEndUpdate(currentTeam);
            }
         }else{
            //extras
            extraRunUpdate();
        }
    }

    private void updateOvers(Team currentTeam) {
        double overs = currentTeam.getOversPlayed();
        if(validBalls == 6)
            overs = Math.floor(overs) + 1;
        else    
            overs += 0.1;
        currentTeam.setOversPlayed(overs);
    }

    private void extraRunUpdate() {
        scoreBoard.setCurrentScore(scoreBoard.getCurrentScore() + 1);
    }

    private void overEndOrInningsEndUpdate(Team currentTeam) {
        if(validBalls == 6){
            validBalls = 0 ;
            //currentTeam.setOversPlayed(currentTeam.getOversPlayed() + 1);
        }
        // if(currentTeam.getTotalWickets() == currentTeam.getTotalWickets() - 1){
        //     currentTeam.setOversPlayed(currentTeam.getOversPlayed() + (validBalls % 6) * 0.1);
        // }
        displayScoreBoard();
    }

    private void scoreUpdate(String ball, Team currentTeam) {

        int runs = Integer.parseInt(ball);
        currentTeam.setTotalScore(currentTeam.getTotalScore() + runs);
        scoreBoard.setCurrentScore(scoreBoard.getCurrentScore() + runs);
        updatePlayerScore(currentTeam, runs);
        if(runs == 1 || runs == 3 || validBalls == 6)
            rotateStrike(currentTeam);
    }

    private void wicketUpdate(Team currentTeam) {
        if(currentTeam.getTotalWickets() == currentTeam.getPlayers().size() - 1)
            overEndOrInningsEndUpdate(currentTeam);
        else{
            bringNewBatsmenToBat(currentTeam);
            if(validBalls == 6){
                rotateStrike(currentTeam);
        }
        }
        
    }

    private void bringNewBatsmenToBat(Team team) {
        int[] playersOnStrike = team.getPlayersOnStrike();
        int nextBatsmen = (Math.max(playersOnStrike[0], playersOnStrike[1]) + 1);
        playersOnStrike[0] = nextBatsmen;
        team.setPlayersOnStrike(playersOnStrike);
        team.setTotalWickets(team.getTotalWickets() + 1);
    }

    private void updatePlayerScore(Team team, int runs) {
        int[] playersOnStrike = team.getPlayersOnStrike();
        Player player = team.getPlayers().get(playersOnStrike[0]);
        team.getPlayers().remove(playersOnStrike[0]);

        player.setBallsFaced(player.getBallsFaced() + 1);
        player.setScore(player.getScore() + runs);
        if(runs == 4)
            player.setNumberOfFours(player.getNumberOfFours() + 1);
        if(runs == 6)
            player.setNumberOfSixes(player.getNumberOfSixes() + 1);

        team.getPlayers().add(playersOnStrike[0], player);
    }

    private boolean isValidBall(String ball) {
        return !(ball.equals("Wd") || ball.equals("Nb"));
    }

    private  void rotateStrike(Team team){
        int[] playersOnStrike = team.getPlayersOnStrike();
        int temp = playersOnStrike[0];
        playersOnStrike[0] = playersOnStrike[1];
        playersOnStrike[1] = temp;
        team.setPlayersOnStrike(playersOnStrike);
    }

    public void displayScoreBoard() {
       
        System.out.println("ScoreCard for "+ scoreBoard.getTeam().getName()+" : ");
        System.out.println("Player Name Score 4s 6s Balls");
        Team currentTeam = scoreBoard.getTeam();
        List<Player> players = currentTeam.getPlayers();
        int[] playersOnStrike = currentTeam.getPlayersOnStrike();
        for(int i = 0 ; i < players.size(); i++){
            Player player = players.get(i);
            if(i == playersOnStrike[0] || i == playersOnStrike[1]){
                System.out.print(player.getName()+"* ");
            }else{
                System.out.print(player.getName()+" ");
            }
            System.out.print(player.getScore()+" ");
            System.out.print(player.getNumberOfFours()+" ");
            System.out.print(player.getNumberOfSixes()+" ");
            System.out.print(player.getBallsFaced()+" ");
            System.out.println();
        }
        System.out.println("Total: "+scoreBoard.getCurrentScore()+"/"+currentTeam.getTotalWickets());
        System.out.println("Overs:"+currentTeam.getOversPlayed());
    }

    @Override
    public void inningsHandler(ScoreBoard scoreBoard, String teamName) {

        
        Scanner sc = new Scanner(System.in);
        int numberOfPLayers = 0, numberOfOvers = 0;
        if(scoreBoard.getTeam() == null){
            System.out.println( "Enter number of players : " );
            numberOfPLayers = sc.nextInt();
            System.out.println( "Enter number of overs : " );
            numberOfOvers = sc.nextInt();
        }else{
             numberOfPLayers = scoreBoard.getTeam().getPlayers().size();
             numberOfOvers = scoreBoard.getNumberOfOvers();
        }
        
        System.out.println( "Enter Batting order for team "+innings+":" );
        List<Player> playerList = new ArrayList<>();
        for(int i = 0 ; i < numberOfPLayers; i++){
            System.out.println("Enter Batsmen : ");
            String name = sc.next();
            playerList.add(new Player(name,0, 0, 0, 0));
        }
        int[] playersOnStrike = new int[2];playersOnStrike[0] = 0;playersOnStrike[1] = 1;
        Team team = new Team(teamName, 0, 0, playerList, 0.0, playersOnStrike);

        scoreBoard.setTeam(team);scoreBoard.setNumberOfOvers(numberOfOvers);scoreBoard.setCurrentScore(0);
        if(innings == 1)
            scoreBoard.setTarget(Integer.MAX_VALUE);
        else
            scoreBoard.setTarget(scoreBoard.getCurrentScore() + 1);
        while(team.getTotalScore() < scoreBoard.getTarget() && team.getOversPlayed() != numberOfOvers && team.getTotalWickets() != numberOfPLayers - 1){
            System.out.println("Enter next ball : ");
            String ball = sc.next();
            ballByBallUpdate(ball);
        }
        if(team.getOversPlayed() != numberOfOvers)
            displayScoreBoard();

        Map<Team, Integer> teamScore = scoreBoard.getTeamScore();
        //System.out.println(teamScore);
        teamScore.put(team, scoreBoard.getCurrentScore());
        scoreBoard.setTeamScore(teamScore);
        
        innings += 1;
        //sc.close();
        
    }

    @Override
    public void matchFinishUpdate(Map<Team, Integer> teamScore) {
        // TODO Auto-generated method stub
        Team firstBattingTeam = (Team)teamScore.keySet().toArray()[0];
        Team secondBattingTeam = (Team)teamScore.keySet().toArray()[1];
        System.out.println(firstBattingTeam.getName()+" scored "+firstBattingTeam.getTotalScore()+" runs");
        System.out.println(secondBattingTeam.getName()+" scored "+secondBattingTeam.getTotalScore()+" runs");
        if(firstBattingTeam.getTotalScore() > secondBattingTeam.getTotalScore())
            System.out.println(firstBattingTeam.getName()+" won by "+(firstBattingTeam.getTotalScore() - secondBattingTeam.getTotalScore())+" runs.");
        
        else if(firstBattingTeam.getTotalScore() < secondBattingTeam.getTotalScore())
            System.out.println(secondBattingTeam.getName()+" won by "+(secondBattingTeam.getPlayers().size() - secondBattingTeam.getTotalWickets())+" wickets.");
            
        else
        System.out.println("Match tied.");
        
    }

    
}


