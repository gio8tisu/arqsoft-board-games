package edu.upc.softarq.multigame.server.chess;

import edu.upc.softarq.multigame.server.GameController;
import edu.upc.softarq.multigame.server.GameFactory;
import edu.upc.softarq.multigame.server.chess.domain.*;
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
        ChessPieceSpec chessSpec = (ChessPieceSpec) spec;
        ChessPieceColor color = ((ChessPieceSpec) spec).getColor();
        switch (chessSpec.getType()) {
            case PAWN:
                return new Pawn(color);
            case ROOK:
                return new Rook(color);
            case KNIGHT:
                return new Knight(color);
            case BISHOP:
                return new Bishop(color);
            case KING:
                return new King(color);
            case QUEEN:
                return new Queen(color);
            default:
                throw new PieceException("Unknown ChessPiece type: " + chessSpec.getType());
        }
    }

    @Override
    public Player createPlayer(PlayerSpec spec) throws PlayerException {
        ChessPieceColor color = ((ChessPieceSpec) spec).getColor();
        switch (color) {
            case BLACK:
            case WHITE:
                return new ChessPlayer(color);
            default:
                throw new PlayerException("Unknown color: " + color);
        }
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
