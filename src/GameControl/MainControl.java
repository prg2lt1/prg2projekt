package GameControl;

import GameModel.Board;
import Opponent.NetworkPlayer;
import Opponent.ComputerBrain;
import Opponent.Opponent;
import GameModel.Player;
import GameView.GameView;
import GameControl.MoveExecutor;

/**
 * Hauptverwaltung. Initiiere Spielfeld, Spieler, Netzwerk etc.
 *
 * @author Lorenz
 */
public class MainControl {

    private String stateStart = "prepare";
    private Player user;
    private Opponent opponent = null;

    private Flow flow;
    private Board board;
    private GameView gameView;
    private MoveExecutor moveExecutor;

    public MainControl() {
        this.board = new Board(4);
        this.gameView = new GameView(this.board);
        this.moveExecutor = new MoveExecutor(board);
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
                    if (opponent == null) {
                        String newOpponent = "-1";
                        newOpponent = ChooseOpponentGUI.getOpponent();
                        while (newOpponent.equals("-1")) {
                            try {
                                MainControl.class.wait();
                            } catch (InterruptedException e) {
                                System.out.println("waiting interrupted"
                                        + e.getMessage());
                            }
                            System.out.println(newOpponent);
                            if (newOpponent.equals("Computer")) {
                                this.opponent = new ComputerBrain(board, moveExecutor);
                            } else if (newOpponent.equals("Network")) {
                                this.opponent = new NetworkPlayer();        //Hier müsste nach Netzwerkgegner gesucht werden.
                            } else {
                                System.out.println("unknownOpponentFound");
                            }
                        }
                    }
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
     * Startpunkt des ganzen Programms! Eingabe Argument entweder "Computer"
     * oder "Network", je nach gewünschtem Gegner
     */
    public static void main(String[] args) {
        MainControl mainControl = new MainControl();
    }
}
