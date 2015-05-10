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
 * Erstellt neue Linie mit Anfangs- und Endpunkt sowie Angaben zur spielenden Partei und somit zur Farbe der Linie.
 */
public class Line {
    
   
    private final int startingDot;
    private final int endingDot;
    private Player owner;
  
   
    /**
     * 
     * @param start Zeilennummer-Spaltennummer des Startpunktes (ganz oben links wäre 11)
     * @param end Zeilennummer-Spaltennummer des Endpunktes (ganz unten links wäre n1)
     */
    public Line(int start, int end) {
        
        startingDot = start;
        endingDot = end;
        owner = null;
      
    }
    
    
    
    public int getStartingDot() {
        return startingDot;
    }
    
    public int getEndingDot() {
        return endingDot;
    }
    
    public int getCoordinates() {
        return Integer.parseInt(String.valueOf(startingDot+""+endingDot));
    }
   
    
}
