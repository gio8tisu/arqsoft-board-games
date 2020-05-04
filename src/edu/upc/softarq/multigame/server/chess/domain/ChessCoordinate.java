package edu.upc.softarq.multigame.server.chess.domain;

import edu.upc.softarq.multigame.server.domain.Coordinate;

public class ChessCoordinate implements Coordinate {
    private final int x, y;

    public ChessCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
