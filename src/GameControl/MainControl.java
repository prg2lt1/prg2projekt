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
public class MainControl {

    private String newOpponent = "-1";
    private boolean runGame = true;
    private String stateStart = "prepare";
    private Player user;
    private Opponent opponent = null;

    private Board board;
    private Flow flow;
    private GameViewFrame gameView;
    private MoveExecutor moveExecutor;
    private UserInput userInput;

    public MainControl() {
        this.board = new Board(4);
        this.gameView = new GameViewFrame(this.board, this.flow);
        this.moveExecutor = new MoveExecutor(board);
        this.userInput = new UserInput(this);
        gameStart();
    }

    /**
     * nicht verwendet
     * @param newState 
     */
    public void setState(String newState) {
        if (newState.equals("OpponentSet")) {
            this.stateStart = "OpponetSet";
        }
        else{
            System.out.println("unknown command in setState MainControl");
        }
    }

    /**
     * Gegner wird von Anzeige gesetzt
     * @param newOpponent 
     */
    public void setOpponent(String newOpponent) {

        System.out.println("getOpponent got" + newOpponent);
        
        if (newOpponent.equals("Computer")) {
            this.opponent = new ComputerBrain(board, moveExecutor);
        } else if (newOpponent.equals("Network")) {
            this.opponent = new NetworkPlayer();
            //Hier müsste nach Netzwerkgegner gesucht werden.
        } else {
            System.out.println("unknownOpponentFound");
        }
        
        this.stateStart = "run";
    }
    
    public void setUserName(String newName){
        user.setName(newName);
    }
    
    public void setBoardSize(int newSize){
        //board = new Board(newSize);
    }

    public void gameStart() {

        do {
            switch (stateStart) {
                case "prepare":
                    System.out.println(stateStart);
                    user = new Player("lokal Player");

                    stateStart = "getOpponent";
                    break;

                case "getOpponent":
                    System.out.println(stateStart);
                    userInput.setGameMode();

                    stateStart = "wait";
                    break;

                case "wait":
                    //System.out.println(stateStart);
                    break;

                case "run":
                    System.out.println(stateStart);
                    this.flow = new Flow(moveExecutor, opponent, user);
                    while (flow.gameIsRunning()) {
                    }
                    
                    break;

                case "endGame":
                    this.runGame = false;

                    if (true) { //Dialog oder ähnliches..
                        stateStart = "prepare";
                    } else {
                        stateStart = "gameFinished";
                    }
                    break;
            }
        } while (runGame);
    }

    /**
     * Startpunkt des ganzen Programms! Eingabe Argument entweder "Computer"
     * oder "Network", je nach gewünschtem Gegner
     */
    public static void main(String[] args) {
        MainControl mainControl = new MainControl();
    }
}
