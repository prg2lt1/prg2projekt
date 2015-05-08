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
    
    private Line topLine;
    private Line bottomLine;
    private Line leftLine;
    private Line rightLine;
    private boolean isComplete;
    private int numberOfLines;
    private Player owner;
    
    public Box (){
        isComplete = false;
        numberOfLines = 0;
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
    
    
    /**
     * Setter methods für Attribute
     */
    public void setBottomLine(Line l) {
        bottomLine = l;
        numberOfLines++;
    }
    
    public void setTopLine(Line l) {
        topLine = l;
        numberOfLines++;
    }
    
    public void setLeftLine(Line l) {
        leftLine = l;
        numberOfLines++;
    }
    
    public void setRightLine(Line l) {
        rightLine = l;
        numberOfLines++;
    }
    
    public void setOwner(Player p) {
        owner = p;
    }
    
    
    
}