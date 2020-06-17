package edu.upc.softarq.multigame.server.chess.domain;

import edu.upc.softarq.multigame.server.chess.NoPathFreeException;
import edu.upc.softarq.multigame.server.chess.NoPieceMovementException;

public class Rook extends ChessPiece {
    public Rook(ChessPieceColor color) {
        super(color);
    }

    @Override
    public void isPieceMovement(int rO, int cO, int rD, int cD) throws NoPieceMovementException {

    }

    @Override
    public void isPathFree(int rO, int cO, int rD, int cD, ChessBoard board) throws NoPathFreeException {

    }

    @Override
    public String toString() {
        switch (this.color) {
            case BLACK:
                return "♜";
            case WHITE:
                return "♖";
            default:
                return "";
        }
    }

}
