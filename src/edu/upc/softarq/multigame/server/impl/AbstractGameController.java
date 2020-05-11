package edu.upc.softarq.multigame.server.impl;

import edu.upc.softarq.multigame.server.FrameworkException;
import edu.upc.softarq.multigame.server.GameController;
import edu.upc.softarq.multigame.server.GameFactory;
import edu.upc.softarq.multigame.server.domain.*;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGameController implements GameController {

    protected GameFactory factory;
    protected Board board;
    protected List<Player> players;
    protected ThirdParty thirdParty;
    protected GameState state;
    protected int turn;

    public AbstractGameController() {
        this.state = GameState.NOT_FINALIZED;
        this.turn = 0;
        this.players = new ArrayList<Player>();
    }

    @Override
    public void setFactory(GameFactory factory) {
        this.factory = factory;
    }

    @Override
    public void buildFramework() throws FrameworkException {
        try {
            this.board = this.factory.createBoard();
        } catch (BoardException e) {
            e.printStackTrace();
        }
        try {
            this.thirdParty = this.factory.createThirdParty();
        } catch (ThirdPartyException e) {
            System.out.println("This game does not use a third party.");
        }
    }

    @Override
    public void addPlayer(PlayerSpec spec) throws PlayerException {
        Player newPlayer = this.factory.createPlayer(spec);
        this.players.add(newPlayer);
    }

    @Override
    public void playGame() {
        while (this.state != GameState.FINALIZED) {
            Player player = nextPlayer();
            this.giveTurn(player);
            player.playTurn();
            this.actionsPerNewState();
        }
    }

    protected abstract void actionsPerNewState();

    protected abstract void giveTurn(Player player);

    protected Player nextPlayer() {
        turn += 1;
        return players.get(turn);
    }
}
