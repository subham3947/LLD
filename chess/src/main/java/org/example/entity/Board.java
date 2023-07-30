package org.example.entity;

import org.example.constants.BoardConstants;

public class Board {



    Cell[][] chessBoard;

    public Board(){
        chessBoard = new Cell[BoardConstants.ROWS][BoardConstants.COLUMNS];

    }

    public Cell[][] getChessBoard() {
        return chessBoard;
    }
    public void initializeBoard() {
    }
}
