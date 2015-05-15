package GameControl;

import GameModel.Box;
import GameModel.Flow;
import GameView.GamePanel;
import java.util.ArrayList;

/**
 * Hauptverwaltung. Initiiere Spielfeld, Spieler, Netzwerk etc.
 *
 * @author Lorenz
 */
public class MainControl {

    private Flow flow;
   

    public MainControl() {
        this.flow = new Flow();
    }

    /**
     *  Startpunkt des ganzen Programms??
     */
    public static void main(String[] args) {
        MainControl mainControl = new MainControl();
    }
}
