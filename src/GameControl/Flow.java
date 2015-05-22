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
    public MoveExecutor moveChecker;

    public Flow(MoveExecutor newMoveChecker, Opponent newOpponent, Player newUser) {
        System.out.println("------------ new Flow");
        this.moveChecker = newMoveChecker;
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
    
        public Player getCurrentPlayer() {
        if (stateRun == "opponentTurn") {
            return true;
        } else {
            return false;
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
     * @param index 
     */
    public void playLine(int index){
        moveExecuter.playLine(int index, Player )
    }

    /**
     * run() ist der innere Zustandsautomat, welcher das aktuelle Spiel leitet.
     * sobald das Spiel aufgebaut ist, wird er aufgerufen
     */
    public void run() {
        System.out.println("new Thread! Flow");
        do {
            switch (stateRun) {
                case "userTurn":
                    System.out.println(stateRun);
                    //moveChecker.setActivePlayer(user);
                    //wait for Input
                    //validate Turn
                    //execute Turn
                    //repaint Field

                    break;

                case "opponentTurn":
                    System.out.println(stateRun);
                    //moveChecker.setActivePlayer(opponent);
                    //validate Turn
                    //execute Turn
                    //repaint Field
                    break;

                case "gameOver": //nur break;
                    System.out.println(stateRun);
                    break;

                default:
                    System.out.println("unknown Command in Flow");
                    break;
            }
        } while (stateRun != "gameOver");
        System.out.println("Thread's dying now. Flow");
    }
}
