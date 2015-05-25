package GameControl;

import GameModel.Board;
import Opponent.NetworkPlayer;
import Opponent.ComputerBrain;
import Opponent.Opponent;
import GameModel.Player;
import GameView.GameViewFrame;
import GameView.UserInput;
import GameView.EndOfGame;

/**
 * Hauptverwaltung. Initiiere Spielfeld, Spieler, Netzwerk etc.
 *
 * @author Lorenz
 */
public class MainControl implements FileIO {

    private enum ControlStates {

        prepare,
        getOpponent,
        wait,
        run,
        endGame,
    }

    private String newOpponent = "-1";
    private boolean runGame = true;
    private int boardSize = 4;
    private ControlStates stateStart = ControlStates.prepare;
    private Player user;
    private Opponent opponent = null;

    private Board board;
    private Flow flow;
    private MoveExecutor moveExecutor;
    private GameViewFrame gameViewFrame;
    private final UserInput userInput;
    private EndOfGame endOfGame;

    public MainControl() {
        this.userInput = new UserInput(this);
        this.board = new Board(boardSize);
        this.gameViewFrame = new GameViewFrame(this, this.board);
        this.moveExecutor = new MoveExecutor(board);
        this.endOfGame = new EndOfGame(this);
        

        this.gameStart();
    }

    /**
     * Gegner wird von Anzeige gesetzt
     *
     * @param newOpponent
     */
    public void setOpponent(String newOpponent) {

        System.out.println("[info (MainControl)] Opponent: " + newOpponent);

        switch (newOpponent) {
            case "Computer":
                this.opponent = new ComputerBrain(board, moveExecutor);
                gameViewFrame.setOpponentName("Computer");
                break;
            case "Network":
                this.opponent = new NetworkPlayer();
                gameViewFrame.setOpponentName("Network");
                //Hier müsste nach Netzwerkgegner gesucht werden.
                break;
            default:
                System.out.println("[error (MainControl)] unknownOpponentFound");
                break;
        }

        this.stateStart = ControlStates.run;
    }

    public void setUserName(String newName) {
        user.setName(newName);
        gameViewFrame.setPlayerName(newName);
    }

    public void setBoardSize(int newSize) {
        boardSize = newSize;
        this.newGame();
    }

    public void saveGame() {
        FileIO.saveBoard(board);
    }

    public void loadGame() {
        this.board = FileIO.loadBoard();
        //da wir dass bis jetzt nicht speichern, der pc aber ehh schnell spielt:
        flow.setState(Flow.FlowStates.userTurn);

        gameViewFrame.setBoard(this.board);
        gameViewFrame.setFlow(this.flow);
    }

    public void showAbout() {
        userInput.Message(("Try to complete as many Boxes as possible.\nAuthors: Frowin Imholz, Tobias Heer, Lorenz Schilter"), "About");
    }

    /**
     * new Game von dieser Klasse aus heisst: alles wipen und dann von anfang
     * an: neuer Gegner.
     */
    public void newGame() {
        System.out.println("[debug (MainControl)] newGame");
        this.board = new Board(boardSize);
        this.moveExecutor = new MoveExecutor(board);
        this.gameViewFrame = new GameViewFrame(this, this.board);
        this.flow = null;
        stateStart = ControlStates.prepare;
    }

    public void gameStart() {

        do {
            switch (stateStart) {
                case prepare:
                    System.out.println("[debug (MainControl)] state stateStart: " + stateStart);
                    user = new Player("user");

                    stateStart = ControlStates.getOpponent;
                    break;

                case getOpponent:
                    System.out.println("[debug (MainControl)] state getOpponent: " + stateStart);
                    userInput.setGameMode();
                    userInput.setPlayerName();
                    break;

                case wait:
                    System.out.println("[debug (MainControl)] state wait: " + stateStart);
                    break;

                case run:
                    //System.out.println("[debug] " + stateStart);
                    this.flow = new Flow(moveExecutor, opponent, user, endOfGame);
                    gameViewFrame.setFlow(this.flow);
                    flow.gameRun();
                    stateStart = ControlStates.endGame;
                    break;

                case endGame:
                    System.out.println("[debug (MainControl)] state endGame: " + stateStart);

                    userInput.GameOver();

                    if (true) { //Dialog oder ähnliches..
                        stateStart = ControlStates.prepare;
                    } else {
                        runGame = false;
                    }
                    break;
            }
        } while (runGame);
    }

    /**
     * Startpunkt des ganzen Programms! Eingabe Argument entweder "Computer"
     * oder "Network", je nach gewünschtem Gegner
     *
     * @param args
     */
    public static void main(String[] args) {
        MainControl mainControl = new MainControl();
    }
}
