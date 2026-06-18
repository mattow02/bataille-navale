import Controller.Game.GameController;
import Model.Boat.SimpleBoatFactory;
import Model.Games.Game;
import Model.Games.RandomGridInitializer;
import Model.Player.RegisteredShotStrategyFactory;
import Model.Player.StandardPlayerFactory;
import Model.Trap.DefaultTrapFactory;
import View.Screen.SwingUiExecutor;
import View.Screen.SwingViewFactory;

import javax.swing.SwingUtilities;

/**
 * Application entry point for the Battleship game.
 * Initializes all factories and launches the game controller on the Swing EDT.
 */
public class App {

    /**
     * Creates the game infrastructure (factories, game model, controller)
     * and starts the application on the Swing Event Dispatch Thread.
     */
    public static void main(String[] args) {
        var playerFactory = new StandardPlayerFactory();
        var gridInitializer = RandomGridInitializer.withDefaults();
        var boatFactory = new SimpleBoatFactory();
        var shotStrategyFactory = new RegisteredShotStrategyFactory();
        var trapFactory = new DefaultTrapFactory();
        var game = new Game(playerFactory, gridInitializer, boatFactory, shotStrategyFactory, trapFactory);
        var gameController = new GameController(
                game,
                new SwingViewFactory(),
                new SwingUiExecutor()
        );
        SwingUtilities.invokeLater(gameController::startApplication);
    }
}
