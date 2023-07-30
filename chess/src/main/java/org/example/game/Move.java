package org.example.game;

import org.example.entity.Cell;
import org.example.entity.Piece;
import org.example.entity.Player;

public class Move {

    private  Player player;
    private Cell source;
    private Cell destination;
    private Piece pieceMoved;
    private Piece pieceKilled;

    public Move(Player player, Cell source, Cell destination) {
        this.player = player;
        this.source = source;
        this.destination = destination;
        this.pieceMoved = source.getPiece();
        this.pieceKilled = destination.getPiece();
    }

    public void setPieceMoved(Piece pieceMoved) {
        this.pieceMoved = pieceMoved;
    }

    public void setPieceKilled(Piece pieceKilled) {
        this.pieceKilled = pieceKilled;
    }
}
