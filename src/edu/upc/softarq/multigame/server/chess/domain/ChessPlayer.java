package edu.upc.softarq.multigame.server.chess.domain;

import edu.upc.softarq.multigame.server.domain.Coordinate;
import edu.upc.softarq.multigame.server.domain.PieceSpec;
import edu.upc.softarq.multigame.server.impl.AbstractPlayer;
import edu.upc.softarq.utilities.TupleOf2;

import java.util.ArrayList;
import java.util.List;

public class ChessPlayer extends AbstractPlayer {
    ChessPieceColor color;

    public ChessPlayer() {
    }

    public ChessPlayer(ChessPieceColor color) {
        this.color = color;
    }

    @Override
    public void playTurn() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TupleOf2<PieceSpec, Coordinate>> getPiecesCoordinates() {
        List<TupleOf2<PieceSpec, Coordinate>> piecesAndCoords = new ArrayList<>();

        int pawnsRow, otherRow;
        if (ChessPieceColor.BLACK == this.color) {
            pawnsRow = 7;
            otherRow = 8;
        } else {
            pawnsRow = 2;
            otherRow = 1;
        }

        // Create rooks.
        ChessPieceSpec rookSpec = new ChessPieceSpec(this.color, ChessPiece.Type.ROOK);
        piecesAndCoords.add(new TupleOf2<>(rookSpec, new ChessCoordinate(otherRow, 1)));
        piecesAndCoords.add(new TupleOf2<>(rookSpec, new ChessCoordinate(otherRow, 8)));
        // Create knight.
        ChessPieceSpec knightSpec = new ChessPieceSpec(this.color, ChessPiece.Type.KNIGHT);
        piecesAndCoords.add(new TupleOf2<>(knightSpec, new ChessCoordinate(otherRow, 2)));
        piecesAndCoords.add(new TupleOf2<>(knightSpec, new ChessCoordinate(otherRow, 7)));
        // Create bishop.
        ChessPieceSpec bishopSpec = new ChessPieceSpec(this.color, ChessPiece.Type.BISHOP);
        piecesAndCoords.add(new TupleOf2<>(bishopSpec, new ChessCoordinate(otherRow, 3)));
        piecesAndCoords.add(new TupleOf2<>(bishopSpec, new ChessCoordinate(otherRow, 6)));
        // Create king.
        piecesAndCoords.add(new TupleOf2<>(new ChessPieceSpec(this.color, ChessPiece.Type.KING),
                new ChessCoordinate(otherRow, 5)));
        // Create queen.
        piecesAndCoords.add(new TupleOf2<>(new ChessPieceSpec(this.color, ChessPiece.Type.QUEEN),
                new ChessCoordinate(otherRow, 4)));
        // Create pawns.
        ChessPieceSpec pawnSpec = new ChessPieceSpec(this.color, ChessPiece.Type.PAWN);
        for (int i = 1; i <= 8; i++) {
            piecesAndCoords.add(new TupleOf2<>(pawnSpec, new ChessCoordinate(pawnsRow, i)));
        }

        return piecesAndCoords;
    }
}
