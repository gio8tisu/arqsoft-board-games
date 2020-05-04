package edu.upc.softarq.multigame.server.domain;

public interface Board {
    Cell getCell(Coordinate coordinate);

    void setPieceInCell(Coordinate coordinate, Piece piece) throws BoardException;
}
