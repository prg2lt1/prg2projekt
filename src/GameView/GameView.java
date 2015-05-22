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
public final class GameView extends JFrame implements ActionListener {

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
    public GameView(Board board, Flow flow) {
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
                System.out.println("[info] click at: " + e.getX() + "/" + e.getY());
                Iterator<Line> itr = lineList.iterator();
                while (itr.hasNext()) {
                    Line line = (Line) itr.next();
                    if (line.lineMatch(e.getX(), e.getY())) {
                        System.out.println("[info] line at: " + line.getStartX() + " to " + line.getEndX() + " and " + line.getStartY() + " to " + line.getEndY());
                        //System.out.println("[info] lineID: "+lineList.indexOf(line));
                    }
                }
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

    // zeichnet die Punkte
    private void drawDots(Graphics g) {
        Iterator<GameModel.Dot> itr = board.getDots().iterator();
        while (itr.hasNext()) {
            GameModel.Dot gameModelDot = (GameModel.Dot) itr.next();
            if (dotList.size() < board.getDots().size()) {
                Dot dot = new Dot(gameModelDot.getX() * dotSpace + originX, gameModelDot.getY() * dotSpace + originY);
                dotList.add(dot);
            }
            Dot dot = dotList.get(board.getDots().indexOf(gameModelDot));
            g.setColor(dot.getColor());
            g.fillOval(dot.getX() - dot.getRadius() / 2, dot.getY() - dot.getRadius() / 2, dot.getRadius(), dot.getRadius());
        }
    }

    // zeichnet die Linien
    private void drawLines(Graphics g) {
        Iterator<GameModel.Line> itr = board.getLines().iterator();
        while (itr.hasNext()) {
            GameModel.Line gameModelLine = (GameModel.Line) itr.next();
            if (lineList.size() < board.getLines().size()) {
                int startX = gameModelLine.getStartingDot().getX() * dotSpace + originX;
                int startY = gameModelLine.getStartingDot().getY() * dotSpace + originY;
                int endX = gameModelLine.getEndingDot().getX() * dotSpace + originX;
                int endY = gameModelLine.getEndingDot().getY() * dotSpace + originY;
                lineList.add(new Line(startX, startY, endX, endY));
            }
            Line line = lineList.get(board.getLines().indexOf(gameModelLine));

            if (gameModelLine.getOwner() instanceof Opponent.Opponent) {
                Color colorByPlayer = Color.RED;
            } else if (gameModelLine.getOwner() instanceof GameModel.Player) {
                Color colorByPlayer = Color.BLUE;
            } else {
                Color colorByPlayer = Color.GRAY;
            }
            g.setColor(line.getColor());
            g.fillRect(line.getStartX(), line.getStartY(), (line.getEndX() - line.getStartX()) + 5, (line.getEndY() - (line.getStartY()) + 5));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawDots(g);
        drawLines(g);
    }
}
