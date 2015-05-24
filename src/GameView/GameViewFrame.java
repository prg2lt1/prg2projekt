package GameView;

import GameControl.Flow;
import GameControl.MainControl;
import GameModel.Board;
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
    private final MainControl mainControl;
    private Board board;
    private Flow flow;

    private final GameViewSidePanel gameViewSidePanel;
    private final GameViewPanel gameViewPanel;
    private final JMenuBar menuBar;
    private final JMenu menuGame;
    private final JMenu menuHelp;
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
        miSaveGame = new JMenuItem("Save");
        miLoadGame = new JMenuItem("Load");
        miGameExit = new JMenuItem("Exit");
        miHelpAbout = new JMenuItem("About");

        //draw menu
        menuGame.add(miSaveGame);
        menuGame.add(miLoadGame);
        menuGame.addSeparator();
        menuGame.add(miGameExit);
        menuBar.add(menuGame);
        menuHelp.add(miHelpAbout);
        menuBar.add(menuHelp);
        setJMenuBar(menuBar);

        // Listener registrieren.
        miSaveGame.addActionListener(this);
        miLoadGame.addActionListener(this);
        miGameExit.addActionListener(this);
        miHelpAbout.addActionListener(this);

        // game panel
        gameViewSidePanel = new GameViewSidePanel();
        gameViewPanel = new GameViewPanel(this.board);
        this.add(gameViewSidePanel, BorderLayout.WEST);
        this.add(gameViewPanel, BorderLayout.CENTER);

        setLocation(400, 200);
        setSize(width, height);
        setVisible(true);
    }

    public void setFlow(Flow flow) {
        this.flow = flow;
        gameViewPanel.setFlow(this.flow);
    }
    
    public void setBoard(Board board){
        this.board = board;
        gameViewPanel.setBoard(this.board);
    }
    
    public void setPlayerName(String name){
        gameViewSidePanel.setPlayerName(name);
    }
    
    public void incrementPlayerScore(){
        gameViewSidePanel.incrementPlayerScore();
    }
    
    public void setOpponentName(String name){
        gameViewSidePanel.setOpponentName(name);
    }
    
    public void incrementOpponentScore(){
        gameViewSidePanel.incrementOpponentScore();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == miGameExit) {
            System.out.println("[info (GameViewFrame)] exit game");
            System.exit(0);
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
