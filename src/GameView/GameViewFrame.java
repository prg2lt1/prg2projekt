package GameView;

import GameControl.Flow;
import GameModel.Board;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * Dots & Boxes GUI.
 */
public final class GameViewFrame extends JFrame implements ActionListener {

    private final int width;
    private final int height;
    private final Board board;
    private Flow flow;

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
     * @param board
     */
    public GameViewFrame(Board board) {
        super("Dots & Boxes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        width = 800;
        height = 600;
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

        gameViewPanel = new GameViewPanel(this.board);
        this.add(gameViewPanel);

        setLocation(400, 200);
        setSize(width, height);
        setVisible(true);
    }

    public void setFlow(Flow flow) {
        this.flow = flow;
        gameViewPanel.setFlow(this.flow);
        System.out.println("[debug] flow: " + this.flow);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == miGameExit) {
            System.out.println("[info] exit game");
            System.exit(0);
        }
        if (e.getSource() == miSaveGame) {
            System.out.println("[info] safe game");
        }
        if (e.getSource() == miLoadGame) {
            System.out.println("[info] load game");
        }
        if (e.getSource() == miHelpAbout) {
            System.out.println("[info] show about window");
        }
    }
}
