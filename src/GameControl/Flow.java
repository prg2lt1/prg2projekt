package GameControl;

/**
 * Flow enthält die Zustandsautomaten, welche den Spielverlauf abbilden sollen.
 * minimum der innere Automat sollte in einem eigenen Thread laufen.
 *
 * @author Lorenz
 */
public class Flow implements Runnable {

    private String stateRun = "opponentTurn";
    private boolean runGame = true;
    Thread flow = new Thread(this);

    public Flow() {
        flow.start();
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
