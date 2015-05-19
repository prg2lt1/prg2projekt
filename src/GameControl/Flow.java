package GameControl;

import Opponent.Opponent;
import GameModel.Player;

/**
 * Flow enthält die Zustandsautomaten, welche den Spielverlauf abbilden sollen.
 * minimum der innere Automat sollte in einem eigenen Thread laufen.
 *
 * @author Lorenz
 */
public class Flow implements Runnable {

    private String stateRun = "userTurn"; //"opponentTurn";
    private boolean runGame = true;
    private Opponent opponent;
    private Player user;
    public MoveExecutor moveChecker;
    Thread flow = new Thread(this);

    public Flow(MoveExecutor newMoveChecker, Opponent newOpponent, Player newUser) {
        System.out.println("------------ new Flow");
        this.moveChecker = newMoveChecker;
        this.opponent = newOpponent;
        this.user = newUser;
        flow.start();
    }
        public Flow() {
        System.out.println("------------ new Flow without params");
        flow.start();
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
     * run() ist der innere Zustandsautomat, welcher das aktuelle Spiel leitet.
     * sobald das Spiel aufgebaut ist, wird er aufgerufen
     */
    @Override
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

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Interrupt while sleeping in Run() " + e.getMessage());
            }

        } while (runGame != false);
        System.out.println("Thread's dying now. Flow");
    }
}
