package edu.upc.softarq.multigame.server.impl;

import edu.upc.softarq.multigame.server.GameFactory;
import edu.upc.softarq.multigame.server.domain.*;
import edu.upc.softarq.utilities.TupleOf2;

import java.util.List;

public abstract class AbstractPlayer implements Player {
    @Override
    public void createAndPutPiecesOnBoard(Board board, GameFactory factory) throws PieceException, BoardException {
        List<TupleOf2<PieceSpec, Coordinate>> list = getPiecesCoordinates();
        for (TupleOf2<PieceSpec, Coordinate> piece_coord : list) {
            Piece piece = factory.createPiece(piece_coord.getFirst());
            Coordinate coordinate = piece_coord.getSecond();
            board.setPieceInCell(coordinate, piece);
        }
    }
}
