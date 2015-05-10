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
    
    
    
    public Dot getStartingDot() {
        return startingDot;
    }
    
    public Dot getEndingDot() {
        return endingDot;
    }
    
    public int getCoordinates() {
        return Integer.parseInt(String.valueOf(startingDot+""+endingDot));
    }
   
    
}
