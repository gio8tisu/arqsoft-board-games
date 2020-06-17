package edu.upc.softarq.multigame.server;

public class UserSessController {
    private GameFactory gameFactory;
    private GameController gameController;

    public void setFactory(GameFactory gFactory) {
        this.gameFactory = gFactory;
    }

    public GameController getController() {
        return this.gameController;
    }

    public void createGame() throws FrameworkException {
        this.gameController = gameFactory.createController();
        this.gameController.buildFramework();
    }
}
