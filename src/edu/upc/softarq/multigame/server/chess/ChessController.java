package edu.upc.softarq.multigame.server.chess;

import edu.upc.softarq.multigame.server.GameFactory;
import edu.upc.softarq.multigame.server.chess.domain.*;
import edu.upc.softarq.multigame.server.domain.*;
import edu.upc.softarq.multigame.server.impl.AbstractGameController;

public class ChessController extends AbstractGameController {

    public ChessController() {
        this.factory = new ChessFactory();
        this.setInitialState();
    }

    private void buildFramework(GameFactory cgFactory) throws BoardException {
        this.board = (ChessBoard) cgFactory.createBoard();
    }

    @Override
    public void buildFramework() {
        try {
            this.buildFramework(this.factory);
        } catch (BoardException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addPlayer(PlayerSpec spec) throws PlayerException {
        ChessPlayerSpec chessSpec = (ChessPlayerSpec) spec;
        if (this.players.size() == 2) {
            throw new PlayerException("No more than 2 players can be added.");
        }
        if (this.players.isEmpty() & chessSpec.getColor() != ChessPieceColor.WHITE) {
            throw new PlayerException("First player should be of white color.");
        }
        if (this.players.size() == 1 & chessSpec.getColor() != ChessPieceColor.BLACK) {
            throw new PlayerException("Second player should be of black color.");
        }
        super.addPlayer(chessSpec);
    }

    @Override
    public void playTurn() {
        throw new UnsupportedOperationException("ChessController::playTurn()");
    }

    @Override
    protected void actionsAsPerPlayerTurn() {
        throw new UnsupportedOperationException("ChessController::actionsAsPerPlayerTurn()");
    }

    @Override
    protected void createAndGivePiecesToPlayer(Player player, Board board) throws PlayerException {
        ChessPlayer chessPlayer = (ChessPlayer) player;
        ChessBoard chessBoard = (ChessBoard) board;
        try {
            chessPlayer.createAndPutPiecesOnBoard(chessBoard, this.factory);
        } catch (PieceException e) {
            throw new PlayerException("Cannot create piece.");
        } catch (BoardException e) {
            throw new PlayerException("Cannot put piece in board.");
        }
    }

    @Override
    protected void giveTokensToPlayer(Player player, ThirdParty thirdParty) {
    }

    @Override
    protected void setInitialState() {
        this.state = ChessState.INITIAL;
    }
}