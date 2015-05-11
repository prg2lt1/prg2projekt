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
    
    private final int position;
    private Line topLine;
    private Line bottomLine;
    private Line leftLine;
    private Line rightLine;
    private boolean isComplete;
    private int numberOfLines;
    private Player owner;
    
    public Box (int position){
        this.position = position;
        isComplete = false;
        numberOfLines = 0;
    }
    public Box (int position, Line top, Line bottom, Line left, Line right) {
        this.position = position;
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
