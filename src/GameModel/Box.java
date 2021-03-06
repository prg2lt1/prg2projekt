
package GameModel;

import java.io.Serializable;

/**
 * Box auf dem Spielfeld, bestehend aus vier Linien
 * @author tobias
 */
public class Box implements Serializable {

    private final int boxNumber;
    private Line topLine;
    private Line bottomLine;
    private Line leftLine;
    private Line rightLine;
    private boolean isComplete;
    private Player owner;

    public Box(int boxNumber) {
        this.boxNumber = boxNumber;
        isComplete = false;
    }

    public Box(int boxNumber, Line top, Line bottom, Line left, Line right) {
        this.boxNumber = boxNumber;
        setTopLine(top);
        setBottomLine(bottom);
        setLeftLine(left);
        setRightLine(right);
    }

    /**
     * 
     * Getter methods für Attribute
     *
     * */
    
    public Player getOwner() {
        return owner;
    }

    public Line getLeftLine() {
        return leftLine;
    }

    public Line getRightLine() {
        return rightLine;
    }

    public Line getBottomLine() {
        return bottomLine;
    }

    public Line getTopLine() {
        return topLine;
    }

    public boolean isBoxComplete() {

        if (getNumberOfLines() == 4) {
            isComplete = true;
            //System.out.println("[debug (Box)] box completed");
        }
        return isComplete;
    }

    public int getBoxNumber() {
        return boxNumber;
    }

    public int getNumberOfLines() {
        int no = 0;
        if (topLine.getOwner() != null) {
            no++;
        }
        if (bottomLine.getOwner() != null) {
            no++;
        }
        if (leftLine.getOwner() != null) {
            no++;
        }
        if (rightLine.getOwner() != null) {
            no++;
        }
        return no;
    }

    private void setBottomLine(Line l) {
        bottomLine = l;
    }

    private void setTopLine(Line l) {
        topLine = l;
    }

    private void setLeftLine(Line l) {
        leftLine = l;
    }

    private void setRightLine(Line l) {
        rightLine = l;
    }

    public void setOwner(Player p) {
        owner = p;
    }
    
    /**
     * Teilt der Box einen Besitzer zu, insofern die Box komplett ist.
     * @param p 
     */
    public void updateOwner (Player p) {
        System.out.println("update Owner called");

        if(isBoxComplete()) {
            owner = p;
            p.plusBox();
            System.out.println("Box owner set to" + p);
 
        }
    }

}
