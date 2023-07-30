package org.example.entity;

import org.example.constants.Color;

public abstract class Piece {


    private final Color color;
    private boolean isAlive = false;

    protected Piece(Color color) {
        this.color = color;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Color getColor() {
        return color;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public abstract boolean isMoveValid(Board board, Cell current, Cell next);
}
