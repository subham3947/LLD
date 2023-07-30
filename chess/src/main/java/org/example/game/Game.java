package org.example.game;

import org.example.constants.Color;
import org.example.constants.GameStatus;
import org.example.entity.Board;
import org.example.entity.Cell;
import org.example.entity.Piece;
import org.example.entity.Player;
import org.example.entity.pieces.King;

import java.util.ArrayList;
import java.util.List;

public class Game {

    Board board;
    Player[] players;

    Player currentPlayer;
    GameStatus gameStatus;
    List<Move> moves;

    public void startGame(String playerName1, String playerName2){

        players[0] = new Player( playerName1, Color.WHITE);
        players[1] = new Player( playerName2, Color.BLACK);
        moves = new ArrayList<>();
        board = new Board();
        board.initializeBoard();
        currentPlayer = players[0];
        gameStatus = GameStatus.ACTIVE;
    }

    public boolean makeMove(int srcRow, int srcCol, int tgtRow, int tgtCol){

        Cell srcCell = board.getChessBoard()[srcRow][srcCol];
        Cell tgtCell = board.getChessBoard()[tgtRow][tgtCol];
        Piece srcPiece = srcCell.getPiece();
        if(srcPiece.isMoveValid(board, srcCell, tgtCell)){
            Piece destPiece = tgtCell.getPiece();
            moves.add(new Move(currentPlayer, srcCell, tgtCell));
            if(destPiece != null){
                destPiece.setAlive(false);
                if(isCheckmateDone(destPiece)){
                    changeGameStatusToCheckMate(destPiece);
                }
            }

            switchPlayer();
            return true;
        }else{
            return false;
        }
    }

    private boolean isCheckmateDone(Piece destPiece) {
        return (destPiece instanceof King);
    }

    private void changeGameStatusToCheckMate(Piece destPiece) {
        if(destPiece.getColor() == Color.BLACK)
            gameStatus = GameStatus.WHITE_WON;
        else
            gameStatus = GameStatus.BLACK_WON;
    }

    private void switchPlayer(){
        if(this.currentPlayer == players[0])
            currentPlayer = players[1];
        else
            currentPlayer = players[0];
    }
}
