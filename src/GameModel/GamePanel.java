package GameModel;

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

    private final ArrayList<Dot> list = new ArrayList<>();

    /**
     * Der Konstruktor zeichnet das Fenster mit dem Menu, den Buttons und der
     * Spielflaeche.
     */
    public GamePanel() {
        super("Dots & Boxes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        drawMenu();
        drawTopPanel();
        drawGamePanel();
        drawBottomPanel();

        setSize(width, height);
        //pack();
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
        drawDotMatrix(4, 4);
        add(gamePanel, BorderLayout.CENTER);

        // Listener registrieren.
        gamePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawLine();
                System.out.println("[info] MouseClick coordinates: [" + e.getX() + "],[" + e.getY() + "]");
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

    private void drawDotMatrix(int rows, int cols) {
        int dotSpaceX = 80;
        int dotSpaceY = 80;
        int firstDotX = (width - (cols-1)*dotSpaceX)/2;
        int firstDotY = (height - (rows-1)*dotSpaceY)/2;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Dot dot = new Dot(i*dotSpaceX + firstDotX, j*dotSpaceY + firstDotY);
                list.add(dot);
                System.out.println("[info] dot coordinates: [" + dot.getX() + "],[" + dot.getY() + "]");
            }
        }
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

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Iterator<Dot> itr = list.iterator();
        while (itr.hasNext()) {
            Dot dot = (Dot) itr.next();
            g.setColor(dot.getFillColor());
            g.fillArc(dot.getX(), dot.getY(), dot.getRadius(), dot.getRadius(), 0, 360);
        }
    }
}
