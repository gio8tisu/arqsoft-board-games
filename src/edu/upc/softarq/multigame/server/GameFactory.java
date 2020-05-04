package edu.upc.softarq.multigame.server;

import edu.upc.softarq.multigame.server.chess.ChessFactory;
import edu.upc.softarq.multigame.server.domain.*;

public abstract class GameFactory {

    public static GameFactory getInstance(String game) throws UnknownFactoryException {
        if ("chess".equalsIgnoreCase(game)) {
            return new ChessFactory();
        }
        throw new UnknownFactoryException("GameFactory::createInstance(): the operation must be coded");
    }

    public abstract GameController createController();

    public abstract Board createBoard() throws BoardException;

    public abstract Piece createPiece(PieceSpec spec) throws PieceException;

    public abstract Player createPlayer(PlayerSpec spec) throws PlayerException;

    public abstract Token createToken(TokenSpec spec) throws TokenException;

    public abstract ThirdParty createThirdParty() throws ThirdPartyException;

}
