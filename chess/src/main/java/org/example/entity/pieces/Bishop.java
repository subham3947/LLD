package org.example.entity.pieces;

import org.example.constants.Color;
import org.example.entity.Board;
import org.example.entity.Cell;
import org.example.entity.Piece;

public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color);
    }

    @Override
    public boolean isMoveValid(Board board, Cell current, Cell next) {
        return false;
    }
}
