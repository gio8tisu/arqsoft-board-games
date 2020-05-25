package edu.upc.softarq.multigame.server.run;

import edu.upc.softarq.multigame.server.FrameworkException;
import edu.upc.softarq.multigame.server.GameController;
import edu.upc.softarq.multigame.server.GameFactory;
import edu.upc.softarq.multigame.server.UnknownFactoryException;
import edu.upc.softarq.multigame.server.chess.domain.ChessPieceColor;
import edu.upc.softarq.multigame.server.chess.domain.ChessPlayerSpec;
import edu.upc.softarq.multigame.server.domain.PlayerException;

public class ServerDemo {
    public static void main(String[] args) {
        try {
            GameFactory gameFactory = GameFactory.getInstance(args[0]);
            GameController gameController = gameFactory.createController();
            gameController.buildFramework();
            ChessPlayerSpec whitePlayer = new ChessPlayerSpec(ChessPieceColor.WHITE);
            gameController.addPlayer(whitePlayer);
            ChessPlayerSpec blackPlayer = new ChessPlayerSpec(ChessPieceColor.BLACK);
            gameController.addPlayer(blackPlayer);
        } catch (UnknownFactoryException e) {
            System.out.println("Game not known");
            System.exit(1);
        } catch (FrameworkException e) {
            System.out.println("Cannot create framework:");
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (PlayerException e) {
            System.out.println("Cannot add player:");
            System.out.println(e.getMessage());
        }
    }
}
