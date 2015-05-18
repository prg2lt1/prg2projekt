package GameControl;

import GameModel.Board;
import GameModel.Opponent;
import GameModel.Player;
import GameView.GameView;

/**
 * Hauptverwaltung. Initiiere Spielfeld, Spieler, Netzwerk etc.
 *
 * @author Lorenz
 */
public class MainControl {

    private String stateStart = "prepare";
    private Player user;
    private Opponent opponent;

    private Flow flow;
    private Board board;
    private GameView gameView;
    private MoveChecker moveChecker;

    public MainControl() {
        this.board = new Board(4);
        this.gameView = new GameView(this.board);
        //this.moveChecker = new MoveChecker(board);

        gameStart();
    }

    public void gameStart() {

        do {
            switch (stateStart) {
                case "prepare":
                    System.out.println(stateStart);
                    user = new Player("Me");

                    //init network
                    stateStart = "getOpponent";
                    break;

                case "getOpponent":
                    System.out.println(stateStart);
                    opponent = new Opponent("Yami Yugi");
                    //Choose Opponent
                    //or get Invited
                    stateStart = "run";
                    break;

                case "run":
                    System.out.println(stateStart);
                    this.flow = new Flow(moveChecker, opponent, user);
                    while (flow.gameIsRunning()) {
                        //wait
                    }
                    stateStart = "endGame";
                    break;

                case "endGame":
                    //aufräumen?

                    if (true) { //Dialog oder ähnliches..
                        stateStart = "prepare";
                    } else {
                        stateStart = "gameFinished";
                    }
                    break;
            }
        } while (stateStart != "gameFinished");
    }

    /**
     * Startpunkt des ganzen Programms!
     */
    public static void main(String[] args) {
        MainControl mainControl = new MainControl();
    }
}
