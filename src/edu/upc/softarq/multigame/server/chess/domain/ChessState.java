package edu.upc.softarq.multigame.server.chess.domain;

import edu.upc.softarq.multigame.server.domain.GameState;

public enum ChessState implements GameState {
    INITIAL,
    PLAYING,
    CHECK,
    CHECKMATE,
    FINALIZED;

    @Override
    public boolean isFinalization() {
        return ChessState.FINALIZED == this;
    }
}
