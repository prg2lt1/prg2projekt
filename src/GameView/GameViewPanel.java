package GameView;

import GameControl.Flow;
import GameModel.Board;
import java.awt.Color;
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

    private Board board;
    private Flow flow;
        
    private final int dotSpace;
    private final int xSpace;
    private final int ySpace;

    private final ArrayList<Dot> dotList;
    private final ArrayList<Line> lineList;

    /**
     * Der Konstruktor zeichnet das Fenster mit dem Menu, den Buttons und der
     * Spielflaeche.
     * 
     * @param board
     */
    public GameViewPanel(Board board) {
        this.board = board;
        this.dotSpace = 150;
        this.xSpace = 100;
        this.ySpace = 35;

        dotList = new ArrayList<>();
        lineList = new ArrayList<>();

        // draw game panel
        setBackground(Color.white);

        // Listener registrieren.
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (flow.getCurrentPlayer() instanceof Opponent.Opponent) {
                    System.out.println("[info (GameViewPanel)] not your turn!");
                } else {
                    Iterator<Line> itr = lineList.iterator();
                    while (itr.hasNext()) {
                        Line line = (Line) itr.next();
                        if (line.lineMatch(e.getX(), e.getY())) {
                            //System.out.println("[info (GameViewPanel)] clicked lineID: " + lineList.indexOf(line));
                            flow.playLine(lineList.indexOf(line));
                        }
                    }
                    repaint();
                }
            }
        });
    }

    public void setFlow(Flow flow) {
        this.flow = flow;
    }
    
    public void setBoard(Board board){
        this.board = board;
    }

    // zeichnet die Punkte
    private void drawDots(Graphics g) {
        Iterator<GameModel.Dot> itr = board.getDots().iterator();
        while (itr.hasNext()) {
            GameModel.Dot gameModelDot = (GameModel.Dot) itr.next();
            if (dotList.size() < board.getDots().size()) {
                Dot dot = new Dot(gameModelDot.getX() * dotSpace + xSpace, gameModelDot.getY() * dotSpace + ySpace);
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
                int startX = gameModelLine.getStartingDot().getX() * dotSpace + xSpace;
                int startY = gameModelLine.getStartingDot().getY() * dotSpace + ySpace;
                int endX = gameModelLine.getEndingDot().getX() * dotSpace + xSpace;
                int endY = gameModelLine.getEndingDot().getY() * dotSpace + ySpace;
                lineList.add(new Line(startX, startY, endX, endY));
            }
            Line line = lineList.get(board.getLines().indexOf(gameModelLine));

            if (gameModelLine.getOwner() instanceof Opponent.Opponent) {
                line.setColor(Color.BLUE);
                System.out.println("[info (GameViewPanel)] set line " + lineList.indexOf(line) + " to blue");
            } else if (gameModelLine.getOwner() instanceof GameModel.Player) {
                line.setColor(Color.RED);
                System.out.println("[info (GameViewPanel)] set line " + lineList.indexOf(line) + " to red");
            } else {
                //System.out.println("default (no owner)");
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
