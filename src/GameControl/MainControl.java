package GameControl;

import GameModel.Board;
import GameView.GameView;

/**
 * Hauptverwaltung. Initiiere Spielfeld, Spieler, Netzwerk etc.
 *
 * @author Lorenz
 */
public class MainControl {
   
    private String stateStart = "prepare"; 

    private Flow flow;
    private Board board;
    private GameView gameView;
    private MoveChecker moveChecker;

    public MainControl() {
        this.board = new Board(4);
        this.gameView = new GameView(this.board);
        this.flow = new Flow();
        //this.moveChecker = new MoveChecker(board);
    }

    private void gameStart() {

        switch (stateStart) {
            case "prepare":
                System.out.println(stateStart);

                //init network
                stateStart = "getOpponent";
                break;

            case "getOpponent":
                System.out.println(stateStart);
                    //Choose Opponent
                //or get Invited
                
                break;
        }
    }
        /**
         * Startpunkt des ganzen Programms!
         */
    public static void main(String[] args) {
        MainControl mainControl = new MainControl();
    }
}