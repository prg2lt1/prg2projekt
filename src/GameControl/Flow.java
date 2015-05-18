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
        System.out.println("------------ new Flow");
        flow.start();
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

                default:
                    System.out.println("unknown Command in Flow");
                    break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Interrupt while sleeping in Run() " + e.getMessage());
            }

        } while (this.getStateRun() != "gameOver");
        System.out.println("Thread's dying now. Flow");
    }
}
