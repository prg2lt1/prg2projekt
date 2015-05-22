package GameView;

import GameControl.Flow;
import GameModel.Board;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;

/**
 * Dots & Boxes GUI.
 */
public final class GameViewPanel extends JPanel {

    private final Board board;
    private final int dotSpace;
    private final int space;

    private final Flow flow;

    private final ArrayList<Dot> dotList;
    private final ArrayList<Line> lineList;

    /**
     * Der Konstruktor zeichnet das Fenster mit dem Menu, den Buttons und der
     * Spielflaeche.
     *
     * @param board
     * @param flow
     */
    public GameViewPanel(Board board, Flow flow) {
        this.board = board;
        this.dotSpace = 150;
        this.space = 50;

        this.flow = flow;

        dotList = new ArrayList<>();
        lineList = new ArrayList<>();

        // draw game panel
        setBackground(Color.white);

        // Listener registrieren.
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //System.out.println("[info] click at: " + e.getX() + "/" + e.getY());
                Iterator<Line> itr = lineList.iterator();
                while (itr.hasNext()) {
                    Line line = (Line) itr.next();
                    if (line.lineMatch(e.getX(), e.getY())) {
                        //System.out.println("[info] line at: " + line.getStartX() + " to " + line.getEndX() + " and " + line.getStartY() + " to " + line.getEndY());
                        System.out.println("[info] lineID: "+lineList.indexOf(line));
                        flow.playLine(lineList.indexOf(line));
                    }
                }
            }
        });
    }

    // zeichnet die Punkte
    private void drawDots(Graphics g) {
        Iterator<GameModel.Dot> itr = board.getDots().iterator();
        while (itr.hasNext()) {
            GameModel.Dot gameModelDot = (GameModel.Dot) itr.next();
            if (dotList.size() < board.getDots().size()) {
                Dot dot = new Dot(gameModelDot.getX() * dotSpace + space, gameModelDot.getY() * dotSpace + space);
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
                int startX = gameModelLine.getStartingDot().getX() * dotSpace + space;
                int startY = gameModelLine.getStartingDot().getY() * dotSpace + space;
                int endX = gameModelLine.getEndingDot().getX() * dotSpace + space;
                int endY = gameModelLine.getEndingDot().getY() * dotSpace + space;
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
