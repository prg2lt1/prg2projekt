/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import java.io.Serializable;


/**
 *
 * @author tobias
 * 
 */
public class Line implements Serializable {
    
   
    private final Dot startingDot;
    private final Dot endingDot;
    private Player owner;
    private Box partOfBox1;
    private Box partOfBox2;
  
   
    /**
     * 
     * @param start Zeilennummer-Spaltennummer des Startpunktes (ganz oben links wäre 11)
     * @param end Zeilennummer-Spaltennummer des Endpunktes (ganz unten links wäre n1)
     */
    public Line(Dot start, Dot end) {
        
        startingDot = start;
        endingDot = end;
        owner = null;
        partOfBox1 = null;
        partOfBox2 = null;
      
    }    
    
    public void setOwner (Player p) {
        System.out.println("[debug (Line)] set owner: " + p);
        this.owner = p;
    }
    
    public Dot getStartingDot() {
        return startingDot;
    }
    
    public int getStartingDotX() {
        return startingDot.getX();
    }
    
    public int getStartingDotY() {
        return startingDot.getY();
    }
    
    public Dot getEndingDot() {
        return endingDot;
    }
    
    public int getEndingDotX() {
        return endingDot.getX();
    }
    
    public int getEndingDotY() {
        return endingDot.getY();
    }
    
    public Player getOwner() {
        return this.owner;
    }
    
    public Box getFirstTouchingBox() {
        return this.partOfBox1;
    }
    
    public Box getSecondTouchingBox() {
        return this.partOfBox2;
    }
    
    public void setFirstTouchingBox(Box first) {
        this.partOfBox1 = first;
    }
    
     public void setSecondTouchingBox(Box second) {
        this.partOfBox2 = second;
    }
     
    public int getCoordinates() {
        return Integer.parseInt(String.valueOf(startingDot+""+endingDot));
    }
   
    
}
