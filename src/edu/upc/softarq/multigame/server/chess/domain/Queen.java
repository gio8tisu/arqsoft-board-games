package edu.upc.softarq.multigame.server.chess.domain;

public class Queen extends ChessPiece {

    public Queen(ChessPieceColor color) {
        super(color);
    }

    @Override
    public String toString() {
        switch (this.color) {
            case BLACK:
                return "♛";
            case WHITE:
                return "♕";
            default:
                return "";
        }
    }

}
