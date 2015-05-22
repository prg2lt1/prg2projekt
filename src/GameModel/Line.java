/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;


/**
 *
 * @author tobias
 * 
 */
public class Line {
    
   
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
        return owner;
    }
    
    public Box getFirstTouchingBox() {
        return partOfBox1;
    }
    
    public Box getSecondTouchingBox() {
        return partOfBox2;
    }
    
    public void setFirstTouchingBox(Box first) {
      
        partOfBox1 = first;
        
    }
    
     public void setSecondTouchingBox(Box second) {
      
        partOfBox2 = second;
        
    }
    
   
    
    public int getCoordinates() {
        return Integer.parseInt(String.valueOf(startingDot+""+endingDot));
    }
   
    
}
