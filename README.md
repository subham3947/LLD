# LLD
Scanner sc = new Scanner(System.in);
        System.out.println( "Enter number of players : " );
        int numberOfPLayers = sc.nextInt();
        System.out.println( "Enter number of overs : " );
        int numberOfOvers = sc.nextInt(numberOfPLayers);
        System.out.println( "Enter Batting order for team 1 : " );
        List<Player> playerList = new ArrayList<>();
        for(int i = 0 ; i < numberOfPLayers; i++){
            System.out.println("Enter Batsmen : ");
            String name = sc.next();
            playerList.add(new Player(name,0, 0, 0, 0));
        }
        Team teamA = new Team();int[] playersOnStrike = new int[2];playersOnStrike[0] = 0;playersOnStrike[1] = 1;
        teamA.setPlayers(playerList);teamA.setName("Team A");teamA.setPlayersOnStrike(playersOnStrike);
        ScoreBoard scoreBoard = new ScoreBoard(numberOfOvers, 0 ,0, teamA);
        MatchService matchService = new MathServiceImpl(scoreBoard);
        while(teamA.getOversPlayed() != numberOfOvers && teamA.getTotalWickets() != numberOfPLayers - 1){
            System.out.println("Enter next ball : ");
            String ball = sc.next();
            matchService.ballByBallUpdate(ball);
        }
        if(teamA.getOversPlayed() != numberOfOvers)
            matchService.displayScoreBoard();