package edu.upc.softarq.multigame.server.run;

import edu.upc.softarq.multigame.server.GameFactory;
import edu.upc.softarq.multigame.server.UnknownFactoryException;

public class ServerDemo {
    public static void main(String[] args) {
        try {
            GameFactory gameFactory = GameFactory.getInstance(args[0]);
        } catch (UnknownFactoryException e) {
            System.out.println("Game not known");
            System.exit(1);
        }
    }
}
