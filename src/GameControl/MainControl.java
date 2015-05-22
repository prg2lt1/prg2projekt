package GameControl;

import GameModel.Board;
import Opponent.NetworkPlayer;
import Opponent.ComputerBrain;
import Opponent.Opponent;
import GameModel.Player;
import GameView.GameViewFrame;
import GameControl.MoveExecutor;

/**
 * Hauptverwaltung. Initiiere Spielfeld, Spieler, Netzwerk etc.
 *
 * @author Lorenz
 */
public class MainControl {

    private String newOpponent = "-1";
    private boolean runGame = true;
    private String stateStart = "prepare";
    private Player user;
    private Opponent opponent = null;

    private Board board;
    private Flow flow;
    private GameViewFrame gameView;
    private MoveExecutor moveExecutor;
    private ChooseOpponentGUI chooseOpponent;

    public MainControl() {
        this.board = new Board(4);
        this.gameView = new GameViewFrame(this.board, this.flow);
        this.moveExecutor = new MoveExecutor(board);
        this.chooseOpponent = new ChooseOpponentGUI(this);
        gameStart();
    }

    public void setState(String newState) {
        if (newState.equals("OpponentSet")) {
            this.stateStart = "OpponetSet";
        }
        else{
            System.out.println("unknown command in setState MainControl");
        }
    }

    public void setOpponent(String newOpponent) {

        System.out.println("getOpponent got" + newOpponent);
        if (newOpponent.equals("Computer")) {
            this.opponent = new ComputerBrain(board, moveExecutor);
        } else if (newOpponent.equals("Network")) {
            this.opponent = new NetworkPlayer();
            //Hier müsste nach Netzwerkgegner gesucht werden.
        } else {
            System.out.println("unknownOpponentFound");
        }
        this.stateStart = "setOpponent()";
    }

    public void gameStart() {

        do {
            switch (stateStart) {
                case "prepare":
                    System.out.println(stateStart);
                    user = new Player("Me");

                    stateStart = "getOpponent";
                    break;

                case "getOpponent":
                    System.out.println(stateStart);
                    chooseOpponent.getOpponent();

                    stateStart = "wait";
                    break;

                case "wait":
                    System.out.println(stateStart);
                    break;

                case "opponentSet":
                    System.out.println(stateStart);

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
                    this.runGame = false;

                    if (true) { //Dialog oder ähnliches..
                        stateStart = "prepare";
                    } else {
                        stateStart = "gameFinished";
                    }
                    break;
            }
        } while (runGame);
    }

    /**
     * Startpunkt des ganzen Programms! Eingabe Argument entweder "Computer"
     * oder "Network", je nach gewünschtem Gegner
     */
    public static void main(String[] args) {
        MainControl mainControl = new MainControl();
    }
}
