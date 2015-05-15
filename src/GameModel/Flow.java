package GameModel;

import GameView.GamePanel;

/**
 * Flow enthält die Zustandsautomaten, welche den Spielverlauf abbilden sollen.
 * minimum der innere Automat sollte in einem eigenen Thread laufen.
 *
 * @author Lorenz
 */
public class Flow implements Runnable {

    private GamePanel panel;
    private Board board;

    private String stateStart = "prepare";
    private String stateRun = "playerTurn"; //Falls es nicht initialisiert wird..
    private boolean runGame = true;
    Thread flow = new Thread(this);

    public Flow() {
        Start();
    }

    /**
     * Äusserer Zustandautomat der während des ganzen Spiels ausgeführt wird.
     * Wenn er auf "run" steht, wird der zweite Zustandsautomat aktiviert.
     */
    private void Start() {
        do {
            switch (stateStart) {
                case "prepare":
                    System.out.println(stateStart);
                    panel = new GamePanel();
                    board = new Board(4);
                    //init network
                    stateStart = "getOpponent";
                    break;

                case "getOpponent":
                    System.out.println(stateStart);
                    //Choose Opponent
                    //or get Invited
                    stateRun = "playerTurn";
                    stateStart = "run";
                    break;

                case "run":
                    System.out.println(stateStart);
                    flow.start();
                    break;

                case "gameFinished":
                    System.out.println(stateStart);
                    System.out.println("play again?");
                    /**
                     * if(yes){ stateStart = "run"; } else { runGame = false; }
                     */
                    break;
            }
        } while (runGame == true);
    }

    /**
     * gibt den nächsten Spielzug dem Spieler frei.
     */
    public void setUserTurn() {
        stateRun = "userTurn";
    }

    /**
     * gibt den nächsten Spielzug dem Gegner frei.
     */
    public void setOpponentTurn() {
        stateRun = "OpponentTurn";
    }

    /**
     * gibt den nächsten Spielzug dem Spieler frei.
     */
    public boolean isUserTurn() {
        if (stateRun == "userTurn") {
            return true;
        } else {
            return false;
        }
    }

    /**
     * gibt den nächsten Spielzug dem Gegner frei.
     */
    public boolean isOpponentTurn() {
        if (stateRun == "opponentTurn") {
            return true;
        } else {
            return false;
        }
    }

    /**
     * run() ist der innere Zustandsautomat, welcher das aktuelle Spiel leitet.
     * sobald das Spiel aufgebaut ist, wird er aufgerufen
     */
    @Override
    public void run() {
        do {
            switch (stateRun) {
                case "userTurn":
                    System.out.println(stateRun);
                    //wait for Input
                    //validate Turn
                    //execute Turn
                    //repaint Field

                    break;

                case "opponentTurn":
                    System.out.println(stateRun);
                    //wait for Input
                    //validate Turn
                    //execute Turn
                    //repaint Field
                    break;

                case "gameOver": //nur break;
                    System.out.println(stateRun);
                    break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Interrupt while sleeping in Run() " + e.getMessage());
            }

        } while (stateRun.equals("gameOver"));

    }
}
