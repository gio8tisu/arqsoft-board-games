package edu.upc.softarq.multigame.server.impl;

import edu.upc.softarq.multigame.server.GameFactory;
import edu.upc.softarq.multigame.server.domain.*;
import edu.upc.softarq.utilities.TupleOf2;

public abstract class AbstractPlayer implements Player {
    @Override
    public void createAndPutPiecesOnBoard(Board board, GameFactory factory) throws PieceException, BoardException {
        for (TupleOf2<PieceSpec, Coordinate> pieceAnsCoord : this.getPiecesCoordinates()) {
            Piece piece = factory.createPiece(pieceAnsCoord.getFirst());
            Coordinate coordinate = pieceAnsCoord.getSecond();
            board.setPieceInCell(coordinate, piece);
        }
    }
}
