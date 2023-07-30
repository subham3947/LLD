package org.example.entity.pieces;

import org.example.constants.Color;
import org.example.entity.Board;
import org.example.entity.Cell;
import org.example.entity.Piece;

public class Knight extends Piece {
    public Knight(Color color) {
        super(color);
    }

    @Override
    public boolean isMoveValid(Board board, Cell current, Cell next) {
        return false;
    }
}
