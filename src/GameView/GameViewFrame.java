package GameView;

import GameControl.Flow;
import GameModel.Board;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JButton;
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
    private final int dotSpace;
    private final int originX;
    private final int originY;

    private final Flow flow;

    private final ArrayList<Dot> dotList;
    private final ArrayList<Line> lineList;

    private final JMenuBar menuBar;
    private final JMenu menuGame;
    private final JMenu menuHelp;
    private final JMenuItem miSaveGame;
    private final JMenuItem miLoadGame;
    private final JMenuItem miGameExit;
    private final JMenuItem miHelpAbout;

    private final JButton saveGame;
    private final JButton loadGame;

    /**
     * Der Konstruktor zeichnet das Fenster mit dem Menu, den Buttons und der
     * Spielflaeche.
     *
     * @param board
     * @param flow
     */
    public GameViewFrame(Board board, Flow flow) {
        super("Dots & Boxes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        width = 800;
        height = 600;
        this.board = board;
        dotSpace = 150;
        originX = (width - (board.getSize() - 1) * dotSpace) / 2;
        originY = (height - (board.getSize() - 1) * dotSpace) / 2;

        this.flow = flow;

        dotList = new ArrayList<>();
        lineList = new ArrayList<>();

        menuBar = new JMenuBar();
        menuGame = new JMenu("Game");
        menuHelp = new JMenu("Help");
        miSaveGame = new JMenuItem("Save");
        miLoadGame = new JMenuItem("Load");
        miGameExit = new JMenuItem("Exit");
        miHelpAbout = new JMenuItem("About");
        saveGame = new JButton("saveGame");
        loadGame = new JButton("loadGame");

        drawMenu();
        drawGamePanel();
        drawBottomPanel();

        setLocation(400, 200);
        setSize(width, height);
        setVisible(true);
    }

    /*
     * Zeichnet das Menu und registriert die ActionListeners.
     */
    private void drawMenu() {
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
