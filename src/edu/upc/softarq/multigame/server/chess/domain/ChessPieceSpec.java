package edu.upc.softarq.multigame.server.chess.domain;

import edu.upc.softarq.multigame.server.domain.PieceSpec;

public class ChessPieceSpec implements PieceSpec {
    private ChessPieceColor color;
    private ChessPiece.Type type;

    public ChessPieceSpec(ChessPieceColor color, ChessPiece.Type type) {
        this.color = color;
        this.type = type;
    }

    public ChessPieceColor getColor() {
        return this.color;
    }

    public ChessPiece.Type getType() {
        return this.type;
    }
}
