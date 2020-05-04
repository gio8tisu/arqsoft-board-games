package edu.upc.softarq.multigame.server.chess.domain;

import edu.upc.softarq.multigame.server.domain.Coordinate;

public class ChessCoordinate implements Coordinate {
    private int row, column;

    public ChessCoordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }
}
