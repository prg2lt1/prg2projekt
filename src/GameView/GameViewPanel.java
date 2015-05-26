package GameView;

import GameControl.Flow;
import GameModel.Board;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;

/**
 * Dots & Boxes GUI.
 *
 * @author Frowin Imholz
 */
public final class GameViewPanel extends JPanel {

    private Board board;
    private Flow flow;
    private GameViewFrame myFrame;


    private final int dotSpace;
    private final int xSpace;
    private final int ySpace;

    private final ArrayList<Dot> dotList;
    private final ArrayList<Line> lineList;
    private final ArrayList<Box> boxList;

    /**
     * Der Konstruktor zeichnet das Fenster mit dem Menu, den Buttons und der
     * Spielflaeche.
     *
     * @param board
     */
    public GameViewPanel(Board board, GameViewFrame myFrame) {
        
        this.board = board;
        this.myFrame = myFrame;
        this.dotSpace = 150;
        this.xSpace = 100;
        this.ySpace = 35;

        dotList = new ArrayList<>();
        lineList = new ArrayList<>();
        boxList = new ArrayList<>();

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

    public void setBoard(Board board) {
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
            g.fillOval(dot.getX(), dot.getY(), 2 * dot.getRadius(), 2 * dot.getRadius());
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
                int thickness = 6;
                lineList.add(new Line(startX, startY, endX, endY, thickness));
            }
            Line line = lineList.get(board.getLines().indexOf(gameModelLine));

            if (gameModelLine.getOwner() instanceof Opponent.Opponent) {
                line.setColor(Color.BLUE);
                //System.out.println("[info (GameViewPanel)] set line " + lineList.indexOf(line) + " to blue");
            } else if (gameModelLine.getOwner() instanceof GameModel.Player) {
                line.setColor(Color.RED);
                //System.out.println("[info (GameViewPanel)] set line " + lineList.indexOf(line) + " to red");
            } else {
                //System.out.println("default (no owner)");
            }

            g.setColor(line.getColor());
            g.fillRect(line.getStartX(), line.getStartY(), line.getWidth(), line.getHeight());
        }
    }

    // zeichnet die Boxen
    private void drawBoxes(Graphics g) {
        Iterator<GameModel.Box> itr = board.getBoxes().iterator();
        while (itr.hasNext()) {
            GameModel.Box gameModelBox = (GameModel.Box) itr.next();
            if (boxList.size() < board.getBoxes().size()) {
                int boxModulo = gameModelBox.getBoxNumber() % (int) sqrt(board.getBoxes().size());
                int boxDivider = gameModelBox.getBoxNumber() / (int) sqrt(board.getBoxes().size() + 1);
                //System.out.println("[debug (GameViewPanel)] boxModulo=" + boxModulo + " boxDivider=" + boxDivider);
                int startX = boxModulo * dotSpace + xSpace + 10;
                int endX = (boxModulo + 1) * dotSpace + xSpace - 10;
                int startY = boxDivider * dotSpace + ySpace + 10;
                int endY = (boxDivider + 1) * dotSpace + ySpace - 10;
                //System.out.println("[debug (GameViewPanel)] startX=" + startX + " endX=" + endX + " startY=" + startY + " endY=" + endY);
                boxList.add(new Box(startX, startY, endX, endY, gameModelBox.getOwner()));
                //System.out.println("[debug (GameViewPanel)] box " + board.getBoxes().indexOf(gameModelBox) + " owned by " + gameModelBox.getOwner());
                //System.out.println("[debug (GameViewPanel)] box " + board.getBoxes().indexOf(gameModelBox) + " starts at " + startX + ", " + startY);
            }
            Box box = boxList.get(board.getBoxes().indexOf(gameModelBox));
            box.setOwner(gameModelBox.getOwner());
            //System.out.println("[debug (GameViewPanel)] box " + board.getBoxes().indexOf(gameModelBox) + " owned by " + box.getOwner());
            if (box.getOwner() instanceof Opponent.Opponent) {
                g.setColor(Color.BLUE);
                g.fillRect(box.getStartX(), box.getStartY(), box.getEndX() - box.getStartX(), box.getEndY() - box.getStartY());
                myFrame.getOpponentScore();
                
            } else if (box.getOwner() instanceof GameModel.Player) {
                g.setColor(Color.RED);
                g.fillRect(box.getStartX(), box.getStartY(), box.getEndX() - box.getStartX(), box.getEndY() - box.getStartY());
                myFrame.getPlayerScore();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawDots(g);
        drawLines(g);
        drawBoxes(g);
    }
    
    
}
