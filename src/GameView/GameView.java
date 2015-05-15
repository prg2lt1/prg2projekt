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

    private final int width = 800;
    private final int height = 600;

    private final JMenuBar menuBar = new JMenuBar();
    private final JMenu menuGame = new JMenu("Game");
    private final JMenuItem miSaveGame = new JMenuItem("Save");
    private final JMenuItem miLoadGame = new JMenuItem("Load");
    private final JMenuItem miGameExit = new JMenuItem("Exit");
    private final JMenu menuHelp = new JMenu("Help");
    private final JMenuItem miHelpAbout = new JMenuItem("About");

    private final JButton saveGame = new JButton("saveGame");
    private final JButton loadGame = new JButton("loadGame");

    private final ArrayList<Dot> dotMatrix = new ArrayList<>();

    Board board;

    /**
     * Der Konstruktor zeichnet das Fenster mit dem Menu, den Buttons und der
     * Spielflaeche.
     */
    public GameView() {
        super("Dots & Boxes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        board = new Board(4);

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
                int clickCoordinateX = getMatrixPointX(e.getX());
                int clickCoordinateY = getMatrixPointY(e.getY());
                System.out.println("[info] MouseClick at: [" + clickCoordinateX + "],[" + clickCoordinateY + "]");
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

    // gibt Grösse der Matrix zurück
    private int getSizeOfMatrix() {
        return board.getSize();
    }

    // gibt den Abstand zwischen den Punkten zurück
    private int getDotSpace() {
        if (width > height) {
            return height / getSizeOfMatrix();
        }
        return width / getSizeOfMatrix();
    }

    // gibt die X-Koordinate des Punktes oben links zurück
    private int getFirstDotPosX() {
        return (width - (getSizeOfMatrix() - 1) * getDotSpace()) / 2;
    }

    // gibt die Y-Koordinate des Punktes oben links zurück
    private int getFirstDotPosY() {
        return (height - (getSizeOfMatrix() - 1) * getDotSpace()) / 2;
    }

    // 
    private int getMatrixPointX(int position) {
        for (int i = 0; i < getSizeOfMatrix(); i++) {
            int delta = position - (getFirstDotPosX() + i * getDotSpace() - getDotSpace() / 2);
            if (Math.abs(delta) < getDotSpace()) {
                return i;
            }
        }
        return -1;
    }

    private int getMatrixPointY(int position) {
        for (int i = 0; i < getSizeOfMatrix(); i++) {
            int delta = position - (getFirstDotPosY() + i * getDotSpace() - getDotSpace() / 2);
            if (Math.abs(delta) < getDotSpace()) {
                return i;
            }
        }
        return -1;
    }

    // zeichnet die Punkte
    private Graphics drawDots(Graphics g) {
        Iterator<Dot> itr = board.getDots().iterator();
        while (itr.hasNext()) {
            Dot dot = (Dot) itr.next();
            System.out.println("[info] dot position: [" + dot.getX() + "],[" + dot.getY() + "]");
            g.setColor(dot.getFillColor());
            g.fillOval(getDotSpace() * dot.getX() + getFirstDotPosX(), getDotSpace() * dot.getY() + getFirstDotPosY(), dot.getRadius(), dot.getRadius());
        }
        return g;
    }

    // zeichnet die Linien
    private Graphics drawLines(Graphics g) {
        Iterator<Line> itrLines = board.getLines().iterator();
        while (itrLines.hasNext()) {
            Line line = (Line) itrLines.next();
            int startX = getFirstDotPosX() + getDotSpace() * line.getStartingDotX();
            int startY = getFirstDotPosY() + getDotSpace() * line.getStartingDotY();
            int endX = getFirstDotPosX() + getDotSpace() * line.getEndingDotX();
            int endY = getFirstDotPosY() + getDotSpace() * line.getEndingDotY();
            System.out.println("[info] Line from [" + line.getStartingDotX() + "][" + line.getStartingDotY() + "] to [" + line.getEndingDotX() + "][" + line.getEndingDotY() + "]");
            g.setColor(Color.GREEN);
            g.fillRect(startX, startY, (endX - startX) + 5, (endY - startY) + 5);
        }
        return g;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g = drawDots(g);
        g = drawLines(g);
    }
}