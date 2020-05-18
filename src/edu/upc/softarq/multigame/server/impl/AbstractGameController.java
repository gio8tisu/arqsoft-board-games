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
            throw new FrameworkException("Cannot create board");
        }
        try {
            this.thirdParty = this.factory.createThirdParty();
        } catch (ThirdPartyException e) {
            throw new FrameworkException("This game does not use a third party.");
        }
    }

    @Override
    public void addPlayer(PlayerSpec spec) throws PlayerException {
        Player newPlayer = this.factory.createPlayer(spec);
        this.createAndGivePiecesToPlayer(newPlayer, this.board);
        this.giveTokensToPlayer(newPlayer, this.thirdParty);
        this.players.add(newPlayer);
    }

    @Override
    public void playGame() {
        this.setInitialState();
        Player player;
        while (!this.state.isFinalization()) {
            player = this.nextPlayer();
            this.playTurn();
            this.actionsAsPerPlayerTurn();
        }
    }

    protected Player nextPlayer() {
        this.turn += 1;
        return this.players.get(this.turn);
    }

    protected abstract void actionsAsPerPlayerTurn();

    protected abstract void createAndGivePiecesToPlayer(Player player, Board board) throws PlayerException;

    protected abstract void giveTokensToPlayer(Player player, ThirdParty thirdParty);

    protected abstract void setInitialState();
}
