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
  
   
    /**
     * 
     * @param start Zeilennummer-Spaltennummer des Startpunktes (ganz oben links wäre 11)
     * @param end Zeilennummer-Spaltennummer des Endpunktes (ganz unten links wäre n1)
     */
    public Line(Dot start, Dot end) {
        
        startingDot = start;
        endingDot = end;
        owner = null;
      
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
    
   
    
    public int getCoordinates() {
        return Integer.parseInt(String.valueOf(startingDot+""+endingDot));
    }
   
    
}
