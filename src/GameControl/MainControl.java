package GameControl;

import GameModel.Board;
import Opponent.NetworkPlayer;
import Opponent.ComputerBrain;
import Opponent.Opponent;
import GameModel.Player;
import GameView.GameViewFrame;
import GameView.UserInput;

/**
 * Hauptverwaltung. Initiiere Spielfeld, Spieler, Netzwerk etc.
 *
 * @author Lorenz
 */
public class MainControl implements FileIO {

    private enum ControlStates {

        prepare,
        getOpponent,
        setFlow,
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
    private UserInput userInput;

    public MainControl() {
        this.board = new Board(boardSize);
        this.gameViewFrame = new GameViewFrame(this, this.board);
        this.moveExecutor = new MoveExecutor(board);
        this.userInput = new UserInput(this, moveExecutor);

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
                moveExecutor.setOpponent(opponent);
                gameViewFrame.setOpponent(opponent);
                break;
            case "Network":
                this.opponent = new NetworkPlayer();
                moveExecutor.setOpponent(opponent);
                gameViewFrame.setOpponent(opponent);
                //Hier müsste nach Netzwerkgegner gesucht werden.
                break;
            default:
                System.out.println("[error (MainControl)] unknownOpponentFound");
                break;
        }

        this.stateStart = ControlStates.setFlow;
    }

    public void setUserName(String newName) {
        user.setName(newName);
        moveExecutor.setOpponent(opponent);
        gameViewFrame.setPlayer(user);
    }

    public void setBoardSize(int newSize) {
        boardSize = newSize;
        this.newGame();
    }

    public void saveGame() {
        FileIO.saveBoard(board);
        FileIO.saveFlow(flow);
    }

    public void loadGame() {
        this.board = FileIO.loadBoard();
        this.flow = FileIO.loadFlow();

        this.updateClasses();
    }

    public void showAbout() {
        userInput.Message(("Try to complete as many Boxes as possible.\n\n"
                + "Authors:\n Frowin Imholz, Tobias Heer, Lorenz Schilter"), "About");
    }

    /**
     * new Game von dieser Klasse aus heisst: alles wipen und dann von anfang
     * an: neuer Gegner.
     */
    public void newGame() {
        System.out.println("[debug (MainControl)] newGame");
        this.gameViewFrame.hideFrame();
        this.gameViewFrame = null;
        this.board = null;
        this.moveExecutor = null;
        this.flow = null;

        this.board = new Board(boardSize);
        this.gameViewFrame = new GameViewFrame(this, this.board);
        this.moveExecutor = new MoveExecutor(this.board);

        stateStart = ControlStates.getOpponent;

        user.setNmbOfBoxesZero();
        opponent.setNmbOfBoxesZero();

        runGame = true;
        this.gameStart();

    }

    public void updateClasses() {
        gameViewFrame.setBoard(this.board);
        gameViewFrame.setFlow(this.flow);
        this.flow.gameRun();
        stateStart = ControlStates.setFlow;
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

                case setFlow:
                    System.out.println("[debug (MainControl)] state wait: " + stateStart);
                    this.flow = new Flow(moveExecutor, opponent, user, gameViewFrame);
                    gameViewFrame.setFlow(this.flow);
                    stateStart = ControlStates.run;
                    break;

                case run:
                    //System.out.println("[debug (MainControl)] " + stateStart);
                    if (flow.gameIsRunning()) {
                        flow.gameRun();
                    } else {
                        stateStart = ControlStates.endGame;
                    }
                    break;

                case endGame:
                    runGame = false;
                    System.out.println("[debug (MainControl)] state endGame: " + stateStart);
                    userInput.GameOver(user.getNmbOfBoxes(), opponent.getNmbOfBoxes());
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
