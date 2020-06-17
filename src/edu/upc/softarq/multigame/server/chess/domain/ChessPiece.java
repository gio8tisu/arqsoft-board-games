package edu.upc.softarq.multigame.server.chess.domain;

import edu.upc.softarq.multigame.server.chess.NoPathFreeException;
import edu.upc.softarq.multigame.server.chess.NoPieceMovementException;
import edu.upc.softarq.multigame.server.domain.Board;
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

    public abstract void isPieceMovement(int rO, int cO, int rD, int cD)
            throws NoPieceMovementException;

    public abstract void isPathFree(int rO, int cO, int rD, int cD, ChessBoard board)
            throws NoPathFreeException;

    public void canReachDestination(int rO, int cO, int rD, int cD, ChessBoard board)
            throws NoPieceMovementException, NoPathFreeException {
        this.isPieceMovement(rO, cO, rD, cD);
        this.isPathFree(rO, cD, rD, cD, board);
    }

    public void movePiece(int rO, int cO, int rD, int cD, Board board)
            throws NoPieceMovementException, NoPathFreeException {

    }
}
