package GameControl;

import GameModel.Player;
import Opponent.Opponent;
import Opponent.ComputerBrain;
import java.io.Serializable;

/**
 * Flow enthält die Zustandsautomaten, welche den Spielverlauf abbilden sollen.
 * minimum der innere Automat sollte in einem eigenen Thread laufen.
 *
 * @author Lorenz
 */
public class Flow  implements Serializable {

    public enum FlowStates {

        userTurn,
        opponentTurn,
        gameOver,
        error,
        wait

    }

    public MoveExecutor moveExecuter;
    private Opponent opponent;
    private Player user;
    private Network network;
    private FlowStates stateRun = FlowStates.userTurn;
    private boolean runGame = true;

    public Flow(MoveExecutor newMoveExecuter, Opponent newOpponent, Player newUser) {
        System.out.println("[debug (Flow)] new Flow");
        this.moveExecuter = newMoveExecuter;
        this.opponent = newOpponent;
        this.user = newUser;
    }

    public boolean gameIsRunning() {
        return runGame;
    }

    public Player getCurrentPlayer() {
        if (stateRun == FlowStates.userTurn) {
            return user;
        } else {
            return opponent;
        }
    }

    /**
     * MoveExecuter setzt den nächsten Spieler. überprüft die Boxen.
     *
     * @param newState
     */
    public void setState(FlowStates newState) {
        stateRun = newState;
    }

    public FlowStates getState() {
        return stateRun;
    }

    public void setGameOver() {
        stateRun = FlowStates.gameOver;
        runGame = false;
    }

    /**
     * lokaler Spieler übergibt Linienindex für an MoveExecuter
     *
     * @param index
     */
    public void playLine(int index) {
        //System.out.println("[info (Flow)] Lineindex in PlayLine in Flow: " + index);
        this.setState(this.moveExecuter.playLine(index, this.getCurrentPlayer()));
    }

    /**
     * run() ist der innere Zustandsautomat, welcher das aktuelle Spiel leitet.
     * sobald das Spiel aufgebaut ist, wird er aufgerufen
     */
    public void gameRun() {
        do {
            switch (stateRun) {
                case userTurn:
                    //System.out.println(stateRun);
                    break;

                case opponentTurn:
                    //System.out.println(stateRun);
                    //this.setState(Flow.FlowStates.wait);
                    if (opponent instanceof ComputerBrain) {
                        this.playLine(((ComputerBrain) opponent).play());
                    } else {
                        //network does it's thing..
                    }
                    break;

                case wait:
                    System.out.println("[info (Flow)] waiting");
                    break;

                case gameOver:
                    System.out.println("[info (Flow)]" + stateRun);
                    this.runGame = false;
                    break;

                case error:
                    System.out.println("[info (Flow)] " + stateRun);
                    break;

                default:
                    System.out.println("[info (Flow)] unknown Command in Flow: " + stateRun.toString());
                    break;
            }
        } while (runGame);
        System.out.println("[info (Flow)] end of Flow");
    }
}
