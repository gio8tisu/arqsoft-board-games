package com.arqsoft;

public abstract class Piece {
    private Player player;
    private Cell cell;

    public abstract Boolean isValidMove(Coordinate origin, Coordinate destination);
}
