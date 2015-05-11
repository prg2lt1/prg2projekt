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
public final class GamePanel extends JFrame implements ActionListener {
    
    private final int width = 800;
    private final int height = 600;
    
    private final JMenuBar menuBar = new JMenuBar();
    private final JMenu menuGame = new JMenu("Game");
    private final JMenuItem miSaveGame = new JMenuItem("Save");
    private final JMenuItem miLoadGame = new JMenuItem("Load");
    private final JMenuItem miGameExit = new JMenuItem("Exit");
    private final JMenu menuHelp = new JMenu("Help");
    private final JMenuItem miHelpAbout = new JMenuItem("About");

    private final JButton myName = new JButton("myName");
    private final JButton myScore = new JButton("myScore");
    private final JButton otherName = new JButton("otherName");
    private final JButton otherScore = new JButton("otherScore");
    private final JButton saveGame = new JButton("saveGame");
    private final JButton loadGame = new JButton("loadGame");

    private final ArrayList<Dot> dotMatrix = new ArrayList<>();
    
    Board board;

    /**
     * Der Konstruktor zeichnet das Fenster mit dem Menu, den Buttons und der
     * Spielflaeche.
     */
    public GamePanel() {
        super("Dots & Boxes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        board = new Board(4);
        
        drawMenu();
        //drawTopPanel();
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
     * Zeichnet das TopPanel.
     */
    private void drawTopPanel() {
        JPanel topPanel = new JPanel();
        topPanel.add(myName);
        topPanel.add(myScore);
        topPanel.add(otherName);
        topPanel.add(otherScore);
        add(topPanel, BorderLayout.NORTH);
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
                //drawLine();
                System.out.print("\n[info] MouseClick coordinates: [" + e.getX() + "],[" + e.getY() + "]");
                System.out.print(", matrix point [" + getMatrixPointX(e.getX()) + "],[" + getMatrixPointY(e.getY()) + "]");
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

    public static void main(final String[] args) {
        final GamePanel frame = new GamePanel();
    }

    private int getSizeOfMatrix() {
        return board.getSize();
    }

    private int getDotSpace() {
        if (width > height) {
            return height / getSizeOfMatrix();
        }
        return width / getSizeOfMatrix();
    }

    private int getFirstDotPosX() {
        return (width - (getSizeOfMatrix() - 1) * getDotSpace()) / 2;
    }

    private int getFirstDotPosY() {
        return (height - (getSizeOfMatrix() - 1) * getDotSpace()) / 2;
    }

    private int getMatrixPointX(int position) {
        for (int i = 0; i < getSizeOfMatrix(); i++) {
            int delta = position - (getFirstDotPosX() + i * getDotSpace() - getDotSpace()/2);
            if (Math.abs(delta) < getDotSpace()) {
                return i;
            }
        }
        return -1;
    }

    private int getMatrixPointY(int position) {
        for (int i = 0; i < getSizeOfMatrix(); i++) {
            int delta = position - (getFirstDotPosY() + i * getDotSpace() - getDotSpace()/2);
            if (Math.abs(delta) < getDotSpace()) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        Iterator<Dot> itr = board.getDots().iterator();
        while (itr.hasNext()) {
            Dot dot = (Dot) itr.next();
            System.out.println("[info] dot position: [" + dot.getX() + "],[" + dot.getY() + "]");
            g.setColor(dot.getFillColor());
            g.fillArc(getDotSpace()*dot.getX()+getFirstDotPosX(),getDotSpace()*dot.getY()+getFirstDotPosY(), dot.getRadius(), dot.getRadius(), 0, 360);
        }
        Iterator<Line> itrHorizLines = board.getHorizontalLines().iterator();
        while (itrHorizLines.hasNext()) {
            Line line = (Line) itrHorizLines.next();
            int startX = getDotSpace()*line.getStartingDotX()+getFirstDotPosX();
            int startY = getDotSpace()*line.getStartingDotY()+getFirstDotPosY();
            int endX = getDotSpace()*line.getEndingDotX()+getFirstDotPosX();
            int endY = getDotSpace()*line.getEndingDotY()+getFirstDotPosY();
            System.out.println("[info] HLine from [" + startX + "],[" + startY + "]");
            System.out.println("[info]                 to [" + endX + "],[" + endY + "]");
            g.setColor(Color.ORANGE);
            g.fillRect(startX, startY, endX-endY, 5);
        }
        Iterator<Line> itrVerticLines = board.getVerticalLines().iterator();
        while (itrVerticLines.hasNext()) {
            Line line = (Line) itrVerticLines.next();
            int startX = getDotSpace()*line.getStartingDotX()+getFirstDotPosX();
            int startY = getDotSpace()*line.getStartingDotY()+getFirstDotPosY();
            int endX = getDotSpace()*line.getEndingDotX()+getFirstDotPosX();
            int endY = getDotSpace()*line.getEndingDotY()+getFirstDotPosY();
            System.out.println("[info] VLine from [" + startX + "],[" + startY + "]");
            System.out.println("[info]                 to [" + endX + "],[" + endY + "]");
            g.setColor(Color.ORANGE);
            g.fillRect(startX, startY, 5, endY-startY);
        }
    }
}
