package edu.upc.softarq.multigame.server.chess.domain;

import edu.upc.softarq.multigame.server.domain.Board;
import edu.upc.softarq.multigame.server.domain.Cell;

public class ChessBoard implements Board {
    private final Cell[][] cells;

    public ChessBoard() {
        cells = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j] = new ChessCell();
            }
        }
    }

    public Cell getCell(final ChessCoordinate coordinate) {
        return cells[coordinate.getX()][coordinate.getY()];
    }
}
