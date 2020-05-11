package edu.upc.softarq.multigame.server.domain;

import edu.upc.softarq.multigame.server.GameFactory;
import edu.upc.softarq.utilities.TupleOf2;

import java.util.List;

public interface Player {
    public void playTurn();
    public void createAndPutPiecesOnBoard(Board board, GameFactory factory) throws PieceException, BoardException;
    public List<TupleOf2<PieceSpec, Coordinate>> getPiecesCoordinates();
}
