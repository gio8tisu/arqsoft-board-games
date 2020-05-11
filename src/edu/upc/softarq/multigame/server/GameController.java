package edu.upc.softarq.multigame.server;

import edu.upc.softarq.multigame.server.domain.PlayerException;
import edu.upc.softarq.multigame.server.domain.PlayerSpec;

public interface GameController {

    void setFactory(GameFactory factory);
    void buildFramework() throws FrameworkException;
    void addPlayer(PlayerSpec spec) throws PlayerException;
    void playGame();
    void playTurn();

}
