package GameControl;

import GameModel.Box;
import GameModel.Flow;
import GameView.GamePanel;
import java.util.ArrayList;

/**
 * Startpunkt des ganzen Spiels. Initiiere Spielfeld, Spieler, Netzwerk etc.
 *
 * @author Lorenz
 */
public class MainControl {

    private Flow flow;
    public ArrayList<Box> BoxList; //Liste der Boxen auf dem Spielfeld.

    public MainControl() {
        this.flow = new Flow();
    }

    /**
     *  genaue Funktion muss noch diskutiert werden
     */
    public void initField() {
 
        BoxList = new ArrayList<>();

    }

    public static void main(String[] args) {
        MainControl mainControl = new MainControl();
    }
}
