package GameControl;

import GameModel.Board;
import Opponent.Opponent;
import Opponent.ComputerBrain;
import GameModel.Player;
import GameView.GameView;
import GameControl.MoveExecutor;
import Opponent.Network;

/**
 * Hauptverwaltung. Initiiere Spielfeld, Spieler, Netzwerk etc.
 *
 * @author Lorenz
 */
public class MainControl {

    private String stateStart = "prepare";
    private Player user;
    private Opponent opponent;

    private Flow flow;
    private Board board;
    private GameView gameView;
    private MoveExecutor moveExecutor;

    public MainControl(String newOpponent) {
        this.board = new Board(4);
        this.gameView = new GameView(this.board);
        this.moveExecutor = new MoveExecutor(board);
        if (newOpponent.equals("Computer")) {
            this.opponent = new ComputerBrain(board, moveExecutor);
            }
        else if (newOpponent.equals("Network")) {
            this.opponent = new Network();
        }
        else {
           //Cancel...
        }

        gameStart();
    }

    public void gameStart() {

        do {
            switch (stateStart) {
                case "prepare":
                    System.out.println(stateStart);
                    user = new Player("Me");

                    //init network
                    stateStart = "getOpponent";
                    break;

                case "getOpponent":
                    System.out.println(stateStart);
                    opponent = new Opponent("Yami Yugi");
                    //Choose Opponent
                    //or get Invited
                    stateStart = "run";
                    break;

                case "run":
                    System.out.println(stateStart);
                    this.flow = new Flow(moveExecutor, opponent, user);
                    while (flow.gameIsRunning()) {
                        //wait
                    }
                    stateStart = "endGame";
                    break;

                case "endGame":
                    //aufräumen?

                    if (true) { //Dialog oder ähnliches..
                        stateStart = "prepare";
                    } else {
                        stateStart = "gameFinished";
                    }
                    break;
            }
        } while (stateStart != "gameFinished");
    }

    /**
     * Startpunkt des ganzen Programms! Eingabe Argument entweder "Computer" oder "Network", je nach gewünschtem Gegner
     */
    public static void main(String[] args) {
        MainControl mainControl = new MainControl(args[0]);
    }
}
