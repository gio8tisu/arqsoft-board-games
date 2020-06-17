package edu.upc.softarq.multigame.server.chess.domain;

import edu.upc.softarq.multigame.server.domain.PlayerSpec;

public class ChessPlayerSpec implements PlayerSpec {
    ChessPieceColor color;

    public ChessPlayerSpec(ChessPieceColor color) {
        this.color = color;
    }

    public static ChessPlayerSpec getInstance(ChessPieceColor color) {
        return new ChessPlayerSpec(color);
    }

    public ChessPieceColor getColor() {
        return this.color;
    }
}

