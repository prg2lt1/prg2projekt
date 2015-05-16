package GameView;

import GameModel.Board;
import GameModel.Dot;
import GameModel.Line;
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
public final class GameView extends JFrame implements ActionListener {

    private final int width;
    private final int height;
    Board board;
    private final int dotSpace;
    private final int originX;
    private final int originY;

    private final JMenuBar menuBar;
    private final JMenu menuGame;
    private final JMenu menuHelp;
    private final JMenuItem miSaveGame;
    private final JMenuItem miLoadGame;
    private final JMenuItem miGameExit;
    private final JMenuItem miHelpAbout;

    private final JButton saveGame;
    private final JButton loadGame;

    private final ArrayList<Dot> dotMatrix;

    /**
     * Der Konstruktor zeichnet das Fenster mit dem Menu, den Buttons und der
     * Spielflaeche.
     */
    public GameView(Board board) {
        super("Dots & Boxes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        width = 800;
        height = 600;
        this.board = board;
        dotSpace = 150;
        originX = (width - (board.getSize() - 1) * dotSpace) / 2;
        originY = (height - (board.getSize() - 1) * dotSpace) / 2;

        menuBar = new JMenuBar();
        menuGame = new JMenu("Game");
        menuHelp = new JMenu("Help");
        miSaveGame = new JMenuItem("Save");
        miLoadGame = new JMenuItem("Load");
        miGameExit = new JMenuItem("Exit");
        miHelpAbout = new JMenuItem("About");
        saveGame = new JButton("saveGame");
        loadGame = new JButton("loadGame");

        dotMatrix = new ArrayList<>();

        drawMenu();
        drawGamePanel();
        drawBottomPanel();

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

    /*
     * Zeichnet das GamePanel und registriert die ActionListeners.
     */
    private void drawGamePanel() {
        JPanel gamePanel = new JPanel();
        gamePanel.setBackground(Color.white);
        add(gamePanel, BorderLayout.CENTER);

        // Listener registrieren.
        gamePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //Line line = coordinateToLine(e.getX(), e.getY());
                coordinateToLine(e.getX(), e.getY());
                //System.out.print("\n[info] Line from [" + line.getStartingDot().getX() + "][" + line.getStartingDot().getY() + "]");
                //System.out.print("                to [" + line.getEndingDot().getX() + "][" + line.getEndingDot().getY() + "]");
            }
        });
    }

    /*
     * Zeichnet das BottomPanel und registriert die ActionListeners.
     */
    private void drawBottomPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(saveGame);
        bottomPanel.add(loadGame);
        add(bottomPanel, BorderLayout.SOUTH);

        // Listener registrieren.
        saveGame.addActionListener(this);
        loadGame.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == miGameExit) {
            System.out.println("[info] exit game");
            System.exit(0);
        }
        if (e.getSource() == miSaveGame || e.getSource() == saveGame) {
            System.out.println("[info] safe game");
        }
        if (e.getSource() == miLoadGame || e.getSource() == loadGame) {
            System.out.println("[info] load game");
        }
        if (e.getSource() == miHelpAbout) {
            System.out.println("[info] show about window");
        }
    }

    // konvertiert X-&Y-Koordinaten zu Linie
    private void coordinateToLine(int x, int y) {
        int pointX = coordinateToXPoint(x);
        int pointY = coordinateToYPoint(y);
        boolean isHorizontal = coordinatesToLevel(x, y); //horizontal = true, vertical = false
        System.out.println("[info] point [" + pointX + "][" + pointY + "]");
        //System.out.println("[info] isHorizontal: " + isHorizontal);

        Iterator<Line> itrLines = board.getLines().iterator();
        while (itrLines.hasNext()) {
            Line line = (Line) itrLines.next();
            if (line.getStartingDot().getX() == pointX) {
                //if (line.getStartingDot().getY() == pointY ) {
                    //System.out.print("\n[info] line from point [" + line.getStartingDot().getX() + "][" + line.getStartingDot().getY() + "]");
                    //System.out.print(" to [" + line.getEndingDot().getX() + "][" + line.getEndingDot().getY() + "]");

                //}
            }
        }
        //return null;
    }

    /*
     * returns the level of the click.
     * horizontal = true, vertical = false
     */
    private boolean coordinatesToLevel(int x, int y) {
        int tolerance = 10;
        int xnom = coordinateToXPoint(x) * dotSpace + originX;
        int ynom = coordinateToYPoint(y) * dotSpace + originY;
        int xmin = xnom - tolerance;
        int ymin = ynom - tolerance;
        int xmax = xnom + tolerance;
        int ymax = ynom + tolerance;
        if (ymin <= y && y <= ymax) {
            System.out.println("[info] y ok.");
        }
        return false;
    }
    
    private int coordinateToXPoint(int x) {
        return (x - originX) / dotSpace;
    }

    private int coordinateToYPoint(int y) {
        return (y - originY + dotSpace) / dotSpace;
    }

    // zeichnet die Punkte
    private void drawDots(Graphics g) {
        Iterator<Dot> itr = board.getDots().iterator();
        while (itr.hasNext()) {
            Dot dot = (Dot) itr.next();
            //System.out.println("[info] dot position: [" + dot.getX() + "],[" + dot.getY() + "]");
            g.setColor(dot.getFillColor());
            g.fillOval(dotSpace * dot.getX() + originX, dotSpace * dot.getY() + originY, dot.getRadius(), dot.getRadius());
        }
    }

    // zeichnet die Linien
    private void drawLines(Graphics g) {
        Iterator<Line> itrLines = board.getLines().iterator();
        while (itrLines.hasNext()) {
            Line line = (Line) itrLines.next();
            int startX = originX + dotSpace * line.getStartingDotX();
            int startY = originY + dotSpace * line.getStartingDotY();
            int endX = originX + dotSpace * line.getEndingDotX();
            int endY = originY + dotSpace * line.getEndingDotY();
            //System.out.println("[info] Line from [" + line.getStartingDotX() + "][" + line.getStartingDotY() + "] to [" + line.getEndingDotX() + "][" + line.getEndingDotY() + "]");
            g.setColor(Color.GREEN);
            g.fillRect(startX, startY, (endX - startX) + 5, (endY - startY) + 5);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawDots(g);
        drawLines(g);
    }
}
