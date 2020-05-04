package edu.upc.softarq.multigame.server.chess;

import edu.upc.softarq.multigame.server.GameController;
import edu.upc.softarq.multigame.server.GameFactory;
import edu.upc.softarq.multigame.server.chess.domain.ChessBoard;
import edu.upc.softarq.multigame.server.domain.*;

public class ChessFactory extends GameFactory {
    @Override
    public GameController createController() {
        return new ChessController();
    }

    @Override
    public Board createBoard() throws BoardException {
        return new ChessBoard();
    }

    @Override
    public Piece createPiece(PieceSpec spec) throws PieceException {
        return null;
    }

    @Override
    public Player createPlayer(PlayerSpec spec) throws PlayerException {
        return null;
    }

    @Override
    public Token createToken(TokenSpec spec) throws TokenException {
        throw new TokenException("Chess does not require token");
    }

    @Override
    public ThirdParty createThirdParty() throws ThirdPartyException {
        throw new ThirdPartyException("Chess does not require third party");
    }
}
