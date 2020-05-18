package edu.upc.softarq.multigame.server.chess.domain;

import edu.upc.softarq.multigame.server.domain.*;

public class ChessBoard implements Board {
    private ChessCell[][] cells;

    public ChessBoard() {
        cells = new ChessCell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j] = new ChessCell();
            }
        }
    }

    @Override
    public Cell getCell(Coordinate coordinate) {
        return cells[((ChessCoordinate) coordinate).getRow() - 1][((ChessCoordinate) coordinate).getColumn() - 1];
    }

    @Override
    public void setPieceInCell(Coordinate coordinate, Piece piece) throws BoardException {
        cells[((ChessCoordinate) coordinate).getRow() - 1][((ChessCoordinate) coordinate).getColumn() - 1].setPiece(piece);
    }
}
