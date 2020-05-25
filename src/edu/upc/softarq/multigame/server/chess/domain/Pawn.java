package edu.upc.softarq.multigame.server.chess.domain;

public class Pawn extends ChessPiece {
    public Pawn(final ChessPieceColor color) {
        super(color);
    }

    @Override
    public String toString() {
        switch (this.color) {
            case BLACK:
                return "♟";
            case WHITE:
                return "♙";
            default:
                return "";
        }
    }

}
