package GameControl;

import GameModel.Box;
import GameModel.Flow;
import GameModel.Board;
import GameView.GameView;
import java.util.ArrayList;

/**
 * Hauptverwaltung. Initiiere Spielfeld, Spieler, Netzwerk etc.
 *
 * @author Lorenz
 */
public class MainControl {

    private Flow flow;
    private Board board;
    private GameView gameView;
    private MoveChecker moveChecker;

    public MainControl() {
        this.flow = new Flow();
        this.board = new Board(4);
        this.gameView = new GameView(this.board);
        this.moveChecker = new MoveChecker(board);
    }

    /**
     *  Startpunkt des ganzen Programms??
     */
    public static void main(String[] args) {
        MainControl mainControl = new MainControl();
    }
}
