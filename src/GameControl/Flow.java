package GameControl;

import GameModel.Player;
import Opponent.Opponent;
import Opponent.ComputerBrain;
import GameView.GameViewFrame;

/**
 * Flow enthält den inneren Zustandsautomaten, welche den Spielverlauf einer
 * einzelnen Runde abbilden soll.
 * @author Lorenz
 */
public class Flow {

    /**
     * Die vier möglichen Zustände des inneren Automaten. error ist nicht aktiv
     * benutzt.
     */
    public enum FlowStates {

        userTurn,
        opponentTurn,
        gameOver,
        error,

    }

    public MoveExecutor moveExecuter;
    private final GameViewFrame myGameViewFrame;
    private final Opponent opponent;
    private final Player user;
    private FlowStates stateRun;
    private boolean runGame = true;

    public Flow(MoveExecutor newMoveExecuter, Opponent newOpponent, Player newUser, GameViewFrame myGameViewFrame) {
        //System.out.println("[debug (Flow)] new Flow");
        this.moveExecuter = newMoveExecuter;
        this.opponent = newOpponent;
        this.user = newUser;
        this.myGameViewFrame = myGameViewFrame;
        stateRun = FlowStates.userTurn;
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
                    if (opponent instanceof ComputerBrain) {
                        this.playLine(((ComputerBrain) opponent).play());
                        myGameViewFrame.repaintPanel();
                    } else {
                        //network does it's thing..
                    }
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
