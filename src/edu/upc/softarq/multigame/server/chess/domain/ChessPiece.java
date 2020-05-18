package edu.upc.softarq.multigame.server.chess.domain;

import edu.upc.softarq.multigame.server.domain.Piece;

public abstract class ChessPiece implements Piece {
    public enum Type {
        PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING
    }

    protected ChessPieceColor color;

    public ChessPiece(ChessPieceColor color) {
        this.color = color;
    }

    public ChessPieceColor getColor() {
        return this.color;
    }

    public void setColor(ChessPieceColor color) {
        this.color = color;
    }
}
