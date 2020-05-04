package edu.upc.softarq.multigame.server.chess;

import edu.upc.softarq.multigame.server.GameController;
import edu.upc.softarq.multigame.server.GameFactory;
import edu.upc.softarq.multigame.server.chess.domain.ChessBoard;
import edu.upc.softarq.multigame.server.domain.BoardException;

public class ChessController implements GameController {
    private ChessFactory cgFactory;
    private ChessBoard board;

    public ChessController() {
        this.cgFactory = new ChessFactory();
    }

    private void buildFramework(GameFactory cgFactory) throws BoardException {
        this.board = (ChessBoard) cgFactory.createBoard();
    }

    @Override
    public void buildFramework() {
        try {
            this.buildFramework(this.cgFactory);
        } catch (BoardException e) {
            e.printStackTrace();
        }
    }
}