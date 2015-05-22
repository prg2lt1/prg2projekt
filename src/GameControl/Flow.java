package GameControl;

import Opponent.NetworkPlayer;
import GameModel.Player;
import Opponent.Opponent;

/**
 * Flow enthält die Zustandsautomaten, welche den Spielverlauf abbilden sollen.
 * minimum der innere Automat sollte in einem eigenen Thread laufen.
 *
 * @author Lorenz
 */
public class Flow {

    private enum stateRunn {

        userTurn,
        opponentTurn,
        gameOver,
    }

    private String stateRun = "userTurn"; //"opponentTurn";
    private boolean runGame = true;
    private Opponent opponent;
    private Player user;
    public MoveExecutor moveExecuter;

    public Flow(MoveExecutor newMoveExecuter, Opponent newOpponent, Player newUser) {
        System.out.println("------------ new Flow");
        this.moveExecuter = newMoveExecuter;
        this.opponent = newOpponent;
        this.user = newUser;

    }

    public Flow() {
        System.out.println("------------ new Flow without params");
    }

    /**
     * gib true zürück, solange die Partie läuft.
     */
    public boolean gameIsRunning() {
        return runGame;
    }

    /**
     * gibt den nächsten Spielzug dem Spieler frei.
     */
    public void setUserTurn() {
        System.out.println("set UserTurn");
        stateRun = "userTurn";
    }

    /**
     * gibt den nächsten Spielzug dem Gegner frei.
     */
    public void setOpponentTurn() {
        System.out.println("set OpponentTurn");
        stateRun = "opponentTurn";
    }

    /**
     * gib true zürück, wenn der Spieler dran ist.
     */
    public boolean isUserTurn() {
        if (stateRun == "userTurn") {
            return true;
        } else {
            return false;
        }
    }

    /**
     * gibt true zurück, wenn der Gegner dran ist.
     */
    public boolean isOpponentTurn() {
        if (stateRun == "opponentTurn") {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gibt den Player am Zug zurück
     *
     * @return Player
     */
    public Player getCurrentPlayer() {
        if (stateRun == "opponentTurn") {
            return opponent;
        } else {
            return user;
        }
    }

    /**
     * Setzt den neuen SpielStatus.
     *
     * @param newState
     */
    public void setState(String newState) {
        if (newState.equals("userTurn")) {
            stateRun = "userTurn";
        } else if (newState.equals("opponentTurn")) {
            stateRun = "opponentTurn";
        } else if (newState.equals("gameOver")) {
            stateRun = "gameOver";
        } else {
            System.out.println("Unknown command in setState");
        }
    }

    /**
     * gibt den Zustand zurück.
     */
    public String getStateRun() {
        return stateRun;
    }

    /**
     * setzt gameOver und beendet den thread.
     */
    public void setGameOver() {
        stateRun = "gameOver";
        runGame = false;
    }

    /**
     * lokaler Spieler übergibt Linienindex für an MoveExecuter
     *
     * @param index
     */
    public void playLine(int index) {
        this.setState(this.moveExecuter.playLine(index, this.getCurrentPlayer()));
    }

    /**
     * run() ist der innere Zustandsautomat, welcher das aktuelle Spiel leitet.
     * sobald das Spiel aufgebaut ist, wird er aufgerufen
     */
    public void run() {
        System.out.println("Flow");
        do {
            switch (stateRun) {
                case "userTurn":
                    System.out.println(stateRun);
                    break;

                case "opponentTurn":
                    System.out.println(stateRun);
                    break;

                case "gameOver": //nur break;
                    System.out.println(stateRun);
                    this.runGame = false;
                    break;

                default:
                    System.out.println("unknown Command in Flow");
                    break;
            }
        } while (!runGame);
        System.out.println("end of Flow");
    }
}
