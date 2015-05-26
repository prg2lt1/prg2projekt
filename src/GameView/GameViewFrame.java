package GameView;

import GameControl.Flow;
import GameControl.MainControl;
import GameModel.Board;
import GameModel.Player;
import Opponent.Opponent;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Dots & Boxes GUI.
 */
public final class GameViewFrame extends JFrame implements ActionListener {

    private final int width;
    private final int height;
    private MainControl mainControl;
    private Board board;
    private Flow flow;

    private GameViewSidePanel gameViewSidePanel;
    private GameViewPanel gameViewPanel;
    private final JMenuBar menuBar;
    private final JMenu menuGame;
    private final JMenu menuHelp;
    private final JMenuItem miNewGame;
    private final JMenuItem miSaveGame;
    private final JMenuItem miLoadGame;
    private final JMenuItem miGameExit;
    private final JMenuItem miHelpAbout;

    /**
     * Der Konstruktor zeichnet das Fenster mit dem Menu, den Buttons und der
     * Spielflaeche.
     *
     * @param mainControl
     * @param board
     */
    public GameViewFrame(MainControl mainControl, Board board) {
        super("Dots & Boxes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        width = 800;
        height = 600;
        this.mainControl = mainControl;
        this.board = board;

        menuBar = new JMenuBar();
        menuGame = new JMenu("Game");
        menuHelp = new JMenu("Help");
        miNewGame = new JMenuItem("New Game");
        miSaveGame = new JMenuItem("Save");
        miLoadGame = new JMenuItem("Load");
        miGameExit = new JMenuItem("Exit");
        miHelpAbout = new JMenuItem("About");

        //draw menu
        menuGame.add(miNewGame);
        menuGame.add(miSaveGame);
        menuGame.add(miLoadGame);
        menuGame.addSeparator();
        menuGame.add(miGameExit);
        menuBar.add(menuGame);
        menuHelp.add(miHelpAbout);
        menuBar.add(menuHelp);
        setJMenuBar(menuBar);

        // Listener registrieren.
        miNewGame.addActionListener(this);
        miSaveGame.addActionListener(this);
        miLoadGame.addActionListener(this);
        miGameExit.addActionListener(this);
        miHelpAbout.addActionListener(this);

        // game panel
        gameViewSidePanel = new GameViewSidePanel();
        gameViewPanel = new GameViewPanel(this.board, this);
        this.add(gameViewSidePanel, BorderLayout.WEST);
        this.add(gameViewPanel, BorderLayout.CENTER);

        setLocation(400, 200);
        setSize(width, height);
        setVisible(true);
    }

    public void hideFrame() {
        this.gameViewPanel = null;
        this.gameViewSidePanel = null;
        this.mainControl = null;
        this.flow = null;
        setVisible(false);
    }

    public void setFlow(Flow flow) {
        this.flow = flow;
        gameViewPanel.setFlow(this.flow);
    }

    public void setBoard(Board board) {
        this.board = board;
        gameViewPanel.setBoard(this.board);
    }

    public void setPlayer(Player user) {
        gameViewSidePanel.setPlayer(user);
    }

    public void getPlayerScore() {
        gameViewSidePanel.getPlayerScore();
    }

    public void setOpponent(Opponent opponent) {
        gameViewSidePanel.setOpponent(opponent);
    }

    public void getOpponentScore() {
        gameViewSidePanel.getOpponentScore();
    }
    
    public void repaintPanel() {
        gameViewPanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == miGameExit) {
            System.out.println("[info (GameViewFrame)] exit game");
            System.exit(0);
        }
        if (e.getSource() == miNewGame) {
            System.out.println("[info (GameViewFrame)] new game");
            mainControl.newGame();
        }
        if (e.getSource() == miSaveGame) {
            System.out.println("[info (GameViewFrame)] save game");
            mainControl.saveGame();
        }
        if (e.getSource() == miLoadGame) {
            System.out.println("[info (GameViewFrame)] load game");
            mainControl.loadGame();
        }
        if (e.getSource() == miHelpAbout) {
            System.out.println("[info (GameViewFrame)] show about window");
            mainControl.showAbout();
        }
    }
}
