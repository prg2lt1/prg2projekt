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
        wait,
        run,
        endGame,
    }

    private String newOpponent = "-1";
    private boolean runGame = true;
    private ControlStates stateStart = ControlStates.prepare;
    private Player user;
    private Opponent opponent = null;

    private Board board;
    private Flow flow;
    private final GameViewFrame gameViewFrame;
    private final MoveExecutor moveExecutor;
    private final UserInput userInput;

    public MainControl() {
        this.userInput = new UserInput(this);
        this.board = new Board(4);
        this.gameViewFrame = new GameViewFrame(this.board);
        this.moveExecutor = new MoveExecutor(board);

        gameStart();
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
        //board = new Board(newSize);
        updateBoard();
    }

    public void saveGame() {
        if (flow.getState() == Flow.FlowStates.userTurn) {
            FileIO.saveBoard(board);
            userInput.Message("Game was saved", "Sucess");
        } else {
            userInput.Message("You can only save, when it's your turn", "Error");
        }
    }

    public void loadGame() {
        this.board = FileIO.loadBoard();
        flow.setState(Flow.FlowStates.userTurn);
    }

    public void updateBoard() {
        //geht in die Klassen das Board ersetzen...
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
                    this.flow = new Flow(moveExecutor, opponent, user);
                    gameViewFrame.setFlow(this.flow);
                    flow.gameRun();
                    stateStart = ControlStates.wait;
                    break;

                case endGame:
                    System.out.println("[debug (MainControl)] state endGame: " + stateStart);
                    this.runGame = false;

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
     * @param args
     */
    public static void main(String[] args) {
        MainControl mainControl = new MainControl();
    }
}
