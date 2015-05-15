/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

/**
 *
 * @author tobias
 */
public class Box {
    
    private final int boxNumber;
    private Line topLine;
    private Line bottomLine;
    private Line leftLine;
    private Line rightLine;
    private boolean isComplete;
    private int numberOfLines;
    private Player owner;
    
    public Box (int boxNumber){
        this.boxNumber = boxNumber;
        isComplete = false;
        numberOfLines = 0;
    }
    public Box (int boxNumber, Line top, Line bottom, Line left, Line right) {
        this.boxNumber = boxNumber;
        setTopLine(top);
        setBottomLine(bottom);
        setLeftLine(left);
        setRightLine(right);
    }
    
    
    /**
     * Getter methods für Attribute
     */
    public Player getOwner() {
        return owner;
    }
    
    public Line getLeftLine () {
        return leftLine;
    }
    
    public Line getRightLine () {
        return rightLine;
    }
    
    public Line getBottomLine () {
        return bottomLine;
    }
    
    public Line getTopLine () {
        return topLine;
    }
    
    public boolean isBoxComplete() {
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
        numberOfLines++;
    }
    
    private void setTopLine(Line l) {
        topLine = l;
        numberOfLines++;
    }
    
    private void setLeftLine(Line l) {
        leftLine = l;
        numberOfLines++;
    }
    
    private void setRightLine(Line l) {
        rightLine = l;
        numberOfLines++;
    }
    
    public void setOwner(Player p) {
        owner = p;
    }
    
    
    
}
