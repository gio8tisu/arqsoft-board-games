package edu.upc.softarq.multigame.server.chess.domain;

import edu.upc.softarq.multigame.server.domain.Cell;
import edu.upc.softarq.multigame.server.domain.Piece;

public class ChessCell implements Cell {
    private Piece piece;

    @Override
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    @Override
    public Piece getPiece() {
        return piece;
    }

}
