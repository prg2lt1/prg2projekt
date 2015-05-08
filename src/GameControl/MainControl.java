package GameControl;

import GameModel.Box;
import java.util.ArrayList;

/**
 * Startpunkt des ganzen Spiels. Initiiere Spielfeld, Spieler, Netzwerk etc.
 *
 * @author Lorenz
 */
public class MainControl {

    public ArrayList<Box> BoxList; //Liste der Boxen auf dem Spielfeld.

    public MainControl() {
        //initSpielfeld..
        //initSpieler
        //initNetzwerk etc.
    }

    /**
     *  erstellt die Liste, um die Boxen zu speichern und anzuzeigen
     */
    public void initList() {
        
        BoxList = new ArrayList<>();

    }

    public static void main(String[] args) {
        MainControl mainControl1 = new MainControl();
    }
}
