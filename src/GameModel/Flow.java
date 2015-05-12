package GameModel;

import GameView.GamePanel;

/**
 *
 * @author Lorenz
 */
public class Flow implements Runnable {

    private GamePanel panel;
    
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
                    panel = new GamePanel();
                    //init network
                    stateStart = "getOpponent";
                    break;

                case "getOpponent":
                    //Choose Opponent
                    //or get Invited
                    stateRun = "playerTurn";
                    stateStart = "run";
                    break;

                case "run":
                    flow.start();
                    break;

                case "gameFinished":
                    //play again?
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
    public void setPlayerTurn() {
        stateRun = "playerTurn";
    }

    /**
     * gibt den nächsten Spielzug dem Gegner frei.
     */
    public void setOpponentTurn() {
        stateRun = "OpponentTurn";
    }

    /**
     * run() ist der innere Zustandsautomat, welcher das aktuelle Spiel leitet.
     * sobald das Spiel aufgebaut ist, wird er aufgerufen
     */
    @Override
    public void run() {
        do {
            switch (stateRun) {
                case "playerTurn":
                    //wait for Input
                    //validate Turn
                    //execute Turn
                    //repaint Field

                    break;

                case "opponentTurn":
                    //wait for Input
                    //validate Turn
                    //execute Turn
                    //repaint Field
                    break;

                case "gameOver": //nur break;
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
