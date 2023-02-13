

class ScoreBoard{

    int numberOfOvers;
    int currentScore;
    int target;

}


class Player{
    
    int score;
    int ballsFaced;
    int numberOfFours;
    int numberOfSixes;
    boolean out;
    boolean onStrike;

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


class Over{
    List<Integer> runs;   //0 4 4 1 0 1 6
}

class Ball{

    boolean valid;

    public boolean isValid(String ballType) {
        if(ballType.equals("Wd") || ballType.equals("Nb"))
            return false;
        return true;
    }

    public int getRun() {
        return this.run;
    }

    public void setRun(int run) {
        this.run = run;
    }
    int run;
}

//1 run? 3 run? Last ball?
//valid balls while input parsing
//check wickets while parsing each ball and set target based on that.
public class Sample{


    public  static void main() {
        
        
        int numberOfPLayers = 5;
        int numberOfOvers = 2;
        

        List<Player> playerList;
        for(int i = 0 ; i < numberOfPLayers; i++){
            playerList.add(P1);
        }
        Team teamA = new Team();
        teamA.setPlayers(playerList);teamA.setName("Team A");
        ScoreBoard scoreBoard = new ScoreBoard(numberOfOvers, 0 ,0, teamA);
        MatchService matchService = new MatchServiceImpl(scoreBoard);
        
        boolean allOut = false;
        int oversBowled = 0;

        while( !allOut || oversBowled != numberOfOvers){

            String ballInput = "W"; //input from user
            matchService.ballByBallUpdate(ballInput);

        }

        Team teamB = new Team();
    }
}
