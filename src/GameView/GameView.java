package GameView;

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
public final class GameView extends JFrame implements ActionListener {

    private final int width;
    private final int height;
    private final Board board;
    private final int dotSpace;
    private final int originX;
    private final int originY;
    
    private ArrayList<Dot> dotList;
    private ArrayList<Line> lineList;

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
     * @param board
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
                System.out.println("[info] mouse pressed...");
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

    /*
    // konvertiert X-&Y-Koordinaten zu Linie
    private void coordinateToLine(int x, int y) {
        int pointX = coordinateToXPoint(x);
        int pointY = coordinateToYPoint(y);
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
    }*/
    
    private int coordinateToXPoint(int x) {
        return (x - originX) / dotSpace;
    }

    private int coordinateToYPoint(int y) {
        return (y - originY + dotSpace) / dotSpace;
    }

    // zeichnet die Punkte
    private void drawDots(Graphics g) {
        Iterator<GameModel.Dot> itr = board.getDots().iterator();
        while (itr.hasNext()) {
            GameModel.Dot gameModelDot = (GameModel.Dot) itr.next();
            Dot dot = new Dot(gameModelDot.getX()*dotSpace+originX, gameModelDot.getY()*dotSpace+originY);
            dotList.add(dot);
            //System.out.println("[info] dot position: [" + dot.getX() + "],[" + dot.getY() + "]");
            g.setColor(dot.getColor());
            g.fillOval(dot.getX(), dot.getY(), dot.getRadius(), dot.getRadius());
        }
    }

    // zeichnet die Linien
    private void drawLines(Graphics g) {
        /*Iterator<GameModel.Line> itr = board.getLines().iterator();
        while (itr.hasNext()) {
            GameModel.Line gameModelLine = (GameModel.Line) itr.next();
            Line line = new Line(gameModelLine.getStartingDot(), gameModelLine.getEndingDot());
            lineList.add(line);
            int startX = line.getStartingDotX();
            int startY = line.getStartingDotY();
            int endX = line.getEndingDotX();
            int endY = line.getEndingDotY();
            //System.out.println("[info] Line from [" + line.getStartingDotX() + "][" + line.getStartingDotY() + "] to [" + line.getEndingDotX() + "][" + line.getEndingDotY() + "]");
            g.setColor(line.getColor());
            g.fillRect(startX, startY, (endX - startX) + 5, (endY - startY) + 5);
        }*/
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawDots(g);
        drawLines(g);
    }
}
