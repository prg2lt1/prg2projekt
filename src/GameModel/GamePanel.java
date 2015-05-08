package GameModel;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

    JMenuBar menuBar = new JMenuBar();
    JMenu menuGame = new JMenu("Game");
    JMenuItem miSaveGame = new JMenuItem("Save");
    JMenuItem miLoadGame = new JMenuItem("Load");
    JMenuItem miGameExit = new JMenuItem("Exit");
    JMenu menuHelp = new JMenu("Help");
    JMenuItem miHelpAbout = new JMenuItem("About");

    private final JButton myName = new JButton("myName");
    private final JButton myScore = new JButton("myScore");
    private final JButton otherName = new JButton("otherName");
    private final JButton otherScore = new JButton("otherScore");
    private final JButton saveGame = new JButton("saveGame");
    private final JButton loadGame = new JButton("loadGame");

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
        
        setSize(800, 600);
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
        drawDots(4, 4);
        add(gamePanel, BorderLayout.CENTER);
        
        // Listener registrieren.
        gamePanel.addMouseListener(null);
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

    private void drawDots(int cols, int rows) {

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
    
/*    @Override
    public void mousePressed(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        
        System.out.println("[info] MouseClick coordinates: [" + x + "],[" + y + "]");
    }*/

    public static void main(final String[] args) {
        final GamePanel frame = new GamePanel();
    }

    /*@Override
     public void paint(Graphics g) {
     super.paint(g);
     }*/
}
